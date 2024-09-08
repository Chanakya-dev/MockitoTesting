package Spring_Boot.Spring_Boot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SMobile")
public class Mobiles {
@Id
    private int mid;
    private String mnum;
    private String msim;
    
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getMnum() {
        return mnum;
    }
    public void setMnum(String mnum) {
        this.mnum = mnum;
    }
    public String getMsim() {
        return msim;
    }
    public void setMsim(String msim) {
        this.msim = msim;
    }
    public Mobiles(int mid, String mnum, String msim) {
        this.mid = mid;
        this.mnum = mnum;
        this.msim = msim;
    }
    public Mobiles() {
    }
    @Override
    public String toString() {
        return "Mobiles [mid=" + mid + ", mnum=" + mnum + ", msim=" + msim + "]";
    }
    

}
