package edu.schooling.models;

import com.example.JspStudentCrud.enums.AssignmentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_assigment")
public class CourseAssignment  implements Serializable {

    private static final long serialVersionUID = 14578578345L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private LocalDateTime whenAssigned;

    private String assignedBy;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;
    private String lastStatusChangedOn;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public CourseAssignment() {
    }

    public CourseAssignment(LocalDateTime whenAssigned, String assignedBy, AssignmentStatus status, String lastStatusChangedOn) {
        this.whenAssigned = whenAssigned;
        this.assignedBy = assignedBy;
        this.status = status;
        this.lastStatusChangedOn = lastStatusChangedOn;
    }

    public CourseAssignment(Long id, LocalDateTime whenAssigned, String assignedBy, AssignmentStatus status, String lastStatusChangedOn) {
        this.id = id;
        this.whenAssigned = whenAssigned;
        this.assignedBy = assignedBy;
        this.status = status;
        this.lastStatusChangedOn = lastStatusChangedOn;
    }
}