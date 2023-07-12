package com.orm;

import com.orm.dao.StudentDao;
import com.orm.entities.Students;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Apps {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Students student = new Students(123, "Shrijana", "Gurjudhara");
//        int r = studentDao.insert(student);
//        System.out.println("Done" + r);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        while (flag){
            System.out.println("PRESS 1 to add new student");
            System.out.println("PRESS 2 to display all students");
            System.out.println("PRESS 3 to get detail of single student");
            System.out.println("PRESS 4 to delete students");
            System.out.println("PRESS 5 to update student");
            System.out.println("PRESS 6 to exit");

            try {
                int input = Integer.parseInt(br.readLine());
                switch(input){
                    case 1:
                        //add a new student

                        //taking inputs form users
                        System.out.println("Enter id:");
                        int uId = Integer.parseInt(br.readLine());

                        System.out.println("Enter username:");
                        String uName = br.readLine();

                        System.out.println("Enter user city:");
                        String uCity = br.readLine();

                        //creating student objects and setting values
                        Students s = new Students();
                        s.setStudentId(uId);
                        s.setStudentName(uName);
                        s.setStudentCity(uCity);

                        //saving student object to database by calling insert of studentDao
                        int r = studentDao.insert(s);
                        System.out.println(r + "student added");
                        System.out.println("*************");

                        break;

                    case 2:
                        //display all students
                        System.out.println("*************");
                        List<Students> allStudents = studentDao.getAllStudents();
                        for (Students st: allStudents){
                            System.out.println("Id: "+ st.getStudentId());
                            System.out.println("Name: "+ st.getStudentName());
                            System.out.println("City: "+ st.getStudentCity());
                            System.out.println("___________________");
                        }
                        System.out.println("*************");
                        break;

                    case 3:
                        //get single student
                        System.out.println("Enter id:");
                        int uerId = Integer.parseInt(br.readLine());
                        Students student = studentDao.getStudent(uerId);
                        System.out.println("Id: "+ student.getStudentId());
                        System.out.println("Name: "+ student.getStudentName());
                        System.out.println("City: "+ student.getStudentCity());
                        break;

                    case 4:
                        //delete student
                        System.out.println("Enter id:");
                        int id = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(id);
                        System.out.println("Student deleted.....");

                        break;

                    case 5:
                        //update the student

                        break;

                    case 6:
                        //add a new student
                        flag = false;
                        break;
                }

            }catch (Exception e){
                System.out.println("Invalid Input try with another one");
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Thank you for using the application! See you again");

    }
}
