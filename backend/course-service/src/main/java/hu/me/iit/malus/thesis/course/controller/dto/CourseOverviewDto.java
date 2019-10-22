package hu.me.iit.malus.thesis.course.controller.dto;

import hu.me.iit.malus.thesis.course.client.dto.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Course DTO object, that is used when only the most important information
 * is needed about the courses
 * @author Javorek Dénes
 */
@NoArgsConstructor
@Getter @Setter
@ToString
public class CourseOverviewDto {
    private Long id;
    private String name;
    private String description;
    private Date creationDate;
    private Teacher creator;
}
