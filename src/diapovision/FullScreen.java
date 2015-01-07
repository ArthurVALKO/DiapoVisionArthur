/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diapovision;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.BorderFactory;

/**
 *
 * @author arthur
 */
public class FullScreen extends javax.swing.JFrame {
    JpImage img;
    private JpImage[] imgs;
    /**
     * Creates new form FullScreen
     */
    public FullScreen() {
        initComponents();
    }

    public void start(){
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        this.setBounds(maximumWindowBounds);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        diapo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        prev.setText("<");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });
        buttonPanel.add(prev);

        next.setText(">");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        buttonPanel.add(next);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(diapo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        int pos = getPos();
        if(pos>=imgs.length-1)pos = -1;
        changeImage(imgs[pos+1]);
    }//GEN-LAST:event_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        int pos = getPos();
        if(pos<=0)pos = imgs.length;
        changeImage(imgs[pos-1]);
    }//GEN-LAST:event_prevActionPerformed

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
            java.util.logging.Logger.getLogger(FullScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FullScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FullScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FullScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FullScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel diapo;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    // End of variables declaration//GEN-END:variables

    void setImages(JpImage[] imgs) {
        this.imgs = imgs;
        img = imgs[0];
        changeImage(img);
    }

    private int getPos() {
        for(int i = 0; i < imgs.length; i++){
            if(img == imgs[i]){
                return i;
            }
        }
        return 0;
    }

    private void changeImage(JpImage img) {
        this.diapo.remove(this.img);
        this.img = img;
        this.diapo.add(this.img);
        final int imgWidth = this.img.getImage().getWidth();
        final int diapoWidth = this.diapo.getWidth();
        final int imgHeight = this.img.getImage().getHeight();
        final int diapoHeight = this.diapo.getHeight();
        int width = Math.min(imgWidth, diapoWidth);
        int height = Math.min(imgHeight, diapoHeight);
        if(width==diapoWidth||height==diapoHeight){
            float ratio = (imgWidth*1.0f)/imgHeight;
            if(ratio>1){
                width = diapoWidth;
                height = Math.round(width/ratio);
            }else{
                height = diapoHeight;
                width = Math.round(height/ratio);
            }
        }
        this.img.redimention(width, height);
        this.diapo.doLayout();
        this.repaint();
    }
}
