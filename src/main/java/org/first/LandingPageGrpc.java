package org.first;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Services
 * Landing page service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: server.proto")
public final class LandingPageGrpc {

  private LandingPageGrpc() {}

  public static final String SERVICE_NAME = "LandingPage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.first.Server.LandingRequest,
      org.first.Server.LandingResponse> getShowLandingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowLanding",
      requestType = org.first.Server.LandingRequest.class,
      responseType = org.first.Server.LandingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.first.Server.LandingRequest,
      org.first.Server.LandingResponse> getShowLandingMethod() {
    io.grpc.MethodDescriptor<org.first.Server.LandingRequest, org.first.Server.LandingResponse> getShowLandingMethod;
    if ((getShowLandingMethod = LandingPageGrpc.getShowLandingMethod) == null) {
      synchronized (LandingPageGrpc.class) {
        if ((getShowLandingMethod = LandingPageGrpc.getShowLandingMethod) == null) {
          LandingPageGrpc.getShowLandingMethod = getShowLandingMethod = 
              io.grpc.MethodDescriptor.<org.first.Server.LandingRequest, org.first.Server.LandingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LandingPage", "ShowLanding"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.first.Server.LandingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.first.Server.LandingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LandingPageMethodDescriptorSupplier("ShowLanding"))
                  .build();
          }
        }
     }
     return getShowLandingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LandingPageStub newStub(io.grpc.Channel channel) {
    return new LandingPageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LandingPageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LandingPageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LandingPageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LandingPageFutureStub(channel);
  }

  /**
   * <pre>
   * Services
   * Landing page service
   * </pre>
   */
  public static abstract class LandingPageImplBase implements io.grpc.BindableService {

    /**
     */
    public void showLanding(org.first.Server.LandingRequest request,
        io.grpc.stub.StreamObserver<org.first.Server.LandingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getShowLandingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getShowLandingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.first.Server.LandingRequest,
                org.first.Server.LandingResponse>(
                  this, METHODID_SHOW_LANDING)))
          .build();
    }
  }

  /**
   * <pre>
   * Services
   * Landing page service
   * </pre>
   */
  public static final class LandingPageStub extends io.grpc.stub.AbstractStub<LandingPageStub> {
    private LandingPageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LandingPageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LandingPageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LandingPageStub(channel, callOptions);
    }

    /**
     */
    public void showLanding(org.first.Server.LandingRequest request,
        io.grpc.stub.StreamObserver<org.first.Server.LandingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getShowLandingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Services
   * Landing page service
   * </pre>
   */
  public static final class LandingPageBlockingStub extends io.grpc.stub.AbstractStub<LandingPageBlockingStub> {
    private LandingPageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LandingPageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LandingPageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LandingPageBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.first.Server.LandingResponse showLanding(org.first.Server.LandingRequest request) {
      return blockingUnaryCall(
          getChannel(), getShowLandingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Services
   * Landing page service
   * </pre>
   */
  public static final class LandingPageFutureStub extends io.grpc.stub.AbstractStub<LandingPageFutureStub> {
    private LandingPageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LandingPageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LandingPageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LandingPageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.first.Server.LandingResponse> showLanding(
        org.first.Server.LandingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getShowLandingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SHOW_LANDING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LandingPageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LandingPageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SHOW_LANDING:
          serviceImpl.showLanding((org.first.Server.LandingRequest) request,
              (io.grpc.stub.StreamObserver<org.first.Server.LandingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LandingPageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LandingPageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.first.Server.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LandingPage");
    }
  }

  private static final class LandingPageFileDescriptorSupplier
      extends LandingPageBaseDescriptorSupplier {
    LandingPageFileDescriptorSupplier() {}
  }

  private static final class LandingPageMethodDescriptorSupplier
      extends LandingPageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LandingPageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LandingPageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LandingPageFileDescriptorSupplier())
              .addMethod(getShowLandingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
