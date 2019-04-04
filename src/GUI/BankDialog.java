/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author luisl
 */
public class BankDialog extends JDialog{
    private Integer offer;
    
    private JButton deal;
    private JButton noDeal;
    
    private JLabel title;
    private JLabel finalOffer;
    private JLabel phone;
    
    private BankDialogListener bdl;
    
    private JPanel pnlNorth;
    private JPanel pnlSouth;
    private JPanel pnlCenter;

    public BankDialog(JFrame frame,Integer offer) {
        super(frame);
        super.setLayout(new BorderLayout());
        super.setSize(600, 400);
        super.setBackground(Color.yellow);
        super.setVisible(true);
        
        pnlNorth = new JPanel(new FlowLayout());
        pnlNorth.setBackground(new Color(170,200,255));
        pnlSouth = new JPanel(new FlowLayout());
        pnlCenter = new JPanel(new GridLayout(2,1));//-----------------------------Instanciación de Paneles
        
        this.offer=offer;
        finalOffer = new JLabel("The Bank offers you $"+this.offer.toString());
        finalOffer.setFont(new Font("Mesquite Std",0,80));
        finalOffer.setForeground(Color.DARK_GRAY);
        
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("../Images/bank.png"));//----------------------Se agrega la imagen The Bank
        ImageIcon fondo2 = new ImageIcon(fondo1.getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
        title = new JLabel(fondo2);
        pnlNorth.add(title);
        
        deal=new JButton("Deal");
        deal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"CONGRATULATIONS! \n\nYou've won $"+offer,"Congratulations!",JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            
        });
        
        noDeal = new JButton("No Deal");
        noDeal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
        
        pnlSouth.add(deal);
        pnlSouth.add(noDeal);
        
        ImageIcon fondo3 = new ImageIcon(getClass().getResource("../Images/phone.png"));//----------------------Se agrega la imagen The Bank
        ImageIcon fondo4 = new ImageIcon(fondo3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        phone = new JLabel(fondo4);
        pnlCenter.add(phone);
        
        pnlCenter.add(finalOffer);
        pnlCenter.setBackground(new Color(170,200,255));
        
        pnlSouth.setBackground(new Color(170,200,255));
        
        pnlNorth.setPreferredSize(new Dimension(0,100));
        super.add(pnlNorth,BorderLayout.NORTH);
        super.add(pnlCenter,BorderLayout.CENTER);
        super.add(pnlSouth,BorderLayout.SOUTH);
    }
    
    public void setListener(BankDialogListener listener){
        
    }
}
