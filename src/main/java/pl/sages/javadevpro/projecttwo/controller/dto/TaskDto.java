package pl.sages.javadevpro.projecttwo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    String id;
    String name;
    String description;
    String workspaceUrl;
    String status;

}
