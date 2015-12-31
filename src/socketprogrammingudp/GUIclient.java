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
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
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
public class GUIclient extends javax.swing.JFrame {

    /**
     * Creates new form GUIclient
     */
    public DatagramSocket clientSocket;
    public GUIclient() {
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
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jButton4.setText("Open File Sent From Server");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
              System.exit(0);
        } catch (Exception e) {
              System.exit(0);
        }
 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        clientSocket.close();
        }
        catch(Exception e){}
        this.setVisible(false);
        new GUIclient().setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{                                         
            jButton1.setEnabled(false); 
            PrintStream printStream = new PrintStream(new CustomOutputStream(jTextArea1));
            System.setOut(printStream);
            System.setErr(printStream);
            ArrayList<String> mai2 = new ArrayList<String>();
            File mai = new File("client.in.txt");
            try{
                Scanner mai1 = new Scanner(mai);
                while(mai1.hasNextLine()){
                    mai2.add(mai1.nextLine());
                    
                }
                //System.out.println(mai2);
                mai1.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(mai2.get(0));
            byte[] sendData = new byte[1024];
            byte[] sendack = new byte[1024];
            String request = mai2.get(3);
            int SeqNumber;
            sendData = request.getBytes();
            byte[] newData = new byte[1024];
            byte[] newData2 = new byte[1024];
            byte[] mayar4 = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(newData, newData.length, IPAddress, Integer.parseInt(mai2.get(1)));
            DatagramPacket receivesize = new DatagramPacket(newData2, newData2.length, IPAddress, Integer.parseInt(mai2.get(1)));
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(mai2.get(1)));
            clientSocket.send(sendPacket);
            clientSocket.receive(receivesize);
            String size = new String(receivesize.getData()).trim();
            int siz = Integer.parseInt(size);
            PrintWriter x=null;
            x = new PrintWriter("new.txt", "UTF-8");
            DatagramPacket sendAck;
            Hashtable<Integer,Integer> numbers;
            numbers = new Hashtable<Integer,Integer>();
            LinkedHashMap<Integer, String> eldata = new LinkedHashMap<Integer, String>();
            Random rand = new Random();
            int z=rand.nextInt(10);
            System.out.println(z);
            double plp =z/10.0;
            System.out.println(plp);
            float loss=(float) (siz*plp);
            System.out.println(loss);
            int RandomNumber1;
            for (int i = 0; i < loss; i++)
            {
                while(!numbers.contains(RandomNumber1=rand.nextInt(siz)))
                {
                    numbers.put(RandomNumber1, RandomNumber1);
                    break;
                }
            }
            for (int i = 0; i <siz; i++)
            {
                for(int j=0;j<mayar4.length;j++)
                {
                    mayar4[j]=0;
                }
                String mayar = null;
                clientSocket.receive(receivePacket);
                mayar4 = receivePacket.getData();
                mayar = new String(mayar4).trim();
                String g[] = new String[2];
                g=mayar.split("@#%");
                mayar=g[0];
                try{
                    SeqNumber = Integer.parseInt(g[1].trim());
                    System.out.println("Packet number  "+g[1]+" waslt");
                }
                catch (ArrayIndexOutOfBoundsException e){
                    // System.out.println("ZEFT CATCH");
                    break;
                }
                String f= ""+SeqNumber;
                sendack= f.getBytes();
                sendAck = new DatagramPacket(sendack, sendack.length, IPAddress, Integer.parseInt(mai2.get(1)));
                if (!eldata.containsKey(SeqNumber)) {
                    System.out.println("galy packet number "+SeqNumber);
                    eldata.put(SeqNumber, mayar);
                    clientSocket.send(sendAck);
                    System.out.println("ACK " +SeqNumber+" Etb3tt");
                }
                
            }
            for (int i = 0; i < eldata.size(); i++) {
                x.print(eldata.get(i));
            }
            x.close();
            clientSocket.close();
            
            
        } catch (SocketException ex) {
            Logger.getLogger(GUIclient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GUIclient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUIclient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Runtime rt=Runtime.getRuntime();
            
            String file= "new.txt";
            
            Process p=rt.exec("notepad "+file);
        } catch (IOException ex) {
            Logger.getLogger(GUIclient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIclient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}