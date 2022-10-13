package com.be.grooming_mood.diary.presentation.dto;

import com.be.grooming_mood.diary.application.command.DiaryCreateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DiaryDtoMapper {
    DiaryDtoMapper INSTANCE = Mappers.getMapper(DiaryDtoMapper.class);

    DiaryCreateCommand toCreateCommand(DiaryCreateDto dto);

}
