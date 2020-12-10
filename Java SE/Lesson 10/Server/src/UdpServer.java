import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) {
        final int PORT = 50000;
        final String WELCOME_MSG = "Welcome, %s";

        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            byte[] buff = new byte[65536];
            DatagramPacket packet = new DatagramPacket(buff, buff.length);

            System.out.println("Сервер запущен!Ожидание сообщений...");
            int counter = 0;
            while(true){
                //ожидание получения данных
                socket.receive(packet);
                byte[] data = packet.getData();
                counter++;
                System.out.println(String.format("Counter = %d", counter));
                /*byte[] data = packet.getData();
                String clientName = new String(data, 0, packet.getLength());
                System.out.println("Server receive: " + clientName);

                //отправка данных клиенту
                String sendMsg = String.format(WELCOME_MSG, clientName);
                byte[] sendBuff = sendMsg.getBytes();

                //пакет отправки данных
                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuff,
                        sendBuff.length,
                        packet.getAddress(),
                        packet.getPort()
                );

                socket.send(sendPacket);*/
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
