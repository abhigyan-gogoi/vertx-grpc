package org.pupu.vertx_grpc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import org.generated.landing.LandingPageGrpc;
import org.generated.landing.LandingRequest;

public class VertxGrpcClient extends AbstractVerticle {

  private static final int httpPort = Integer
    .parseInt(System.getenv()
      .getOrDefault("HTTP_PORT", "8888")
    );

  public static void main (String[] args){
    Runner.runExample(VertxGrpcClient.class);
  }

  @Override
  public void start() throws Exception {
    // Create gRPC client
    GrpcClient grpcClient = GrpcClient.client(vertx);
    // Connect to gRPC server
    SocketAddress server = SocketAddress.inetSocketAddress(httpPort, "localhost");
    grpcClient
      .request(server, LandingPageGrpc.getShowLandingMethod()).compose(request -> {
        request.end(LandingRequest
          .newBuilder()
          .setAddress("1234")
          .setMsg("Client Request")
          .build());
        return request.response().compose(response -> response.last());
      }).onSuccess(reply -> {
        System.out.println("Received :"+reply.getResponseCode()+", "+reply.getResponseMsg());
      });
  }
}
