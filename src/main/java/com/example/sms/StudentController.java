package com.example.sms;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController //Telling the java application --> this class will contain API endpoints
public class StudentController {


    //Database
    HashMap<Integer,Student> studentDb = new HashMap<>();


    //Add a Student
    @PostMapping("/add_student")
    public String addStudent(@RequestBody() Student student){

        //Add it to our db

        int key = student.id;

        //Add it to the studentDb
        studentDb.put(key,student);

        return "Student added successfully";

    }

    //Get a Student by id
    @GetMapping("get_student_by_id")
    public Student getStudentById(@RequestParam("id")Integer id){

        return studentDb.get(id);
    }

    @GetMapping("/get_by_path/{id}")
    public Student getByPath(@PathVariable("id")Integer id){

        Student student = studentDb.get(id);
        return student;
    }

    //Get a student by Name
    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name")String searchName)
    {
        //Iterate over the hashMap
        for(Student s:studentDb.values()){

            if(s.name.equals(searchName)){
                return s;
            }
        }

        //it means the student is not found
        return null;
    }




    //Update a Student
    @PutMapping("/update_student")
    public Student updateStudent(@RequestBody()Student student){

        //Get the key
        int key = student.id;

        studentDb.put(key,student);

        return student;
    }


    //Delete a student
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id")Integer id){

        studentDb.remove(id);

        return "The student has been successfully removed ";
    }

}
