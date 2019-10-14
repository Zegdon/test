package hu.me.iit.malus.thesis.task.client.dto;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TaskComment {

    private Long id;
    private String authorId;
    private String text;
    private Date createDate;
    private Long taskId;
    private Set<File> files;
}
