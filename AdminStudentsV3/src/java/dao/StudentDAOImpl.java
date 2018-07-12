package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import model.Student;


@Repository
public class StudentDAOImpl implements StudentDAO {
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Override
    public void insert(Student s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
    }

    @Override
    public void update(Student s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentsList = session.createQuery("from Student").list();
        return studentsList;
    }

    @Override
    public Student findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
        Student s = (Student) session.load(Student.class, new Integer(id));
        return s;
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student s = (Student) session.load(Student.class, new Integer(id));
        if(null != s){
            session.delete(s);
        }
    }
}
