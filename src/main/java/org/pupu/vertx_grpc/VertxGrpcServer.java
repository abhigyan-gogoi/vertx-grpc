package org.pupu.vertx_grpc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.GrpcServerRequest;
import io.vertx.grpc.server.GrpcServerResponse;
import org.generated.landing.LandingPageGrpc;
import org.generated.landing.LandingRequest;
import org.generated.landing.LandingResponse;

public class VertxGrpcServer extends AbstractVerticle {

  private static final int httpPort = Integer
    .parseInt(System.getenv()
      .getOrDefault("HTTP_PORT", "8888")
    );


  @Override
  public void start(Promise<Void> startPromise) {
    // Create gRPC server
    GrpcServer grpcServer = GrpcServer.server(vertx);
    // Create HTTP server
    HttpServer server = vertx.createHttpServer();
    // router.route("/").handler(this::landingHandler);
    // Grpc call handler
    grpcServer.callHandler(LandingPageGrpc.getShowLandingMethod(),
      request -> request.handler(item -> landingResponse(request)));
    // Start server on port: httpPort
    // GrpcServer can be mounted as router
    server
      .requestHandler(grpcServer)
      .listen(httpPort)
      .onSuccess(httpServer -> {
          System.out.println("Vert.x/gRPC server started on port: " + httpPort);
          startPromise.complete();
        }
      )
      .onFailure(startPromise::fail);
  }
  private static void landingResponse(GrpcServerRequest<LandingRequest, LandingResponse> request) {
    // Set Grpc call handler service
    GrpcServerResponse<LandingRequest, LandingResponse> response = request.response();
    LandingResponse res = LandingResponse
      .newBuilder()
      .setResponseCode(1)
      .setResponseMsg("Received request from client")
      .build();
    response.end(res);
  }
}
