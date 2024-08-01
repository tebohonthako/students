package DAO;


import jakarta.persistence.Query;
import jakarta.websocket.Session;
import model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Student_DAO_Imp implements Student_DAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveStudent(Student student) {
       boolean status=false;
       try {
           sessionFactory.getCurrentSession().save(student);
           status = true;
       } catch (Exception e){
           e.printStackTrace();
       }
       return status;
    }

    @Override
    public List<Student> getStudents() {
        Session currentSession = (Session) sessionFactory.getCurrentSession();
        Query<Student> query=currentSession.createQuery("from Student", Student.class);
        List<Student> list=query.getResultList();
        return List.of();
    }

    @Override
    public boolean deleteStudent(Student student) {
        boolean status=false;
        try {
            sessionFactory.getCurrentSession().delete(student);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Student> getStudentsByID(Student student) {
        return List.of();
    }

    @Override
    public List<Student> getStudentByID(Student student) {
        Session currentSession = (Session) sessionFactory.getCurrentSession();
        Query<Student> query=currentSession.createQuery("from Student where student_id=:student_id", Student.class);
        query.setParameter("student_id", student.getStudent_id());
        List<Student> list=query.getResultList();
        return list;
    }


    @Override
    public boolean updateStudent(Student student) {
        boolean status=false;
        try {
            sessionFactory.getCurrentSession().update(student);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}