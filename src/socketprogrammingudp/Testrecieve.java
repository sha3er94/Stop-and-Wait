package socketprogrammingudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Testrecieve 
{
    public static void main(String args[]) throws Exception 
    {
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] newData2 = new byte[1024];
        InetAddress IPAddress = InetAddress.getByName("localhost");
        while (true)
        {
            System.out.println("ana mstnya ast2bl hena");
             DatagramPacket receivePacket = new DatagramPacket(newData2, newData2.length, IPAddress, 9875);
              clientSocket.receive(receivePacket);
              String mayar = new String(receivePacket.getData());
              System.out.println("EL GALI : " + mayar);
        }
        
    }
}
