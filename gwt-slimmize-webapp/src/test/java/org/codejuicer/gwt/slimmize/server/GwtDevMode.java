package org.codejuicer.gwt.slimmize.server;

import com.google.gwt.dev.codeserver.CodeServer;

public class GwtDevMode {

  public static String[] compilerOptions = new String[] {
      "-noprecompile",
      "-logLevel", "DEBUG",
      "-style", "DETAILED",
      "-workDir", "target/codeserver-workdir",
      "-launcherDir", "target/codeserver-launcherdir",
      "-sourceLevel", "1.8",
      "-XjsInteropMode", "JS",
      "-port", "9876",
      "-src", "src/main/java",
      // "-war", "target/gwt-webapp",
      "-bindAddress", "127.0.0.1",
      "org.codejuicer.gwt.slimmize.WUnit",
      "org.codejuicer.gwt.slimmize.WUnitXsiLinker"
  };

  public static void main(String[] args) throws Exception {

    // Class<?> classToCheck = WebServer.class;

    CodeServer.main(compilerOptions);
  }

}
