package bean;

public class Employee{

    private int id;
    private String firstName;
    private Address address;
    private double salary;
    
    public Employee() {}

    public Employee(String firstName, Address address, double salary) {
        this.firstName = firstName;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString(){
        return "Employee={" + this.getId() + " , " + this.getFirstName() + " , " + this.getSalary() + "}";
    }
}
