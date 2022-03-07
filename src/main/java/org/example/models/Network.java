package org.example.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {

    private final String DEFAULT_HOST = "localhost";
    private final int DEFAULT_PORT = 8180;
    private String host;
    private int port;

    private DataInputStream in;
    private DataOutputStream out;

    public Network() {
        this.host = DEFAULT_HOST;
        this.port = DEFAULT_PORT;
    }

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect(){
    Socket socket = null;
    try{
        socket = new Socket(host,port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException e){
        e.printStackTrace();
        System.out.println("No connection to server.");
    }


}
}
