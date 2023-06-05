/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

/**
 *
 * @author talha
 */
import App.ChatApp;
import Message.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static chatclient.Client.sInput;

// thread which is listening messages from server
class Listen extends Thread {

    public void run() {
        while (Client.socket.isConnected()) {
            try {
                //waiting for message
                Message received = (Message) (sInput.readObject());
                //if message came, check the type of message
                switch (received.type) {
                    case Connect:
                        String newUser = received.content.toString();
                        ChatApp.myApp.userModel.addElement(newUser);
                        break;
                    case GroupCreated:
                        String newGroup = received.content.toString();
                        ChatApp.myApp.groupModel.addElement(newGroup);
                        break;
                    case GetOldUsers:
                        String oldUser = received.content.toString();
                        ChatApp.myApp.userModel.addElement(oldUser);
                        break;
                    case GetOldGroups:
                        String oldGroup = received.content.toString();
                        ChatApp.myApp.groupModel.addElement(oldGroup);
                        break;
                }

            } catch (IOException ex) {

                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                break;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }

    }
}

public class Client {

    public static Socket socket;              // every clients need socket
    public static ObjectInputStream sInput;   // for get the content
    public static ObjectOutputStream sOutput; // for send the content
    public static Listen listenMe;            // thread of listening the server

    public static void Start(String ip, int port) {
        try {
            Client.socket = new Socket(ip, port);
            Client.Display("Servera bağlandı");
            Client.sInput = new ObjectInputStream(Client.socket.getInputStream());
            Client.sOutput = new ObjectOutputStream(Client.socket.getOutputStream());
            Client.listenMe = new Listen();
            Client.listenMe.start(); // start listening thread

            //sending name to server
            Message msg = new Message(Message.Message_Type.Connect);
            msg.content = ChatApp.myApp.txtb_userName.getText();
            Client.Send(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // for stop the client
    public static void Stop() {
        try {
            if (Client.socket != null) {
                Client.listenMe.stop();
                Client.socket.close();
                Client.sOutput.flush();
                Client.sOutput.close();

                Client.sInput.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Display(String msg) {
        System.out.println(msg);
    }

    public static void Send(Message msg) { // message sending function
        try {
            Client.sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
