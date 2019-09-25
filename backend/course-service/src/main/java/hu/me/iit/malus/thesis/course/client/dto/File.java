package hu.me.iit.malus.thesis.course.client.dto;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class File {

    Long id;
    String name;
    String downloadLink;
    Date uploadDate;
    String uploadedBy;
    Long tagId;
}
