package edu.schooling.repositories;

import edu.schooling.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Query by Dynamic finders
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    //Querry by Sql
    @Query(value = "select * from Student stb where stb.firstName=:firstName or stb.lastName=:lastName")
    List<Student> findByFirstNameAndLastNameHql(@Param("firstName") String firstName,@Param("lastName") String lastName);
    @Query(value = "select * from student_tbl stb where stb.first_name=:firstName and stb.last_name=:lastName",nativeQuery = true)
    List<Student> findByFirstNameOrLastNameHql(@Param("firstName") String firstName,@Param("lastName") String lastName);
}
