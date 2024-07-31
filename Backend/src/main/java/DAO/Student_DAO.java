package DAO;

import model.Student;

import java.util.List;

public interface Student_DAO {
    public boolean saveStudent(Student student);
    public List<Student> getStudents();
    public boolean deleteStudent(Student student);
    public List<Student> getStudentsByID(Student student);
    public boolean updateStudent(Student student);
}
