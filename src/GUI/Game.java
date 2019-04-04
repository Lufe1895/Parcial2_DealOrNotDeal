/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.Buttons;
import Objects.Images;
import Objects.Panels;
import Objects.Suitcase;
import Objects.Values;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author luisl
 */
public class Game extends JFrame {
    private JPanel pnlCenter;
    private JPanel pnlNorth;
    private JPanel pnlRight;
    private JPanel pnlLeft;
    private JPanel pnlSouth;
    private JPanel rCenter;
    
    private Images images;
    
    private JLabel title;
    private JLabel you;
    
    private Buttons buttons;
    
    private Panels values;
    
    private ArrayList<Suitcase> suitcases;
    private Values rValues;
    
    private Boolean firstOne;
    
    private Integer save;
    private Integer count;
    
    private BankDialog bd;
    
    public Game(){
        super("Deal or not Deal");
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setExtendedState(MAXIMIZED_BOTH);//-------------------------------Cosas por defecto de las ventanas
        
        count=0;
        
        pnlLeft = new JPanel(new GridLayout(13,1));
        pnlRight = new JPanel(new GridLayout(13,1));//--------------------------GridsLayout para los laterales
        pnlLeft.setBackground(Color.BLACK);
        pnlLeft.setPreferredSize(new Dimension(300,0));
        pnlRight.setBackground(Color.BLACK);
        pnlRight.setPreferredSize(new Dimension(300,0));
        
        pnlSouth = new JPanel(new FlowLayout());
        pnlSouth.setBackground(Color.BLACK);
        pnlSouth.setPreferredSize(new Dimension(0,100));
        
        pnlNorth = new JPanel(new FlowLayout());
        pnlNorth.setBackground(Color.BLACK);
        pnlNorth.setPreferredSize(new Dimension(0,100));
        
        title = new JLabel("DEAL OR NOT DEAL");
        title.setFont(new Font("Mesquite Std",0,90));
        title.setForeground(Color.ORANGE);
        pnlNorth.add(title);
        
        rCenter = new JPanel (new BorderLayout());
        
        rCenter.add(pnlNorth,BorderLayout.NORTH);
        //----------------------------------------------------------------------Añadiendo los botones al panel
        buttons = new Buttons();
        pnlCenter = new JPanel(new FlowLayout((int) RIGHT_ALIGNMENT,50,90)){
            @Override
            public void paint(Graphics g) {
                Image ima = null;
                try {
                    ima = ImageIO.read(new File("C:\\Users\\luisl\\OneDrive\\Escritorio\\fondo.jpg"));
                } catch (IOException ex) {
                    System.out.println("");
                }
                g.drawImage(ima, 0, 0, getWidth(),getHeight(),this);
                setOpaque(false);      
                super.paint(g);
            }
            
        };
        
        for (int i = 0;i<26;i++){
            pnlCenter.add(buttons.getButtons().get(i));
            buttons.getButtons().get(i).setContentAreaFilled(false);
            buttons.getButtons().get(i).setBorderPainted(false);
        }
        rCenter.add(pnlCenter,BorderLayout.CENTER);
        super.add(rCenter,BorderLayout.CENTER);
        
        //----------------------------------------------------------------------Añadiendo los valores
        values = new Panels();
        
        ImageIcon fondo1=new ImageIcon(getClass().getResource("../Images/real.png"));
        ImageIcon fondo2 = new ImageIcon(fondo1.getImage().getScaledInstance(300, 70, Image.SCALE_DEFAULT));
        for(int i=0;i<13;i++){
            values.toAdd(new JLabel());
            values.getPanels().get(i).setIcon(fondo2);
            values.getPanels().get(i).setFont(new Font("Mesquite Std",0,60));
            values.getPanels().get(i).setForeground(Color.black);
            values.getPanels().get(i).setHorizontalTextPosition((int) CENTER_ALIGNMENT);
            values.getPanels().get(i).setText("$"+String.valueOf(new Values().getValues().get(i)));
            pnlLeft.add(values.getPanels().get(i));
        }
        
        for(int i=13;i<26;i++){
            values.toAdd(new JLabel());
            values.getPanels().get(i).setIcon(fondo2);
            values.getPanels().get(i).setFont(new Font("Mesquite Std",0,60));
            values.getPanels().get(i).setForeground(Color.BLACK);
            values.getPanels().get(i).setHorizontalTextPosition((int) CENTER_ALIGNMENT);
            values.getPanels().get(i).setText("$"+String.valueOf(new Values().getValues().get(i)));
            pnlRight.add(values.getPanels().get(i));
        }
        
        super.add(pnlLeft,BorderLayout.WEST);
        super.add(pnlRight,BorderLayout.EAST);
        
        //----------------------------------------------------------------------Creando los maletines y asignándoles valores
        suitcases = new ArrayList<>();
        rValues = new Values();
        rValues.disorderAll();
        
        for(int i=0;i<26;i++){
            suitcases.add(new Suitcase(rValues.getValues().get(i)));
        }
        //----------------------------------------------------------------------Definiendo las funciones de los botones
        firstOne = true;
        rCenter.add(pnlSouth,BorderLayout.SOUTH);
        images = new Images();
        
        ImageIcon you1 = new ImageIcon(getClass().getResource("../Images/you.png"));
        ImageIcon you2 = new ImageIcon(you1.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT));
        you = new JLabel(you2);
        pnlSouth.add(you);
        
        buttons.getButtons().get(0).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 1
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(0).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(0)));
                    buttons.getButtons().get(0).setVisible(false);
                }
                else if(suitcases.get(0).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(0).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(0).setClosed(false);
                    buttons.getButtons().get(0).setVisible(false);
                    changeColor(suitcases.get(0).getCantity());
                    suitcases.get(0).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                    
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(1).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 2
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(1).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(1)));
                    buttons.getButtons().get(1).setVisible(false);
                }
                else if(suitcases.get(1).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(1).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(1).setClosed(false);
                    buttons.getButtons().get(1).setVisible(false);
                    changeColor(suitcases.get(1).getCantity());
                    suitcases.get(1).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(2).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 3
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(2).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(2)));
                    buttons.getButtons().get(2).setVisible(false);
                }
                else if(suitcases.get(2).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(2).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(2).setClosed(false);
                    buttons.getButtons().get(2).setVisible(false);
                    changeColor(suitcases.get(2).getCantity());
                    suitcases.get(2).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        buttons.getButtons().get(3).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 4
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(3).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(3)));
                    buttons.getButtons().get(3).setVisible(false);
                }
                else if(suitcases.get(3).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(3).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(3).setClosed(false);
                    buttons.getButtons().get(3).setVisible(false);
                    changeColor(suitcases.get(3).getCantity());
                    suitcases.get(3).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(4).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 5
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(4).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(4)));
                    buttons.getButtons().get(4).setVisible(false);
                }
                else if(suitcases.get(4).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(4).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(4).setClosed(false);
                    buttons.getButtons().get(4).setVisible(false);
                    changeColor(suitcases.get(4).getCantity());
                    suitcases.get(4).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(5).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 6
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(5).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(5)));
                    buttons.getButtons().get(5).setVisible(false);
                }
                else if(suitcases.get(5).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(5).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(5).setClosed(false);
                    buttons.getButtons().get(5).setVisible(false);
                    changeColor(suitcases.get(5).getCantity());
                    suitcases.get(5).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(6).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 7
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(6).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(6)));
                    buttons.getButtons().get(6).setVisible(false);
                }
                else if(suitcases.get(6).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(6).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(6).setClosed(false);
                    buttons.getButtons().get(6).setVisible(false);
                    changeColor(suitcases.get(6).getCantity());
                    suitcases.get(6).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(7).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 8
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(7).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(7)));
                    buttons.getButtons().get(7).setVisible(false);
                }
                else if(suitcases.get(7).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(7).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(7).setClosed(false);
                    buttons.getButtons().get(7).setVisible(false);
                    changeColor(suitcases.get(7).getCantity());
                    suitcases.get(7).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(8).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 9
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(8).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(8)));
                    buttons.getButtons().get(8).setVisible(false);
                }
                else if(suitcases.get(8).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(8).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(8).setClosed(false);
                    buttons.getButtons().get(8).setVisible(false);
                    changeColor(suitcases.get(8).getCantity());
                    suitcases.get(8).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(9).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 10
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(9).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(9)));
                    buttons.getButtons().get(9).setVisible(false);
                }
                else if(suitcases.get(9).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(9).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(9).setClosed(false);
                    buttons.getButtons().get(9).setVisible(false);
                    changeColor(suitcases.get(9).getCantity());
                    suitcases.get(9).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(10).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 11
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(10).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(10)));
                    buttons.getButtons().get(10).setVisible(false);
                }
                else if(suitcases.get(10).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(10).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(10).setClosed(false);
                    buttons.getButtons().get(10).setVisible(false);
                    changeColor(suitcases.get(10).getCantity());
                    suitcases.get(10).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(11).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 12
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(11).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(11)));
                    buttons.getButtons().get(11).setVisible(false);
                }
                else if(suitcases.get(11).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(11).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(11).setClosed(false);
                    buttons.getButtons().get(11).setVisible(false);
                    changeColor(suitcases.get(11).getCantity());
                    suitcases.get(11).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(12).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 13
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(12).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(12)));
                    buttons.getButtons().get(12).setVisible(false);
                }
                else if(suitcases.get(12).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(12).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(12).setClosed(false);
                    buttons.getButtons().get(12).setVisible(false);
                    changeColor(suitcases.get(12).getCantity());
                    suitcases.get(12).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(13).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 14
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(13).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(13)));
                    buttons.getButtons().get(13).setVisible(false);
                }
                else if(suitcases.get(13).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(13).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(13).setClosed(false);
                    buttons.getButtons().get(13).setVisible(false);
                    changeColor(suitcases.get(13).getCantity());
                    suitcases.get(13).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(14).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 15
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(14).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(14)));
                    buttons.getButtons().get(14).setVisible(false);
                }
                else if(suitcases.get(14).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(14).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(14).setClosed(false);
                    buttons.getButtons().get(14).setVisible(false);
                    changeColor(suitcases.get(14).getCantity());
                    suitcases.get(14).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(15).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 16
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(15).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(15)));
                    buttons.getButtons().get(15).setVisible(false);
                }
                else if(suitcases.get(15).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(15).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(15).setClosed(false);
                    buttons.getButtons().get(15).setVisible(false);
                    changeColor(suitcases.get(15).getCantity());
                    suitcases.get(15).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(16).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 17
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(16).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(16)));
                    buttons.getButtons().get(16).setVisible(false);
                }
                else if(suitcases.get(16).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(16).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(16).setClosed(false);
                    buttons.getButtons().get(16).setVisible(false);
                    changeColor(suitcases.get(16).getCantity());
                    suitcases.get(16).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(17).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 18
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(17).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(17)));
                    buttons.getButtons().get(17).setVisible(false);
                }
                else if(suitcases.get(17).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(17).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(17).setClosed(false);
                    buttons.getButtons().get(17).setVisible(false);
                    changeColor(suitcases.get(17).getCantity());
                    suitcases.get(17).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(18).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 19
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(18).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(18)));
                    buttons.getButtons().get(18).setVisible(false);
                }
                else if(suitcases.get(18).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(18).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(18).setClosed(false);
                    buttons.getButtons().get(18).setVisible(false);
                    changeColor(suitcases.get(18).getCantity());
                    suitcases.get(18).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(19).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 20
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(19).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(19)));
                    buttons.getButtons().get(19).setVisible(false);
                }
                else if(suitcases.get(19).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(19).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(19).setClosed(false);
                    buttons.getButtons().get(19).setVisible(false);
                    changeColor(suitcases.get(19).getCantity());
                    suitcases.get(19).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(20).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 21
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(20).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(20)));
                    buttons.getButtons().get(20).setVisible(false);
                }
                else if(suitcases.get(20).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(20).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(20).setClosed(false);
                    buttons.getButtons().get(20).setVisible(false);
                    changeColor(suitcases.get(20).getCantity());
                    suitcases.get(20).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(21).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 22
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(21).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(21)));
                    buttons.getButtons().get(21).setVisible(false);
                }
                else if(suitcases.get(21).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(21).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(21).setClosed(false);
                    buttons.getButtons().get(21).setVisible(false);
                    changeColor(suitcases.get(21).getCantity());
                    suitcases.get(21).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(22).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 23
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(22).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(22)));
                    buttons.getButtons().get(22).setVisible(false);
                }
                else if(suitcases.get(22).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(22).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(22).setClosed(false);
                    buttons.getButtons().get(22).setVisible(false);
                    changeColor(suitcases.get(22).getCantity());
                    suitcases.get(22).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(23).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 24
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(23).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(23)));
                    buttons.getButtons().get(23).setVisible(false);
                }
                else if(suitcases.get(23).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(23).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(23).setClosed(false);
                    buttons.getButtons().get(23).setVisible(false);
                    changeColor(suitcases.get(23).getCantity());
                    suitcases.get(23).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(24).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 25
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(24).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(24)));
                    buttons.getButtons().get(24).setVisible(false);
                }
                else if(suitcases.get(24).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(24).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(24).setClosed(false);
                    buttons.getButtons().get(24).setVisible(false);
                    changeColor(suitcases.get(24).getCantity());
                    suitcases.get(24).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23|| count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
        
        buttons.getButtons().get(25).addActionListener(new ActionListener(){//-----------------------------------------------BOTON 26
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstOne){
                    firstOne=false;
                    save=suitcases.get(25).getCantity();
                    pnlSouth.add(new JLabel(images.getImages().get(25)));
                    buttons.getButtons().get(25).setVisible(false);
                }
                else if(suitcases.get(25).getClosed()){
                    JOptionPane.showMessageDialog(null,"$"+suitcases.get(25).getCantity().toString(),"What's inside?",JOptionPane.WARNING_MESSAGE);
                    suitcases.get(25).setClosed(false);
                    buttons.getButtons().get(25).setVisible(false);
                    changeColor(suitcases.get(25).getCantity());
                    suitcases.get(25).setClosed(false);
                    count++;
                }
                if(count == 6 || count == 11 || count == 15 || count == 18 || count == 20 || count == 22 || count == 23 || count == 24){
                    throwDialog();
                }
                if(count == 25){
                    throwWinDialog();
                    System.exit(0);
                }
            } 
        });
    }
    
    private void throwDialog(){
        bd = new BankDialog(this,throwOffer());
    }
    
    private void throwWinDialog(){
        JOptionPane.showMessageDialog(null,"CONGRATULATIONS! \n\nYou've won $"+this.save,"Congratulations!",JOptionPane.WARNING_MESSAGE);
    }
    
    public Integer throwOffer(){
        int a=0,b=0;
        for(int i=0;i<26;i++){
            if(this.suitcases.get(i).getClosed()){
                a+=this.suitcases.get(i).getCantity();
                b++;
            }
        }
        return (int)(a/b*0.7);
    }
    
    public void changeColor(int value){
        switch(value){
            case 1:
                values.getPanels().get(0).setForeground(Color.LIGHT_GRAY);
                break;
            case 3:
                values.getPanels().get(1).setForeground(Color.LIGHT_GRAY);
                break;
            case 5:
                values.getPanels().get(2).setForeground(Color.LIGHT_GRAY);
                break;
            case 10:
                values.getPanels().get(3).setForeground(Color.LIGHT_GRAY);
                break;
            case 25:
                values.getPanels().get(4).setForeground(Color.LIGHT_GRAY);
                break;
            case 50:
                values.getPanels().get(5).setForeground(Color.LIGHT_GRAY);
                break;
            case 75:
                values.getPanels().get(6).setForeground(Color.LIGHT_GRAY);
                break;
            case 100:
                values.getPanels().get(7).setForeground(Color.LIGHT_GRAY);
                break;
            case 200:
                values.getPanels().get(8).setForeground(Color.LIGHT_GRAY);
                break;
            case 300:
                values.getPanels().get(9).setForeground(Color.LIGHT_GRAY);
                break;
            case 400:
                values.getPanels().get(10).setForeground(Color.LIGHT_GRAY);
                break;
            case 500:
                values.getPanels().get(11).setForeground(Color.LIGHT_GRAY);
                break;
            case 750:
                values.getPanels().get(12).setForeground(Color.LIGHT_GRAY);
                break;
            case 1000:
                values.getPanels().get(13).setForeground(Color.LIGHT_GRAY);
                break;
            case 5000:
                values.getPanels().get(14).setForeground(Color.LIGHT_GRAY);
                break;
            case 10000:
                values.getPanels().get(15).setForeground(Color.LIGHT_GRAY);
                break;
            case 25000:
                values.getPanels().get(16).setForeground(Color.LIGHT_GRAY);
                break;
            case 50000:
                values.getPanels().get(17).setForeground(Color.LIGHT_GRAY);
                break;
            case 75000:
                values.getPanels().get(18).setForeground(Color.LIGHT_GRAY);
                break;
            case 100000:
                values.getPanels().get(19).setForeground(Color.LIGHT_GRAY);
                break;
            case 200000:
                values.getPanels().get(20).setForeground(Color.LIGHT_GRAY);
                break;
            case 300000:
                values.getPanels().get(21).setForeground(Color.LIGHT_GRAY);
                break;
            case 400000:
                values.getPanels().get(22).setForeground(Color.LIGHT_GRAY);
                break;
            case 500000:
                values.getPanels().get(23).setForeground(Color.LIGHT_GRAY);
                break;
            case 750000:
                values.getPanels().get(24).setForeground(Color.LIGHT_GRAY);
                break;
            case 1000000:
                values.getPanels().get(25).setForeground(Color.LIGHT_GRAY);
                break;
        }
    }
}