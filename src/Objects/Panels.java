/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author luisl
 */
public class Panels {
    private ArrayList<JLabel> panels;
    
    public Panels(){
        this.panels = new ArrayList();
    }

    public ArrayList<JLabel> getPanels() {
        return panels;
    }

    public void setPanels(ArrayList<JLabel> panels) {
        this.panels = panels;
    }
    
    public void toAdd(JLabel panel){
        this.panels.add(panel);
    }
}
