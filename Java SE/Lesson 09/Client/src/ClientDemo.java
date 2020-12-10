import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
    public static void main(String[] args) {
        //System.out.println("Hello from Client");
        final int PORT = 50000;
        final String HOST = "127.0.0.1";

        Socket socket = null;
        try {
            socket = new Socket(HOST, PORT);
        }
        catch (UnknownHostException e) {
            System.out.println("Хост не найден");
            System.exit(-1);
        }
        catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Ошибка подключения");
            System.exit(-1);
        }

        //Отправка сообщения на сервер
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Не возможнон получить поток вывода");
            System.exit(-1);
        }
        try {
            dos.writeUTF("Hello server! I`am new client!!!");
            System.out.println("Сообщение успешно отправлено!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Не возможно получить поток ввода");
            System.exit(-1);
        }

        //чтение сообщения сервера
        try {
            String data = dis.readUTF();
            System.out.println(data);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Ошибка чтения сообщения от сервера");
        }
    }
}
