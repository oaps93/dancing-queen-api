package com.aps.dancingQApp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DanceClass {
    private String className;
    private String level;
    private List<Instructor> instructors;
}
