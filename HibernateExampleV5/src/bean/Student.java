package bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;


@Entity
@Table(name="H_PERSON")
@DiscriminatorValue("Student")
public class Student extends Person{
    
    @Column(name="MARK")
    private int mark;

    public Student(){}

    public Student(int mark, String first_name, String last_name) {
        super(first_name, last_name);
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    
    
}
