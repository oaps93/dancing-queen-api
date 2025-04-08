package com.aps.dancingQApp.Util;

import com.aps.dancingQApp.Model.Instructor;
import com.aps.dancingQApp.Model.InstructorDTO;

import java.util.ArrayList;
import java.util.List;

public class InstructorMapper {
    public static InstructorDTO toDTO(Instructor instructor) {
        if(instructor == null) {
            return null;
        }

        return InstructorDTO.builder()
                .id(instructor.getId())
                .age(instructor.getAge())
                .name(instructor.getName())
                .build();
    }

    public static List<InstructorDTO> toDTOList(List<Instructor> instructorList) {
        if(instructorList.isEmpty()) {
            return new ArrayList<>();
        }

        return instructorList.stream()
                .map(InstructorMapper::toDTO)
                .toList();
    }

    public static Instructor toEntity(InstructorDTO instructorDTO) {
        if(instructorDTO == null) {
            return null;
        }

        return Instructor.builder()
                .id(instructorDTO.getId())
                .age(instructorDTO.getAge())
                .name(instructorDTO.getName())
                .classes(instructorDTO.getClasses())
                .build();
    }
}
