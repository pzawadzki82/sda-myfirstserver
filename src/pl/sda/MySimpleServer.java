package pl.sda;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MySimpleServer {
    public static final int PORT = 9992;

    public static void main(String[] args) {
	    try(ServerSocket serverSocket = new ServerSocket(PORT)) {
	        System.out.println("SERVER STARTED ON PORT: " + PORT);
            Socket socketConnection = serverSocket.accept();

            InputStream is = socketConnection.getInputStream();
            OutputStream os = socketConnection.getOutputStream();

            Scanner scanner = new Scanner(is, "UTF-8");
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
            serverPrintOut.println("Hello World! Please enter your name.");

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("SERVER RECEIVED: " + line);
                serverPrintOut.println("Echo from MySimpleServer: " + line);

                if(line.toLowerCase().trim().equals("stop")) {
                    System.out.println("SERVER COMMAND RECEIVED. Exiting...");
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
