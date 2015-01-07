/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diapovision;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import layout.VerticalFlowLayout;

/**
 *
 * @author arthur
 */
public class JpViniette extends javax.swing.JPanel {
    
    private JpImage pImg;
    
    public JpImage getPImg(){
        return pImg;
    }

    static void deleteSelected(JPanel panelListe) {
        final Component[] components = panelListe.getComponents();
        for(Component c : components){
            if(c instanceof JpViniette){
                JpViniette v = (JpViniette) c;
                if(v.selected){
                    panelListe.remove(c);
                }
            }
        }
    }
   
    protected boolean selected = false;
    
    
    
    public JpViniette(JpImage p) {
        this();
        pImg = p;
        panelBouton.setLayout(new VerticalFlowLayout());
        p.redimention(250,200);
        panelImage.setBorder(BorderFactory.createRaisedBevelBorder());
        panelImage.add(p);
        panelImage.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(selected = !selected){
                    panelImage.setBorder(BorderFactory.createLoweredBevelBorder());
                }else{
                    panelImage.setBorder(BorderFactory.createRaisedBevelBorder());
                }
            }
            
});
    }
    public JpViniette() {
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

        panelBouton = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelImage = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jButton1.setText("Monter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelBouton.add(jButton1);

        jButton2.setText("Descendre");
        panelBouton.add(jButton2);

        add(panelBouton, java.awt.BorderLayout.WEST);

        panelImage.setLayout(new javax.swing.BoxLayout(panelImage, javax.swing.BoxLayout.LINE_AXIS));
        add(panelImage, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel panelBouton;
    private javax.swing.JPanel panelImage;
    // End of variables declaration//GEN-END:variables
}
