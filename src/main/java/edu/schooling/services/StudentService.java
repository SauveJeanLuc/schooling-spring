package edu.schooling.services;

import edu.schooling.domain.Student;
import edu.schooling.domain.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public Student save(StudentDto dto) throws Exception;
    public List<Student> getAll() throws Exception;

    List<Student> getByFirstNameAndLastName(String firstName, String lastName) throws Exception;
}
