package bean;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name="H_PERSON")
@DiscriminatorValue("Employee")
public class Employee extends Person{
    
    @Column(name="JOINING_DATE")
    private Date joining_date;
    
    @Column(name="DEPARTMENT_DATE")
    private String department_name;

    public Employee() {}

    public Employee(Date joining_date, String department_name, String first_name, String last_name) {
        super(first_name, last_name);
        this.joining_date = joining_date;
        this.department_name = department_name;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    
    
    
}
