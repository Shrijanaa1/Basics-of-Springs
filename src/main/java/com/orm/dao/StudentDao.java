package com.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import com.orm.entities.Students;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    //save Student
    @Transactional
    public int insert(Students student){
        //insert
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }

    //get the single data(object)
    public Students getStudent(int studentId){
        Students student = this.hibernateTemplate.get(Students.class, studentId);
        return student;
    }

    //get all students(all rows)
    public List<Students> getAllStudents(){
        List<Students> students = this.hibernateTemplate.loadAll(Students.class);
        return students;
    }

    //deleting the data
    @Transactional
    public void deleteStudent(int studentId){
        Students student = this.hibernateTemplate.get(Students.class, studentId);
        this.hibernateTemplate.delete(student);
    }

    //updating data....
    @Transactional
    public void updateStudent(Students student){
        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}


