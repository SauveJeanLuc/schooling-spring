package edu.schooling.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import edu.schooling.domain.Bed;
import edu.schooling.domain.CourseAssignment;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Set<Bed> beds = new HashSet<Bed>();
    private Set<CourseAssignment> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<Bed> beds) {
        this.beds = beds;
    }

    public Set<CourseAssignment> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseAssignment> courses) {
        this.courses = courses;
    }
}
