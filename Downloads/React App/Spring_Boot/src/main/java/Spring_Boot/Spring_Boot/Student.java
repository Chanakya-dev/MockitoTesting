package Spring_Boot.Spring_Boot;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TDS")
public class Student {
    @Id
    private int eid;
    private String ename;
    private double esal;
    private String edesg;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fkaid")
    private Aadhar a;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fkmid")
    private List<Mobiles>mob;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "StdCourse",joinColumns
    =@JoinColumn(name="fksid"),inverseJoinColumns = @JoinColumn(name="fkcid"))
    private List<Course>c;
   
    public Aadhar getA() {
   
        return a;
    }
    public void setA(Aadhar a) {
        this.a = a;
    }
    
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public double getEsal() {
        return esal;
    }
    public void setEsal(double esal) {
        this.esal = esal;
    }
    public String getEdesg() {
        return edesg;
    }
    public void setEdesg(String edesg) {
        this.edesg = edesg;
    }
    public List<Mobiles> getMob() {
        return mob;
    }
    public void setMob(List<Mobiles> mob) {
        this.mob = mob;
    }
  
    public Student() {
    }
    public Student(int eid, String ename, double esal, String edesg, Aadhar a, List<Mobiles> mob) {
        this.eid = eid;
        this.ename = ename;
        this.esal = esal;
        this.edesg = edesg;
        this.a = a;
        this.mob = mob;
    }
    @Override
    public String toString() {
        return "Student [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", edesg=" + edesg + ", a=" + a
                + ", mob=" + mob + "]";
    }
    public List<Course> getC() {
        return c;
    }
    public void setC(List<Course> c) {
        this.c = c;
    }
  
     
}
