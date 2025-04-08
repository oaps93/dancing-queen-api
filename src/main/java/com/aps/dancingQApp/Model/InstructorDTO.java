package com.aps.dancingQApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    private Long id;
    private String name;
    private String age;
    private Set<DClass> classes;
}
