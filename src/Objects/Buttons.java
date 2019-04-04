/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author luisl
 */
public class Buttons {
    private ArrayList<JButton> buttons;
    private Images images;
    
    public Buttons(){
        buttons = new ArrayList<>();
        this.addAll();
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<JButton> buttons) {
        this.buttons = buttons;
    }
    
    public void addAll(){
        images = new Images();
        for(int i=0;i<26;i++){
            buttons.add(new JButton(images.getImages().get(i)));
        }
    }

}
    

