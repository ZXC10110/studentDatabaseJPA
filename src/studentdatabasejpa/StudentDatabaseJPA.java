/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author kanya
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //insert
        Student stud01 = new Student(1234, "Harry", 3.48);
        Student stud02 = new Student(5678, "Hermione", 3.59);
        StudentTable.insertStudent(stud01);
        StudentTable.insertStudent(stud02);
        
        //delete & update
        /*
        Student std;
        std = StudentTable.findStudentById(1234);
        if (std != null){
           std.setName("Harry");
           StudentTable.removeStudent(std);
           StudentTable.updateStudent(std);
        }
        */
        
        //find & show data
        List<Student> studList = StudentTable.findAllStudent();
        printAllStudent(studList);
    }
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa() + " ");
       }
    }
    
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
