package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.StudentDAO;
import model.Student;


@Service
public class StudentServiceImpl implements StudentService {
    
    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    
    @Override
    @Transactional
    public void addStudent(Student s) {
        studentDAO.insert(s);
    }

    @Override
    @Transactional
    public void updateStudent(Student s) {
        studentDAO.update(s);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        studentDAO.delete(id);
    }
}
