package com.road.thrift.demo.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

import com.road.thrift.demo.HelloWorldImpl;
import com.road.thrift.demo.HelloWorldService;

public class ThriftServerDemo {
	public final static int SERVER_PORT = 7099;
    private static String SERVER_IP = "localhost";

    public void startServer() {
        try {
            System.out.println("HelloWorld Server start...");

            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TServer.Args args = new TServer.Args(serverTransport);
            TProcessor process = new HelloWorldService.Processor(new HelloWorldImpl());
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true, true);
            args.processor(process);
            args.protocolFactory(portFactory);

            TServer server = new TSimpleServer(args);
            server.serve();

        } catch (Exception e) {
            System.out.println("Server start error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	ThriftServerDemo server = new ThriftServerDemo();
        server.startServer();
    }

}
