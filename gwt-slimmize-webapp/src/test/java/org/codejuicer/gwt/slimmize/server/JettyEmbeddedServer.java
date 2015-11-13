/*
 * Copyright 2015, Cristiano Costantini.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.codejuicer.gwt.slimmize.server;

import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.codeserver.Options;
import com.google.gwt.dev.codeserver.SuperDevModeServletCreator;

import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.IOException;

public class JettyEmbeddedServer {

  public static final int HTTP_PORT = 8082;
  public static final int HTTPS_PORT = 8443;

  public static Server createJettyServer() throws IOException, UnableToCompleteException {
    Server server = new Server();

    HttpConfiguration httpConfig = new HttpConfiguration();
    httpConfig.setSecureScheme("https");
    httpConfig.setSecurePort(HTTPS_PORT);
    httpConfig.setOutputBufferSize(32768);

    ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(httpConfig));
    http.setPort(HTTP_PORT);
    http.setIdleTimeout(30000);

    server.addConnector(http);

    Resource keystore = Resource.newClassPathResource("/keystore");
    if (keystore != null && keystore.exists()) {

      SslContextFactory factory = new SslContextFactory();
      factory.setKeyStoreResource(keystore);
      factory.setKeyStorePassword("gwtpolymer");
      factory.setTrustStoreResource(keystore);
      factory.setKeyManagerPassword("gwtpolymer");

      HttpConfiguration httpsConfig = new HttpConfiguration(httpConfig);
      httpsConfig.addCustomizer(new SecureRequestCustomizer());

      ServerConnector https =
          new ServerConnector(server, new SslConnectionFactory(factory,
              HttpVersion.HTTP_1_1.asString()), new HttpConnectionFactory(httpsConfig));
      https.setPort(HTTPS_PORT);
      https.setIdleTimeout(500000);

      server.addConnector(https);
    }

    // Temporary instruction before introducing GWT build step

    File file = new File("target/gwt-webapp/");
    file.mkdirs();
    File f1 = new File("target/codeserver-workdir");
    f1.mkdirs();
    File f2 = new File("target/codeserver-launcherdir");
    f2.mkdirs();

    ResourceCollection resources = new ResourceCollection(new String[] {
        "src/main/webapp", "target/gwt-webapp"
    });

    WebAppContext webCtx = new WebAppContext();
    webCtx.setServer(server);
    webCtx.setContextPath("/");
    // webCtx.setDescriptor("src/test/resources/web/test-web.xml");
    webCtx.setBaseResource(resources);

    Options options = new Options();

    options.parseArgs(GwtDevMode.compilerOptions);
    webCtx.addServlet(new ServletHolder(SuperDevModeServletCreator.createServlet(options)),
        "/dev-mode/*");

    server.setHandler(webCtx);

    return server;
  }

  /**
   * The main method.
   *
   * See http://www.eclipse.org/jetty/documentation/current/embedding-jetty.html
   *
   * @param args the arguments
   * @throws Exception the exception
   */
  public static void main(String[] args) throws Exception {

    Server server = createJettyServer();
    try {
      System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
      server.start();
      System.in.read();
      System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");

      server.stop();
      server.join();

    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

}
