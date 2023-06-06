/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Message.Message;
import chatclient.Client;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author talha
 */
public class ChatApp extends javax.swing.JFrame {

    /**
     * Creates new form ChatScreen
     */
    public int isUser = 0; // 0 group , 1 user
    public DefaultListModel userModel = new DefaultListModel();
    public DefaultListModel groupModel = new DefaultListModel();
    public static ChatApp myApp;
    public ArrayList<String> userArray = new ArrayList();
    public ArrayList<String> userMessageArray = new ArrayList();
    public ArrayList<String> groupArray = new ArrayList();
    public ArrayList<String> groupMessageArray = new ArrayList();
    public String getMessageGroupName = "";
    public String getMessageUserName = "";

    public ChatApp() {
        initComponents();
        myApp = this;
        jlist_activeUsers.setModel(userModel);
        jlist_activeGroups.setModel(groupModel);
    }

    public int checkUserList(String name) {
        for (int i = 0; i < userArray.size(); i++) {
            if (userArray.get(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int checkGroupList(String name) {
        for (int i = 0; i < groupArray.size(); i++) {
            if (groupArray.get(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        pnl_connect = new javax.swing.JPanel();
        txtb_userName = new javax.swing.JTextField();
        btn_connect = new javax.swing.JButton();
        txtb_createGroup = new javax.swing.JTextField();
        btn_createGroup = new javax.swing.JButton();
        pnl_userChat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlist_activeUsers = new javax.swing.JList<>();
        lbl_activeUsers = new javax.swing.JLabel();
        btn_startUserChat = new javax.swing.JButton();
        pnl_groupChat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlist_activeGroups = new javax.swing.JList<>();
        lbl_groups = new javax.swing.JLabel();
        btn_startGroupChat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(610, 450));
        setMinimumSize(new java.awt.Dimension(610, 450));
        setPreferredSize(new java.awt.Dimension(610, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pnl_main.setBackground(new java.awt.Color(204, 255, 204));
        pnl_main.setMaximumSize(new java.awt.Dimension(600, 400));
        pnl_main.setMinimumSize(new java.awt.Dimension(600, 400));
        pnl_main.setPreferredSize(new java.awt.Dimension(600, 400));

        pnl_connect.setBackground(new java.awt.Color(255, 204, 204));

        txtb_userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtb_userNameKeyReleased(evt);
            }
        });

        btn_connect.setText("Connect");
        btn_connect.setEnabled(false);
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        txtb_createGroup.setEnabled(false);
        txtb_createGroup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtb_createGroupKeyReleased(evt);
            }
        });

        btn_createGroup.setText("Create Group");
        btn_createGroup.setEnabled(false);
        btn_createGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_connectLayout = new javax.swing.GroupLayout(pnl_connect);
        pnl_connect.setLayout(pnl_connectLayout);
        pnl_connectLayout.setHorizontalGroup(
            pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_connectLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtb_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_connect)
                .addGap(121, 121, 121)
                .addComponent(txtb_createGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btn_createGroup)
                .addGap(35, 35, 35))
        );
        pnl_connectLayout.setVerticalGroup(
            pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_connectLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtb_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_connect)
                    .addComponent(txtb_createGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_createGroup))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnl_userChat.setBackground(new java.awt.Color(204, 204, 255));

        jlist_activeUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlist_activeUsers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlist_activeUsersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlist_activeUsers);

        lbl_activeUsers.setForeground(new java.awt.Color(0, 0, 0));
        lbl_activeUsers.setText("ACTIVE USERS");

        btn_startUserChat.setText("Lets Chat");
        btn_startUserChat.setEnabled(false);
        btn_startUserChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startUserChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_userChatLayout = new javax.swing.GroupLayout(pnl_userChat);
        pnl_userChat.setLayout(pnl_userChatLayout);
        pnl_userChatLayout.setHorizontalGroup(
            pnl_userChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userChatLayout.createSequentialGroup()
                .addGroup(pnl_userChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_userChatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                    .addGroup(pnl_userChatLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lbl_activeUsers)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnl_userChatLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btn_startUserChat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_userChatLayout.setVerticalGroup(
            pnl_userChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userChatLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbl_activeUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_startUserChat)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl_groupChat.setBackground(new java.awt.Color(204, 204, 255));

        jlist_activeGroups.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlist_activeGroups.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlist_activeGroupsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jlist_activeGroups);

        lbl_groups.setForeground(new java.awt.Color(0, 0, 0));
        lbl_groups.setText("GROUPS");

        btn_startGroupChat.setText("Lets Chat");
        btn_startGroupChat.setEnabled(false);
        btn_startGroupChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startGroupChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_groupChatLayout = new javax.swing.GroupLayout(pnl_groupChat);
        pnl_groupChat.setLayout(pnl_groupChatLayout);
        pnl_groupChatLayout.setHorizontalGroup(
            pnl_groupChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_groupChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_groupChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_groupChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_groupChatLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_startGroupChat)
                        .addGap(107, 107, 107))))
            .addGroup(pnl_groupChatLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(lbl_groups)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_groupChatLayout.setVerticalGroup(
            pnl_groupChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_groupChatLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_groups)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_startGroupChat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_mainLayout = new javax.swing.GroupLayout(pnl_main);
        pnl_main.setLayout(pnl_mainLayout);
        pnl_mainLayout.setHorizontalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_userChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_groupChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_mainLayout.setVerticalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addComponent(pnl_connect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_userChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_groupChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnl_main);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtb_userNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtb_userNameKeyReleased
        // TODO add your handling code here:
        if (!txtb_userName.getText().isBlank()) {
            btn_connect.setEnabled(true);
        } else {
            btn_connect.setEnabled(false);
        }
    }//GEN-LAST:event_txtb_userNameKeyReleased

    private void jlist_activeUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlist_activeUsersValueChanged
        // TODO add your handling code here:
        if (jlist_activeUsers.getSelectedIndex() == 0) {
            btn_startUserChat.setEnabled(false);
        } else {
            btn_startUserChat.setEnabled(true);

        }
    }//GEN-LAST:event_jlist_activeUsersValueChanged

    private void jlist_activeGroupsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlist_activeGroupsValueChanged
        // TODO add your handling code here:
        btn_startGroupChat.setEnabled(true);
    }//GEN-LAST:event_jlist_activeGroupsValueChanged

    private void txtb_createGroupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtb_createGroupKeyReleased
        // TODO add your handling code here:
        if (!txtb_createGroup.getText().isBlank()) {
            btn_createGroup.setEnabled(true);
        } else {
            btn_createGroup.setEnabled(false);
        }
    }//GEN-LAST:event_txtb_createGroupKeyReleased

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        // TODO add your handling code here:
        btn_connect.setEnabled(false);
        txtb_userName.setEnabled(false);
        txtb_createGroup.setEnabled(true);
        Client.Start("localhost", 2000);
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_createGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createGroupActionPerformed
        // TODO add your handling code here:
        Message msg = new Message(Message.Message_Type.GroupCreated);
        msg.content = txtb_createGroup.getText();
        Client.Send(msg);
        txtb_createGroup.setText("");
    }//GEN-LAST:event_btn_createGroupActionPerformed

    private void btn_startUserChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startUserChatActionPerformed
        // TODO add your handling code here:
        String chatPerson = jlist_activeUsers.getSelectedValue();
        ChatScreen newFrame = new ChatScreen();
        newFrame.setVisible(true);
        newFrame.lbl_chat.setText(chatPerson);
        newFrame.isUser = 1;
        int result = checkUserList(chatPerson);
        if (result == -1) {
            newFrame.txta_chat.setText("");
        } else {
            newFrame.txta_chat.setText(userMessageArray.get(result));
        }
    }//GEN-LAST:event_btn_startUserChatActionPerformed

    private void btn_startGroupChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startGroupChatActionPerformed
        // TODO add your handling code here:
        String chatGroup = jlist_activeGroups.getSelectedValue();
        ChatScreen newFrame = new ChatScreen();
        newFrame.setVisible(true);
        newFrame.lbl_chat.setText(chatGroup);
        newFrame.isUser = 0;
        int result = checkGroupList(chatGroup);
        if (result == -1) {
            newFrame.txta_chat.setText("");
        } else {
            newFrame.txta_chat.setText(groupMessageArray.get(result));
        }
    }//GEN-LAST:event_btn_startGroupChatActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Client.Stop();

    }//GEN-LAST:event_formWindowClosing

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_createGroup;
    private javax.swing.JButton btn_startGroupChat;
    private javax.swing.JButton btn_startUserChat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlist_activeGroups;
    private javax.swing.JList<String> jlist_activeUsers;
    private javax.swing.JLabel lbl_activeUsers;
    private javax.swing.JLabel lbl_groups;
    private javax.swing.JPanel pnl_connect;
    private javax.swing.JPanel pnl_groupChat;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_userChat;
    private javax.swing.JTextField txtb_createGroup;
    public javax.swing.JTextField txtb_userName;
    // End of variables declaration//GEN-END:variables
}
