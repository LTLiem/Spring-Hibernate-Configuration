package upskills.autotagging.model;
// Generated Sep 28, 2017 4:22:22 PM by Hibernate Tools 4.3.1



/**
 * TradeId generated by hbm2java
 */
public class TradeId  implements java.io.Serializable {


     private String field;
     private int nb;

    public TradeId() {
    }

    public TradeId(String field, int nb) {
       this.field = field;
       this.nb = nb;
    }
   
    public String getField() {
        return this.field;
    }
    
    public void setField(String field) {
        this.field = field;
    }
    public int getNb() {
        return this.nb;
    }
    
    public void setNb(int nb) {
        this.nb = nb;
    }

}


