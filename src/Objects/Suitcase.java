/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author luisl
 */
public class Suitcase {
    private Integer cantity;
    private Boolean closed;
    
    public Suitcase(int cantity){
        this.cantity=cantity;
        closed = true;
    }

    public Integer getCantity() {
        return cantity;
    }

    public void setCantity(Integer cantity) {
        this.cantity = cantity;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }    
}
