package edu.schooling.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String firstName;
        private String lastName;
        private String gender;

        @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinTable(
                name = "students_beds_tbl",
                joinColumns = {@JoinColumn(name = "student_id")},
                inverseJoinColumns = {@JoinColumn(name = "bed_id")}
        )
        private Set<com.example.JspStudentCrud.models.Bed> beds = new HashSet<com.example.JspStudentCrud.models.Bed>();

        @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
        private Set<com.example.JspStudentCrud.models.CourseAssignment> courses = new HashSet<>();

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

    public Set<com.example.JspStudentCrud.models.Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<com.example.JspStudentCrud.models.Bed> beds) {
        this.beds = beds;
    }

    public Student() {}

        public Student(String firstName, String lastName , String gender) {
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }
        public Student(Long id){
            this.id = id;
        }
        public Student(Long id, String firstName, String lastName , String gender) {
            this.id = id;
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }

}
