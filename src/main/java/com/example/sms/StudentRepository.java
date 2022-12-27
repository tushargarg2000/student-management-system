package com.example.sms;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository //To tell java ki this is the Reposi
public class StudentRepository {



    HashMap<Integer,Student> studentDb = new HashMap<>();



    String addStudentToDb(Student student){

        int key = student.id;
        //Add it to the studentDb
        studentDb.put(key,student);

        return "Successfully added";

    }


    Student getStudentFromDb(int id){

        if(studentDb.containsKey(id)){
            return studentDb.get(id);
        }else
            return null;
    }


    Student getStudentByNameFromDb(String searchName){


        for(Student s:studentDb.values()){

            if(s.name.equals(searchName)){
                return s;
            }
        }

        return null;
    }

    Student updateStudentInDb(Student student){

        int key = student.id;

        studentDb.put(key,student);

        return student;
    }

}
