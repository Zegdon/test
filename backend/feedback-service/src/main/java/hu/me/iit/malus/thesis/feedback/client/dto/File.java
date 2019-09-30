package hu.me.iit.malus.thesis.feedback.client.dto;

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
