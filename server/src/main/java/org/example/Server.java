package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int SERVER_PORT = 8180;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)){
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client is online!");

            while (true){
                String msg = in.readUTF();
                System.out.println("Message from client: "+ msg);
                out.writeUTF("ECHO: "+ msg);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
