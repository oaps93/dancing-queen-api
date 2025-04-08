package com.aps.dancingQApp.Util;

import com.aps.dancingQApp.Model.DClass;
import com.aps.dancingQApp.Model.DClassDTO;

import java.util.ArrayList;
import java.util.List;

public class DClassMapper {
    public static DClassDTO toDTO(DClass dClass) {
        if(dClass == null) {
            return null;
        }

        return DClassDTO.builder()
                .id(dClass.getId())
                .level(dClass.getLevel())
                .className(dClass.getClassName())
                .build();
    }

    public static List<DClassDTO> toDTOList(List<DClass> dClassList) {
        if(dClassList.isEmpty()) {
            return new ArrayList<>();
        }

        return dClassList.stream()
                .map(DClassMapper::toDTO)
                .toList();
    }

    public static DClass toEntity(DClassDTO dClassDTO) {
        if(dClassDTO == null) {
            return null;
        }

        return  DClass.builder()
                .id(dClassDTO.getId())
                .level(dClassDTO.getLevel())
                .className(dClassDTO.getClassName())
                .instructors(dClassDTO.getInstructors())
                .build();
    }
}
