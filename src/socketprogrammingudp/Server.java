package socketprogrammingudp;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

class Server extends Thread {

    public Server(int port) throws IOException {
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    public static void main(String args[]) throws Exception {
        int seqnumber;
        ArrayList<String> mai3 = new ArrayList<String>();
        File mai4 = new File("server.in.txt");
        try {
            Scanner mai5 = new Scanner(mai4);
            while (mai5.hasNextLine()) {
                mai3.add(mai5.nextLine());
            }
            System.out.println(mai3);
            mai5.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(mai3.get(0)));
        byte[] receiveData = new byte[1024];
        byte[] receiveAck = new byte[1024];
        ArrayList<String> dist = new ArrayList<String>();
        ByteReadAndWrite read = new ByteReadAndWrite();
        ArrayList<String> mai2 = new ArrayList<String>();
        File mai = new File("client.in.txt");
        try {
            Scanner mai1 = new Scanner(mai);
            while (mai1.hasNextLine()) {
                mai2.add(mai1.nextLine());
            }
            //   System.out.println(mai2);
            mai1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dist = read.readAndFragment(mai2.get(3), 512);
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            try {
                serverSocket.receive(receivePacket);
                String mayar = new String(receivePacket.getData());
                System.out.println("EL GALI : " + mayar);
            } catch (Exception e) {
                break;
            }
            Hashtable<Integer, Integer> numbers;
            numbers = new Hashtable<Integer, Integer>();
            Random rand = new Random();
            int z = rand.nextInt(10);
            System.out.println(z);
           // double plp = Double.parseDouble(mai3.get(1));
            double plp = 0.3;
            // System.out.println(plp);
            int loss = (int) (dist.size() * plp);
            System.out.println(loss);
            int RandomNumber1;
            for (int i = 0; i < loss; i++) {
                while (!numbers.contains(RandomNumber1 = rand.nextInt((dist.size())))) {
                    numbers.put(RandomNumber1, RandomNumber1);
                    break;
                }
            }
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            if (port < 1024 || port > 65536) {
                break;
            }
            DatagramPacket receiveAc = new DatagramPacket(receiveAck, receiveAck.length, IPAddress, port);
            int mt = dist.size();
            String g = "" + mt;
            byte[] result = g.getBytes();
            DatagramPacket sendsize = new DatagramPacket(result, result.length, IPAddress, port);
            serverSocket.send(sendsize);
            for (int i = 0; i < dist.size(); i++) {
                if (!numbers.contains(i)) {
                    String m = dist.get(i);
                    seqnumber = i;
                    String I = "" + "@#%" + i;
                    RandomAccessFile f = new RandomAccessFile(m, "r");
                    byte[] b = new byte[(int) f.length() + 1];
                    byte[] l = I.getBytes();
                     byte[] destination = new byte[b.length + l.length];
                    System.arraycopy(b, 0, destination, 0, b.length);
                    System.arraycopy(l, 0, destination, b.length, l.length);
                    f.read(destination);
                   // f.read(b);
                   // String s = new String(b);
                    DatagramPacket sendPacket = new DatagramPacket(destination, destination.length, IPAddress, port);
                    serverSocket.send(sendPacket);
                    System.out.println("Packet number  " + i + " etb3tt mn el server");
                    while (true) {
                        try {
                            serverSocket.setSoTimeout(2000);
                            serverSocket.receive(receiveAc);
                            String e = new String(receiveAc.getData()).trim();
                            int r;
                            try {
                                r = Integer.parseInt(e);
                            } catch (Exception u) {
                                r = 0;
                            }
                            if (r != i) {
                                System.out.println(" server mawslosh ack bta3 " + i);
                                i--;
                                break;
                            } else {
                                System.out.println("Acknowledgment Number " + r+" waslt");
                                break;
                            }
                        } catch (SocketTimeoutException e) {
                            System.out.println("Ack number "+i +" Timed Out");
                            i--;
                            // System.out.println("Da5al f l catch"); // resend
                        }
                    }
                } else {
                    numbers.remove(i);
                    System.out.println("Packet rakam " + i + " El Server w23ha");
                    while (true) {
                        try {
                            serverSocket.setSoTimeout(1000);
                            serverSocket.receive(receiveAc);
                        } catch (SocketTimeoutException e) {
                            // serverSocket.setSoTimeout(1000);
                            System.out.println("Timed out " + i +"acknowlgment is not sent");
                            i--;
                            break;
                        }
                    }

                }

            }
        }
    }

}
