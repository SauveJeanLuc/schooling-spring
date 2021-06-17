package edu.schooling.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.schooling.domain.Student;
import edu.schooling.domain.dto.SchoolManResponseDto;
import edu.schooling.domain.dto.StudentDto;
import edu.schooling.services.StudentService;

@RestController
@RequestMapping("/schl_man/v1/students")
public class Students {
    private final Logger log = LoggerFactory.getLogger(Students.class);
    private final StudentService studentService;
    public Students(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<SchoolManResponseDto> createStudent(@Valid @RequestBody StudentDto studentDto) throws URISyntaxException {
        log.info("REST request to save studentDto : {}", studentDto);
        Student std = null;
        try {

            std = studentService.save(studentDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new SchoolManResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null));
        }
        return ResponseEntity.ok()
                .body(new SchoolManResponseDto(HttpStatus.OK, "SUCCESSFULLY RECORDED", new StudentDto(std)));
    }

    @GetMapping("/getStudents")
    public ResponseEntity<SchoolManResponseDto> getStudents() throws URISyntaxException {
        log.info("REST request to get all students : {}");
        List<Student> std = null;
        try {

            std = studentService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new SchoolManResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null));
        }

        List<StudentDto> students  = new ArrayList<>();

        for(Student student : std){
            students.add(new StudentDto(student));
        }

        return ResponseEntity.ok()
                .body(new SchoolManResponseDto(HttpStatus.OK, "SUCCESSIFULLY Retrieved", students ));
    }
}