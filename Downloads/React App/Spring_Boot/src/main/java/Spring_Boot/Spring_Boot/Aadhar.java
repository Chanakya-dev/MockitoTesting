package Spring_Boot.Spring_Boot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aadhar")
public class Aadhar {
    @Id
    private int aid;
    private String anum;
    private String aloc;
    public Aadhar() {
    }

    public Aadhar(int aid, String anum, String aloc) {
        this.aid = aid;
        this.anum = anum;
        this.aloc = aloc;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAnum() {
        return anum;
    }

    public void setAnum(String anum) {
        this.anum = anum;
    }

    public String getAloc() {
        return aloc;
    }

    public void setAloc(String aloc) {
        this.aloc = aloc;
    }

    @Override
    public String toString() {
        return "Aadhar [aid=" + aid + ", anum=" + anum + ", aloc=" + aloc + "]";
    }

    

}
