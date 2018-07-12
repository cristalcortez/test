package ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }

    @Override
    public int convertToCelsius(int f) {
        return (int) ((int)(f-32) * 0.5556);
    }

    @Override
    public int convertToFarenheit(int c) {
        return (int) ((int)(c * 1.8) + 32);
    }
    
}
