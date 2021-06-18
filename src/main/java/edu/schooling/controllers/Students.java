package edu.schooling.controllers;

import java.net.URISyntaxException;
import javax.validation.Valid;

import edu.schooling.domain.Student;
import edu.schooling.domain.dto.SchoolManResponseDto;
import edu.schooling.domain.dto.StudentDto;
import edu.schooling.services.StudentService;
import edu.schooling.services.impl.StudentServiceImplCopy;
import edu.schooling.services.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            std = ((StudentServiceImplCopy) studentService).save(studentDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new SchoolManResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), new StudentDto(std)));
        }
        return ResponseEntity.ok()
                .body(new SchoolManResponseDto(HttpStatus.OK, "SUCCESSFULLY RECORDED", new StudentDto(std)));
    }
}