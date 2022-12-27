package com.example.sms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController //Telling the java application --> this class will contain API endpoints
public class StudentController {


    @Autowired //Automatically takes care of the StudentService Object Creation
    StudentService studentService; //Object has been created --> so that it can call the functions

    //Database


    //Add a Student
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody() Student student){

        //Calling the
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }



    //Get a Student by id
    @GetMapping("get_student_by_id")
    public ResponseEntity<Student> getStudentById(@RequestParam("id")Integer id){


        //Call the Service Layer
        Student resultStudent = studentService.getStudentById(id);

        if(resultStudent==null){
            return new ResponseEntity<>(resultStudent,HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<>(resultStudent,HttpStatus.OK);
    }

    @GetMapping("/get_by_path/{id}")
    public ResponseEntity<Student> getByPath(@PathVariable("id")Integer id){

        //Calling the Service Layer

        //We are retutilizing these functions ---> of the service and repository layer
        Student resultStudent = studentService.getStudentById(id);

        if(resultStudent==null){
            return new ResponseEntity<>(resultStudent,HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<>(resultStudent,HttpStatus.OK);


    }

    //Get a student by Name
    @GetMapping("/get_student_by_name")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name")String searchName)
    {
        //Iterate over the hashMap

        //it means the student is not found

        Student resultantStudent = studentService.getStudentByName(searchName);

        return new ResponseEntity<>(resultantStudent,HttpStatus.NOT_FOUND);
    }




    //Update a Student
    @PutMapping("/update_student")
    public ResponseEntity<Student> updateStudent(@RequestBody()Student student){

        //Get the key
        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.ACCEPTED);
    }


    //Delete a student ----> H.W
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id")Integer id){

        studentDb.remove(id);

        return new ResponseEntity<>("The student has been deleted", HttpStatus.OK);
    }

}
