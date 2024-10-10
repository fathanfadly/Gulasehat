/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tebakbaku;

/**
 *
 * @author syuja
 */
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Leaderboard extends javax.swing.JFrame {

    /**
     * Creates new form Leaderboard
     */
    public Leaderboard() {
        initComponents();
        displayLeaderboard();
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
        LeaderboardLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BackToMenu = new javax.swing.JLabel();
        InvisibleRight = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(78, 110, 129));

        LeaderboardLogo.setBackground(new java.awt.Color(157, 178, 191));
        LeaderboardLogo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LeaderboardLogo.setForeground(new java.awt.Color(255, 255, 255));
        LeaderboardLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LeaderboardLogo.setText("Leaderboard");

        jScrollPane1.setBackground(new java.awt.Color(46, 56, 64));
        jScrollPane1.setForeground(new java.awt.Color(46, 56, 64));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jTable1.setBackground(new java.awt.Color(46, 56, 64));
        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Name", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setGridColor(new java.awt.Color(46, 56, 64));
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(5);
        jTable1.setSelectionBackground(new java.awt.Color(62, 75, 86));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        BackToMenu.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        BackToMenu.setForeground(new java.awt.Color(255, 255, 255));
        BackToMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakbaku/image/icons8-back-15.png"))); // NOI18N
        BackToMenu.setText("Back To Menu");
        BackToMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackToMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackToMenuMouseClicked(evt);
            }
        });

        InvisibleRight.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        InvisibleRight.setForeground(new java.awt.Color(255, 255, 255));
        InvisibleRight.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InvisibleRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InvisibleRightMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BackToMenu)
                        .addGap(18, 18, 18)
                        .addComponent(LeaderboardLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InvisibleRight, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LeaderboardLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InvisibleRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(BackToMenu)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackToMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToMenuMouseClicked
        FrameManager.navigateToMenu(this);
    }//GEN-LAST:event_BackToMenuMouseClicked

    private void InvisibleRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvisibleRightMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_InvisibleRightMouseClicked
    
    private void displayLeaderboard() {
        // Fetch leaderboard data from the database
        List<LeaderboardEntry> leaderboardEntries = DatabaseHandler.getLeaderboard();

        // Populate the table with the fetched data
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (int i = 0; i < leaderboardEntries.size(); i++) {
            LeaderboardEntry entry = leaderboardEntries.get(i);
            Object[] rowData = {i + 1, entry.getUsername(), entry.getScore()};
            model.addRow(rowData);
        }

        // Customize the table header
        jTable1.getTableHeader().setBackground(new java.awt.Color(46, 56, 64)); // Set background color
        jTable1.getTableHeader().setForeground(new java.awt.Color(255, 255, 255)); // Set text color
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI Semibold", java.awt.Font.PLAIN, 14)); // Set font

        // Create a DefaultTableCellRenderer object
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        // Set the alignment to center
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // Set the renderer for each column in the table
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Check if there are no rows in the table
        if (model.getRowCount() == 0) {
            // Set the background color to match the table color
            jTable1.setBackground(new java.awt.Color(46, 56, 64));
        } else {
            // Set the default background color
            jTable1.setBackground(new java.awt.Color(46, 56, 64));
        }
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackToMenu;
    private javax.swing.JLabel InvisibleRight;
    private javax.swing.JLabel LeaderboardLogo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables





}

