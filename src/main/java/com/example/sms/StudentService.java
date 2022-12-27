package com.example.sms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //This is a way of telling java ---> this is the service layer
public class StudentService {


    //Option 1 is to create an object myself
    // Dont need to do it because of Autowire
    // StudentRepository obj = new StudentRepository();


    @Autowired //Its used to connect the different classes via object
    StudentRepository studentRepository; //Assume object is already created


    String addStudent(Student student){

        //This is the service layer
        String result = studentRepository.addStudentToDb(student);

        return result;
    }

    Student getStudentById(Integer id){

        //Calling the repo Layer
        Student student = studentRepository.getStudentFromDb(id);

        return student;
    }


    Student getStudentByName(String name){

        Student s = studentRepository.getStudentByNameFromDb(name);

        return s;
    }

    Student updateStudent(Student student){

        return studentRepository.updateStudentInDb(student);
    }

}
