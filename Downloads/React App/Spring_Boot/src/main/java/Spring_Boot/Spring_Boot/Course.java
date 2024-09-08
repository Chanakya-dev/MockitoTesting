package Spring_Boot.Spring_Boot;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
@Id
private int cid;
private String cname;
private double cfee;
 @ManyToMany(mappedBy = "c")
    private List<Student> students;
public List<Student> getStudents() {
    return students;
}
public void setStudents(List<Student> students) {
    this.students = students;
}
public int getCid() {
    return cid;
}
public void setCid(int cid) {
    this.cid = cid;
}
public String getCname() {
    return cname;
}
public void setCname(String cname) {
    this.cname = cname;
}
public double getCfee() {
    return cfee;
}
public void setCfee(double cfee) {
    this.cfee = cfee;
}
public Course(int cid, String cname, double cfee,List<Student>l) {
    this.cid = cid;
    this.cname = cname;
    this.cfee = cfee;
    this.students=l;
}
public Course(){

}
public String toString(){
    return "Course ID "+cid+"Course Name"+cname+"Course Fee"+cfee;
}
}
