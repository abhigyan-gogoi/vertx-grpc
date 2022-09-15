package org.pupu.vertx_grpc;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

public class Runner {

  private static final String VERTX_GRPC_DIR = "vertx-grpc" + "/src/main/java/";

  public static void runExample(Class clazz) {
    runExample(VERTX_GRPC_DIR, clazz, new VertxOptions(), null);
  }

  public static void runExample(Class clazz, DeploymentOptions options) {
    runExample(VERTX_GRPC_DIR, clazz, new VertxOptions(), options);
  }

  public static void runExample(String dir, Class clazz, VertxOptions options, DeploymentOptions
    deploymentOptions) {
    runExample(dir + clazz.getPackage().getName().replace(".", "/"), clazz.getName(), options, deploymentOptions);
  }

  public static void runExample(String dir, String verticleID, VertxOptions options, DeploymentOptions deploymentOptions) {
    if (options == null) {
      // Default parameter
      options = new VertxOptions();
    }
    // Smart cwd detection
    // Based on the current directory (.), we try to compute the vertx.cwd
    // directory:
    try {
      // We need to use the canonical file. Without the file name is .
      File current = new File(".").getCanonicalFile();
      if (dir.startsWith(current.getName()) && !dir.equals(current.getName())) {
        dir = dir.substring(current.getName().length() + 1);
      }
    } catch (IOException e) {
      // Ignore it.
    }
    System.setProperty("vertx.cwd", dir);
    Consumer<Vertx> runner = vertx -> {
      try {
        if (deploymentOptions != null) {
          vertx.deployVerticle(verticleID, deploymentOptions);
        } else {
          vertx.deployVerticle(verticleID);
        }
      } catch (Throwable t) {
        t.printStackTrace();
      }
    };
    Vertx vertx = Vertx.vertx(options);
    runner.accept(vertx);
  }
}
