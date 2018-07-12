package dao;

import model.Student;
import java.util.List;

public interface StudentDAO {
    Student findById(int id);
    void delete (int id);
    void update (Student student);
    void insert (Student student);
    List <Student> findAll();
}
