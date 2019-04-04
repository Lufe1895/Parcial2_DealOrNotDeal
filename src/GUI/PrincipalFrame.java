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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author luisl
 */
public class PrincipalFrame extends JFrame{
    private JButton btnPlay;
    
    private JPanel pnlButton;
    private JPanel pnlBackground;
    
    private JLabel lblTitle;
    
    public PrincipalFrame(){
        super("Deal Or Not Deal");
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600,500);
        //super.setLayout(new BorderLayout());
        pnlBackground = new JPanel(new BorderLayout());
        pnlBackground.setBackground(Color.BLACK);
        
        lblTitle = new JLabel();
        getContentPane().add(lblTitle);
        addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent ev){
                Image picture = new ImageIcon(getClass().getResource("../Images/giphy.gif")).getImage();
                lblTitle.setIcon(new ImageIcon(picture.getScaledInstance(ev.getComponent().getWidth(),ev.getComponent().getHeight(), Image.SCALE_DEFAULT)));
            }
        });
                
        lblTitle.setFont(new Font("Mesquite Std",0,64));
        lblTitle.setForeground(Color.YELLOW);
        
        super.setBackground(Color.BLACK);
        
        btnPlay = new JButton("PLAY!");
        btnPlay.setForeground(Color.CYAN);
        btnPlay.setFont(new Font("Goudy Old Style",4,28));
        btnPlay.setPreferredSize(new Dimension(150,50));
        btnPlay.setBackground(Color.BLACK);
        
        btnPlay.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
            }
            
        });
        
        pnlButton = new JPanel(new FlowLayout());
        pnlButton.add(btnPlay);
        pnlButton.setBackground(Color.BLACK);
        super.add(pnlBackground,BorderLayout.CENTER);
        super.add(pnlButton,BorderLayout.NORTH);
        pnlBackground.add(lblTitle,BorderLayout.CENTER);
        
        //----------------------------------------------------------------------
        
    }
}
