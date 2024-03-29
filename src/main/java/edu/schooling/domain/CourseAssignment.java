package edu.schooling.domain;

import edu.schooling.enums.AssignmentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class CourseAssignment {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private String assignedOn;

    private String lastUpdatedBy;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    private String statusModifiedOn;

    public CourseAssignment() {}

    public CourseAssignment(String lastUpdatedBy, AssignmentStatus status) {
        this.lastUpdatedBy = lastUpdatedBy;
        this.status = status;
        this.assignedOn = LocalDateTime.now().toString();
        this.statusModifiedOn = LocalDateTime.now().toString();
    }

    public CourseAssignment(Long id, String lastUpdatedBy, AssignmentStatus status) {
        this.id=id;
        this.lastUpdatedBy = lastUpdatedBy;
        this.status = status;
        this.assignedOn = LocalDateTime.now().toString();
        this.statusModifiedOn = LocalDateTime.now().toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAssignedOn(String assignedOn) {
        this.assignedOn = assignedOn;
    }

    public String getAssignedOn() {
        return assignedOn;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatusModifiedOn(String statusModifiedOn) {
        this.statusModifiedOn = statusModifiedOn;
    }

    public String getStatusModifiedOn() {
        return statusModifiedOn;
    }

    public static long getSerialversionuid() {
        return SerialVersionUID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
