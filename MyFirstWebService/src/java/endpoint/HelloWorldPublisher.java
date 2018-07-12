package endpoint;

import ws.HelloWorldImpl;
import javax.xml.ws.Endpoint;

//EndPoint publisher
public class HelloWorldPublisher {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8094/ws/hello", new HelloWorldImpl());
    }
}
