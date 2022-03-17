package pl.sages.javadevpro.projecttwo.controller.dto;

import org.mapstruct.Mapper;
import pl.sages.javadevpro.projecttwo.domain.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toDomain(TaskDto dto);

}
