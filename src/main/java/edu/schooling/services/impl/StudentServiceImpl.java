package edu.schooling.services.impl;

import edu.schooling.domain.Student;
import edu.schooling.domain.dto.StudentDto;
import edu.schooling.repositories.StudentRepository;
import edu.schooling.services.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //@Autowired
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Transactional
    @Override
    public Student save(StudentDto dto) throws Exception {
        return studentRepository.save(new Student(dto));
    }

    @Override
    public List<Student> getAll() throws Exception  {
        return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<Student> getByFirstNameAndLastName(String firstName, String lastName) throws Exception {
        if (firstName == null || lastName==null)
            throw new InvalidAttributesException("First Name and last Name should not be empty!");
        return studentRepository.findByFirstNameAndLastNameHql(firstName, lastName);
    }
}







