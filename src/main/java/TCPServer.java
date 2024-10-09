import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    private static final int PORT = 7;
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                pool.execute(new TCPServerUtil(socket));

            }
        } catch (IOException e) {
            System.out.println("Failed connecting to server");
        }
    }
}
