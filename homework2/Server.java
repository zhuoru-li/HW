package homework2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8080);
        try {
            Socket client = server.accept();
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader((client.getInputStream())));
                boolean flag = true;
                int count = 1;

                while (flag) {
                    count++;
                    String line = input.readLine();
                    if (line.equals("exit")) {
                        flag = false;
                    } else {
                        System.out.println("Client said: " + line);
                    }
                }
            } finally {
                client.close();
            }
        } finally {
            server.close();
        }
    }
}
