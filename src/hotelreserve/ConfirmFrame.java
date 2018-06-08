
package hotelreserve;

import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConfirmFrame extends javax.swing.JFrame {
    private Hotel database = new Hotel();
    private float totalFee;
    
    private int xMouse, yMouse;

    public ConfirmFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        RoomNumResults = new javax.swing.JLabel();
        roomTypeResults = new javax.swing.JLabel();
        totalFeeResults = new javax.swing.JLabel();
        RoomPriceResults1 = new javax.swing.JLabel();
        reservationDateResults = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TopPanel = new javax.swing.JPanel();
        miniLogo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 100));
        setUndecorated(true);
        setOpacity(0.0F);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(65, 64, 75));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        jPanel3.setBackground(new java.awt.Color(65, 64, 75));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/singletab_1.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 18)); // NOI18N
        jLabel3.setText("Do you want to reserve this room(s)?");

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        jLabel1.setText("Room Type(s):");

        jLabel2.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        jLabel2.setText("Room Number(s):");

        jLabel4.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        jLabel4.setText("Room Price(s) per day:");

        jLabel5.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        jLabel5.setText("Reservation Date:");

        jLabel6.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        jLabel6.setText("Total Fee:");

        okButton.setBackground(new java.awt.Color(0, 102, 102));
        okButton.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(204, 51, 0));
        cancelButton.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        RoomNumResults.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 12)); // NOI18N
        RoomNumResults.setText("Results");

        roomTypeResults.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 12)); // NOI18N
        roomTypeResults.setText("Results");

        totalFeeResults.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 12)); // NOI18N
        totalFeeResults.setText("Results");

        RoomPriceResults1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 12)); // NOI18N
        RoomPriceResults1.setText("Results");

        reservationDateResults.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 12)); // NOI18N
        reservationDateResults.setText("Results");

        codeField.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 12)); // NOI18N
        codeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codeField.setText("0");

        jLabel10.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        jLabel10.setText("Confirmation Code:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(RoomNumResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(roomTypeResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalFeeResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(RoomPriceResults1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(reservationDateResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(roomTypeResults))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RoomNumResults))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(RoomPriceResults1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(reservationDateResults))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalFeeResults))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 712, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("MIDTOWN HOTEL ONLINE RESERVATION SYSTEM © 2015 ");

        TopPanel.setBackground(new java.awt.Color(65, 64, 75));
        TopPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TopPanelMouseDragged(evt);
            }
        });
        TopPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TopPanelMousePressed(evt);
            }
        });

        miniLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/midtown2mini.png"))); // NOI18N
        miniLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniLogoMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LOGIN > PREFERENCE > RESULT > Payment > CONFIRMATION");

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x_default.png"))); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(miniLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitButton))))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(miniLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                .addComponent(exitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * When Ok button is clicked, check if the input code is valid and matches the
     * code generated by the program. If valid, save the reservation of the guest to
     * the file. If not, ask for input of code again.
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        System.out.println("Confirmation: OK");
        String inputCode =codeField.getText();
        
        try{
            System.out.println("inputCode" + inputCode);

            if(database.verifyCode(parseInt(inputCode))){
                //if confirmation code is valid 
                try {
                    database.setMyRoomReservationOK();  //saves the rooms reservation
                } catch (SQLException ex) {
                    Logger.getLogger(ConfirmFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                //loads the guest option frame
                GuestOptionFrame option = new GuestOptionFrame();
                option.dispFrame();

                this.setVisible(false);

                JOptionPane.showMessageDialog(this, "Room Reservation is successful. You can view your rooms in your account.");

            }else{  //if code is not valid
                JOptionPane.showMessageDialog(jPanel1, "Invalid confirmation code.");
                System.out.println("Invalid confirmation code.");
            }
        
        }catch(Exception e){    //if input code field is empty
           JOptionPane.showMessageDialog(jPanel1, "Invalid confirmation Code.");
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        SearchResultFrame result = null;
        result = new SearchResultFrame();
        result.displayFrame();
        
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         System.out.println("\nConfirmation Window:");
         for(double i=0.0;i<1.0;i=i+0.1){
            String val = i+"F";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(20);
            }catch(Exception e){
            
            }
        }
         
        displayResult();
    }//GEN-LAST:event_formWindowOpened

    private void TopPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_TopPanelMouseDragged

    private void TopPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_TopPanelMousePressed

    private void miniLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniLogoMouseClicked
        
        int status=0; //holds the result status of the confirmation 
        
        //show dialog box for confirmation (status = 0 - yes, 1 - no)
        status = JOptionPane.showConfirmDialog(jPanel2, "Reservation process will be canceled. Do you wish to continue?", 
                "Warning", JOptionPane.YES_NO_OPTION);
        
        if(status == 0){    //if status is yes
            GuestOptionFrame option = new GuestOptionFrame();
            option.dispFrame();
            this.setVisible(false);
            this.dispose();
        }else{
            //do nothing
        }
    }//GEN-LAST:event_miniLogoMouseClicked

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        ImageIcon extbot = new ImageIcon(getClass().getResource("/img/x_focus.png"));
        exitButton.setIcon(extbot);  
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        ImageIcon extbot = new ImageIcon(getClass().getResource("/img/x_default.png"));
        exitButton.setIcon(extbot);
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMousePressed
        ImageIcon extbot = new ImageIcon(getClass().getResource("/img/x_clicked.png"));
        exitButton.setIcon(extbot);
    }//GEN-LAST:event_exitButtonMousePressed

    private void exitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseReleased
        int status=0; //holds the result status of the confirmation 
        
        //show dialog box for confirmation (status = 0 - yes, 1 - no)
        status = JOptionPane.showConfirmDialog(jPanel1, "Do you really want to exit?", 
                "Exit", JOptionPane.YES_NO_OPTION);
        
        if(status == 0){    //if status is yes
            database.extConnection(); //close database connection
            System.out.println("status: " + status);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            System.exit(0);
        }else{
            //do nothing
        }               
    }//GEN-LAST:event_exitButtonMouseReleased


    public  void displayFrame() {
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
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        System.out.println("\nConfirmation:");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmFrame().setVisible(true);
            }
        });
    }
    
    /**
     * This will display the reservation room number, type, date
     * and total price paid by the guest.
     */
    public void displayResult(){
        int[] roomNums = new int[10];
        String roomNumResults = " ";
        int roomCounter = database.getSelectedRoomsCounter();
        roomNums = database.getGuestSelRooms();
        
        //display the room type
        roomTypeResults.setText(database.getSelectedRoomType());
        
        //display the rooms
        for(int i = 0 ; i<roomCounter ; i++){
            roomNumResults +=Integer.toString(roomNums[i]) + ", ";
        }
        
        //display the room type
        RoomNumResults.setText(roomNumResults);
        
        //display the reservation date
        reservationDateResults.setText(database.getStartMonth() + " " 
                + database.getStartDay() + ", "+ database.getStartYear() +" - "
                + database.getEndMonth() + " " +database.getEndDay() + ", "
                + database.getEndYear());
        
        System.out.println("Date of reservation: "+database.getStartMonth() + " " 
                + database.getStartDay() + ", "+ database.getStartYear()+" - "
                + database.getEndMonth() + " " +database.getEndDay() + ", "
                + database.getEndYear());
        
        //Display the reservation total fee
        RoomPriceResults1.setText(Float.toString(database.getSelectedRoomPrice())+"php");
        totalFee = database.calculateTotalFee();
        totalFeeResults.setText(Float.toString(totalFee)+"php");
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RoomNumResults;
    private javax.swing.JLabel RoomPriceResults1;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel miniLogo;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel reservationDateResults;
    private javax.swing.JLabel roomTypeResults;
    private javax.swing.JLabel totalFeeResults;
    // End of variables declaration//GEN-END:variables
}
