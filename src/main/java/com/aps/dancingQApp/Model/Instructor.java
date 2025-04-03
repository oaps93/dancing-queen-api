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
public class Instructor {
    private String name;
    private String age;
    private List<DanceClass> danceClassList;
}
