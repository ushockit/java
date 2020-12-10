import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        final int PORT = 50000;
        final String HOST = "127.0.0.1";
        final int BUFF_SIZE = 65536;

        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter your name: ");
//        String clientName = scanner.nextLine();

        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();

            //отправка сообщения на сервер
            /*byte[] sendBuff = clientName.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuff,
                    sendBuff.length,
                    InetAddress.getByName(HOST),
                    PORT
            );
            socket.send(sendPacket);*/

            //отправка изображения
            try {
                byte[] imgBuff = extractBytes("C:\\Users\\us\\Desktop\\Java\\java-logo.jpg");
                List<byte[]> chunks = chunkArray(imgBuff, 10000);
                int counter = 0;
                for (byte[] chunk : chunks) {
                    DatagramPacket sp = new DatagramPacket(
                            chunk,
                            chunk.length,
                            InetAddress.getByName(HOST),
                            PORT
                    );

                    socket.send(sp);
                    System.out.println(String.format("Пакет #%d отправлен", ++counter));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            //while(true){
                //получение данных от сервера
                /*byte[] buff = new byte[BUFF_SIZE];
                DatagramPacket packet = new DatagramPacket(buff, buff.length);

                socket.receive(packet);

                byte[] receiveBuff = packet.getData();
                String receiveMsg = new String(receiveBuff, 0, packet.getLength());

                System.out.println("Client receive: " + receiveMsg);*/


            //}
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static byte[] extractBytes (String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return data.getData();
    }

    static List<byte[]> chunkArray(byte[] arr, int chunkSize) {
        List<byte[]> lst = new ArrayList<>();

        int totalSize = arr.length;
        int offset = 0;
        while(totalSize > 0){
            if (totalSize - chunkSize > 0) {
                lst.add(Arrays.copyOfRange(arr, offset, offset + chunkSize));

            }
            else {
                chunkSize = arr.length % chunkSize;
                lst.add(Arrays.copyOfRange(arr, offset, offset + chunkSize));
                int a = 0;
            }
            totalSize -= chunkSize;
            offset += chunkSize;
        }
        return lst;
    }
}
