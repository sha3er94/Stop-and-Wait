/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogrammingudp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mohamed El-Shaer
 */
public class GUIserver extends javax.swing.JFrame {

    /**
     * Creates new form GUIserver
     */
    DatagramSocket serverSocket;
    public GUIserver() {
        initComponents();
        this.setLocationRelativeTo(null);
        JRootPane rootPane = SwingUtilities.getRootPane(jButton1); 
        rootPane.setDefaultButton(jButton1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        jButton1.setText("Run");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Notice : To get The Output You Should Click 'Run' in Client After Clicking 'Run' in Server");

        jLabel2.setText("Status :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {GUIclient gui = new GUIclient();
        gui.clientSocket.disconnect();
        System.exit(0);}
        catch (Exception e)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try{
        serverSocket.close();
        }
        catch(Exception e){}
        this.setVisible(false);
        new GUIserver().setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {                                         
            jButton1.setEnabled(false); 
            PrintStream printStream = new PrintStream(new CustomOutputStream(jTextArea1));
            System.setOut(printStream);
            System.setErr(printStream);
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
                double plp = 0.2;
                //double plp = z / 10.0;
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
                                System.out.println("Timed out " + i );
                                i--;
                                break;
                            }
                        }
                        
                    }

                }
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(GUIserver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUIserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIserver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
