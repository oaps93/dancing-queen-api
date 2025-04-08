package com.aps.dancingQApp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String age;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "instructor_dclass",
            joinColumns = {@JoinColumn(name = "instructor_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "dclass_id", referencedColumnName = "id")})
    @EqualsAndHashCode.Exclude
    private Set<DClass> classes;

    public void addClass(DClass dClass) {
        this.classes.add(dClass);
        dClass.getInstructors().add(this); // Bidirectional relationship
    }
}
