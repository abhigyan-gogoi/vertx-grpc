package org.services;

import io.grpc.stub.StreamObserver;
import org.first.Server;
import org.first.landingPageGrpc;

public class LandingPage extends landingPageGrpc.landingPageImplBase {
  @Override
  public void showLanding(Server.LandingRequest request,
                          StreamObserver<Server.LandingResponse> responseObserver) {
    // Store request message
    String address = request.getAddress();
    String msg = request.getMsg();
    // Generate response
    Server.LandingResponse.Builder response = Server.LandingResponse.newBuilder();
    response.setResponseCode(1).setResponseMsg("Hello!");
    // Extract response
    responseObserver.onNext(response.build());
    // Disconnect terminal and connection
    responseObserver.onCompleted();
  }
}
