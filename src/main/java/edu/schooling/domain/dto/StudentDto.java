package edu.schooling.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import edu.schooling.domain.Bed;
import edu.schooling.domain.CourseAssignment;
import edu.schooling.domain.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    public StudentDto() {
    }

    public StudentDto(String firstName, String lastName, String gender) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
    }

    public StudentDto(Long id, String firstName, String lastName, String gender) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
    }

    public StudentDto(Student std) {
        this.id = std.getId();
        this.firstName = std.getFirstName();
        this.lastName = std.getLastName();
        this.gender = std.getGender();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
