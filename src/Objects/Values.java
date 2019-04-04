/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author luisl
 */
public class Values {
    private ArrayList<Integer> values;
    
    public Values(){
        values = new ArrayList<>();
        this.addAll();
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }
    
    public void disorderAll(){
        Collections.shuffle(this.values);
    }
    
    private void addAll(){
        values.add(0,1);
        values.add(1,3);
        values.add(2,5);
        values.add(3,10);
        values.add(4,25);
        values.add(5,50);
        values.add(6,75);
        values.add(7,100);
        values.add(8,200);
        values.add(9,300);
        values.add(10,400);
        values.add(11,500);
        values.add(12,750);
        values.add(13,1000);
        values.add(14,5000);
        values.add(15,10000);
        values.add(16,25000);
        values.add(17,50000);
        values.add(18,75000);
        values.add(19,100000);
        values.add(20,200000);
        values.add(21,300000);
        values.add(22,400000);
        values.add(23,500000);
        values.add(24,750000);
        values.add(25,1000000);
    }
}
