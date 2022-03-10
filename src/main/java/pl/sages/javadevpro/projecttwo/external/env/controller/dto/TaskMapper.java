package pl.sages.javadevpro.projecttwo.external.env.controller.dto;

import org.mapstruct.Mapper;
import pl.sages.javadevpro.projecttwo.external.env.domain.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toDomain(TaskDto dto);

}
