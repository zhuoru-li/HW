package homework2;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("127.0.0.1", 8080);
        try {
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            Scanner cin = new Scanner(System.in);
            String words;

            while (cin.hasNext()) {
                words = cin.nextLine();
                output.println(words);

            }
            cin.close();
        } finally {
            client.close();
        }
    }
}
