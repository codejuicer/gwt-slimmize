package org.codejuicer.gwt.slimmize.server;

public class GwtCompile {

  public static String[] compilerOptions = new String[] {
      "-logLevel", "DEBUG",
      "-style", "DETAILED",
      "-workDir", "target/compile-workdir",
      "-sourceLevel", "1.8",
      "-XjsInteropMode", "JS",
      "-war", "target/gwt-webapp",
      "org.codejuicer.gwt.slimmize.WUnit",
      "org.codejuicer.gwt.slimmize.WUnitXsiLinker"
  };

  public static void main(String[] args) {

    com.google.gwt.dev.Compiler.main(compilerOptions);
  }

}
