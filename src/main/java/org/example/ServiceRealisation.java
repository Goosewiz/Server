package org.example;
import com.example.grpc.ServiceGrpc;
import com.example.grpc.ServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class ServiceRealisation extends ServiceGrpc.ServiceImplBase{
    @Override
    public void exchange(ServiceOuterClass.IncomingRequest request, StreamObserver<ServiceOuterClass.OutgoingResponse> responseObserver){
        System.out.println(request);
        ServiceOuterClass.OutgoingResponse response =  ServiceOuterClass.OutgoingResponse.newBuilder().setAnswer("Hello, " + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
