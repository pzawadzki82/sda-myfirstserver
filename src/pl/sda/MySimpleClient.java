package pl.sda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySimpleClient {
    public static final int PORT = 9992;
    public static final String HOST = "localhost";

    public static void main(String[] args) {


        String inLine, outLine = "Piotr Zawadzki";

        try {
            Socket s = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            inLine = in.readLine();
            System.out.println("RECEIVED: " + inLine);

            System.out.println("SEND: " + outLine);
            out.println(outLine);

            inLine = in.readLine();
            System.out.println("RECEIVED: " + inLine);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
