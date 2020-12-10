import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        //System.out.println("Hello from Server");
        final int PORT = 50000;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Ошибка подключения");
            System.exit(-1);
        }

        Socket socket = null;
        //подключение клиента
        try {
            //ожидание подключение клиента
            socket = serverSocket.accept();
            System.out.println("Клиент подключен");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Ошибка подключения");
            System.exit(-1);
        }



        DataInputStream dis = null;

        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Невозможно получить поток ввода");
            System.exit(-1);
        }

        try {
            String data = dis.readUTF();
            System.out.println(data);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Ошибка чтения сообщения");
            System.exit(-1);
        }

        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Hello, client! I`am server!!!");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Ошибка получения потока вывода");
            System.exit(-1);
        }


    }
}
