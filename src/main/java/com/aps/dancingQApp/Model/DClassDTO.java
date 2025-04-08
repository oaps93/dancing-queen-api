package com.aps.dancingQApp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DClassDTO {

    private Long id;
    private String className;
    private String level;
    private Set<Instructor> instructors;
}
