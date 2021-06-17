package edu.schooling.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  Long numHours;

    @OneToMany(mappedBy = "course")
    private Set<CourseAssignment> courseAssignments = new HashSet<>();

    public Course() {
    }

    public Course(String title, Long numHours) {
        this.title = title;
        this.numHours = numHours;
    }

    public Course(Long id, String title, Long numHours) {
        this.id = id;
        this.title = title;
        this.numHours = numHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNumHours() {
        return numHours;
    }

    public void setNumHours(Long numHours) {
        this.numHours = numHours;
    }
}
