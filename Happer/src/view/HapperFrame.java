/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HapperFrame.java
 *
 * Created on 16-dec-2010, 12:17:58
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import model.Spel;

/**
 *
 * @author 09068007
 */
public class HapperFrame extends JFrame{

    private int xBlokken;
    private int yBlokken;
    private HapperPanel hetSpel;
    private Spel spel;
    private ConfigFrame config;


    /** Creates new form HapperFrame */
    public HapperFrame() {
        initComponents();

        spel = new Spel();        
        hetSpel = new HapperPanel(spel);
        config = new ConfigFrame(spel, this);
        
        jSpelPanel.setLayout(new BorderLayout());
        jSpelPanel.setPreferredSize(new Dimension((spel.getXHor()*40), (spel.getYVert()*40)));
        jSpelPanel.add(hetSpel, BorderLayout.CENTER);

        this.setFocusable(true);   // Allow this panel to get focus.
        
        pack();

        int delay = 4000;   // delay for 5 sec.
        int period = 1000;  // repeat every sec.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(spel.getGestart() == true){
                        spel.verplaatsHapper();
                        hetSpel.repaint();
                    }else{
                        requestFocus();
                    }
                }
            }, delay, period);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpelPanel = new javax.swing.JPanel();
        startSpel = new javax.swing.JButton();
        stopSpel = new javax.swing.JButton();
        resetSpel = new javax.swing.JButton();
        configSpel = new javax.swing.JButton();
        configSpel1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jSpelPanelLayout = new javax.swing.GroupLayout(jSpelPanel);
        jSpelPanel.setLayout(jSpelPanelLayout);
        jSpelPanelLayout.setHorizontalGroup(
            jSpelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        jSpelPanelLayout.setVerticalGroup(
            jSpelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        startSpel.setText("Start Spel");
        startSpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSpelActionPerformed(evt);
            }
        });

        stopSpel.setText("Stop Spel");
        stopSpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopSpelActionPerformed(evt);
            }
        });

        resetSpel.setText("Reset Spel");
        resetSpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSpelActionPerformed(evt);
            }
        });

        configSpel.setText("Config Spel");
        configSpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configSpelActionPerformed(evt);
            }
        });

        configSpel1.setText("Sluit Spel");
        configSpel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configSpel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSpelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(configSpel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(configSpel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetSpel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopSpel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startSpel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startSpel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopSpel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetSpel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(configSpel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(configSpel1))
                    .addComponent(jSpelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startSpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSpelActionPerformed
        // TODO add your handling code here:
        if(spel.getGestart() == false){
            spel.startSpel();
            //hetSpel.setFocusable(true);
            hetSpel.requestFocus();
        }
    }//GEN-LAST:event_startSpelActionPerformed

    private void stopSpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopSpelActionPerformed
        // TODO add your handling code here
        if(spel.getGestart() == true){
            spel.stopSpel();
            this.requestFocus();
        }
    }//GEN-LAST:event_stopSpelActionPerformed

    private void resetSpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSpelActionPerformed
        // TODO add your handling code here:
        spel.resetSpel();
        this.requestFocus();
        hetSpel.repaint();
    }//GEN-LAST:event_resetSpelActionPerformed

    private void configSpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configSpelActionPerformed
        // TODO add your handling code here:
        spel.stopSpel();
        this.setVisible(false);
        setFocusableWindowState( false );
        config.requestFocus();
        config.setOpties();
        config.setVisible(true);

    }//GEN-LAST:event_configSpelActionPerformed

    private void configSpel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configSpel1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_configSpel1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HapperFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configSpel;
    private javax.swing.JButton configSpel1;
    private javax.swing.JPanel jSpelPanel;
    private javax.swing.JButton resetSpel;
    private javax.swing.JButton startSpel;
    private javax.swing.JButton stopSpel;
    // End of variables declaration//GEN-END:variables

    public void resizeSpeelveld(int xHor, int yVert) {
        jSpelPanel.remove(hetSpel);
        jSpelPanel.setLayout(new BorderLayout());
        jSpelPanel.setPreferredSize(new Dimension((spel.getXHor()*40), (spel.getYVert()*40)));
        jSpelPanel.add(hetSpel, BorderLayout.CENTER);
        pack();
    }

}