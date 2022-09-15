package org.pupu.vertx_grpc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.GrpcServerResponse;

public class Server extends AbstractVerticle {

  private static int httpPort = Integer
    .parseInt(System.getenv()
      .getOrDefault("HTTP_PORT", "8888")
    );


  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    // Create gRPC server
    GrpcServer grpcServer = GrpcServer.server(vertx);
    // Create HTTP server
    HttpServer server = vertx.createHttpServer();
    // router.route("/").handler(this::landingHandler);
    // Grpc handler


    // Start server on port: httpPort
    server
      // GrpcServer can be mounted as router
      .requestHandler(grpcServer)
      .listen(httpPort)
      .onSuccess(httpServer -> {
          System.out.println("HTTP server started on port: " + httpServer.actualPort());
          startPromise.complete();
        }
      )
      .onFailure(startPromise::fail);
  }

  private void landingHandler(RoutingContext routingContext) {
    // JSON response
    routingContext.json(
      new JsonObject()
        .put("message", "Hello! Server started at port: "+httpPort)
    );
  }
}
