/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author luisl
 */
public class Images {
    private ArrayList<ImageIcon> images;
    
    public Images(){
        images = new ArrayList();
        this.addAll();
    }
    
    public ArrayList<ImageIcon> getImages(){
        return images;
    }
    
    public void setImages(ArrayList<ImageIcon> images){
        this.images=images;
    }
    
    public void addAll(){
        ImageIcon m1 = new ImageIcon((getClass().getResource("../Images/1.png")));
        ImageIcon mm1 = new ImageIcon(m1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m2 = new ImageIcon((getClass().getResource("../Images/2.png")));
        ImageIcon mm2 = new ImageIcon(m2.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m3 = new ImageIcon((getClass().getResource("../Images/3.png")));
        ImageIcon mm3 = new ImageIcon(m3.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m4 = new ImageIcon((getClass().getResource("../Images/4.png")));
        ImageIcon mm4 = new ImageIcon(m4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m5 = new ImageIcon((getClass().getResource("../Images/5.png")));
        ImageIcon mm5 = new ImageIcon(m5.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m6 = new ImageIcon((getClass().getResource("../Images/6.png")));
        ImageIcon mm6 = new ImageIcon(m6.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m7 = new ImageIcon((getClass().getResource("../Images/7.png")));
        ImageIcon mm7 = new ImageIcon(m7.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m8 = new ImageIcon((getClass().getResource("../Images/8.png")));
        ImageIcon mm8 = new ImageIcon(m8.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m9 = new ImageIcon((getClass().getResource("../Images/9.png")));
        ImageIcon mm9 = new ImageIcon(m9.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m10 = new ImageIcon((getClass().getResource("../Images/10.png")));
        ImageIcon mm10 = new ImageIcon(m10.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m11 = new ImageIcon((getClass().getResource("../Images/11.png")));
        ImageIcon mm11 = new ImageIcon(m11.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m12 = new ImageIcon((getClass().getResource("../Images/12.png")));
        ImageIcon mm12 = new ImageIcon(m12.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m13 = new ImageIcon((getClass().getResource("../Images/13.png")));
        ImageIcon mm13 = new ImageIcon(m13.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m14 = new ImageIcon((getClass().getResource("../Images/14.png")));
        ImageIcon mm14 = new ImageIcon(m14.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m15 = new ImageIcon((getClass().getResource("../Images/15.png")));
        ImageIcon mm15 = new ImageIcon(m15.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m16 = new ImageIcon((getClass().getResource("../Images/16.png")));
        ImageIcon mm16 = new ImageIcon(m16.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m17 = new ImageIcon((getClass().getResource("../Images/17.png")));
        ImageIcon mm17 = new ImageIcon(m17.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m18 = new ImageIcon((getClass().getResource("../Images/18.png")));
        ImageIcon mm18 = new ImageIcon(m18.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m19 = new ImageIcon((getClass().getResource("../Images/19.png")));
        ImageIcon mm19 = new ImageIcon(m19.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m20 = new ImageIcon((getClass().getResource("../Images/20.png")));
        ImageIcon mm20 = new ImageIcon(m20.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m21 = new ImageIcon((getClass().getResource("../Images/21.png")));
        ImageIcon mm21 = new ImageIcon(m21.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m22 = new ImageIcon((getClass().getResource("../Images/22.png")));
        ImageIcon mm22 = new ImageIcon(m22.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m23 = new ImageIcon((getClass().getResource("../Images/23.png")));
        ImageIcon mm23 = new ImageIcon(m23.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m24 = new ImageIcon((getClass().getResource("../Images/24.png")));
        ImageIcon mm24 = new ImageIcon(m24.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m25 = new ImageIcon((getClass().getResource("../Images/25.png")));
        ImageIcon mm25 = new ImageIcon(m25.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        ImageIcon m26 = new ImageIcon((getClass().getResource("../Images/26.png")));
        ImageIcon mm26 = new ImageIcon(m26.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        
        this.images.add(0,mm1);
        this.images.add(1,mm2);
        this.images.add(2,mm3);
        this.images.add(3,mm4);
        this.images.add(4,mm5);
        this.images.add(5,mm6);
        this.images.add(6,mm7);
        this.images.add(7,mm8);
        this.images.add(8,mm9);
        this.images.add(9,mm10);
        this.images.add(10,mm11);
        this.images.add(11,mm12);
        this.images.add(12,mm13);
        this.images.add(13,mm14);
        this.images.add(14,mm15);
        this.images.add(15,mm16);
        this.images.add(16,mm17);
        this.images.add(17,mm18);
        this.images.add(18,mm19);
        this.images.add(19,mm20);
        this.images.add(20,mm21);
        this.images.add(21,mm22);
        this.images.add(22,mm23);
        this.images.add(23,mm24);
        this.images.add(24,mm25);
        this.images.add(25,mm26);
    }
}
