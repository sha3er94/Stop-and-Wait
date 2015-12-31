package socketprogrammingudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSend extends Thread
{
    public String names;
    public TestSend(String name)
    {
       this.names=name;
    }

   public void run()
   {
        try {
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            String request = "request";
            sendData = request.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            DatagramSocket clientSocket = new DatagramSocket();
            DatagramSocket bb3tSocket = new DatagramSocket();
            byte[] newData2 = new byte[1024];
            if (names.equals("receive")) {
            } else {
                System.out.println("ana hena wa2fa mstnya arecieve 7aga msh mab3ota");
            }
                DatagramPacket receivePacket = new DatagramPacket(newData2, newData2.length, IPAddress, 9875);
                clientSocket.receive(receivePacket);
                System.out.println("ana keda waslt ll ana 3aizah");
                bb3tSocket.send(sendPacket);
                 clientSocket.close();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(TestSend.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestSend.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
    public static void main(String args[]) throws Exception 
    {
        String rec="recieve";
        String se="send";
        long s=System.currentTimeMillis();
        while (System.currentTimeMillis()-s<10)
            {
           Thread t = new TestSend(rec);
            t.run();
            Thread g= new TestSend(se);
            g.run();
          }
        
    }
}