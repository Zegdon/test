package hu.me.iit.malus.thesis.user.model;


import lombok.*;

import java.util.List;

/**
 * Data Transfer Object for Student entity
 *
 * @author Javorek Dénes
 */
@Getter @Setter @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Student extends User {

    private List<Long> assignedCourseIds;

    public Student(String id, String password, String firstName, String lastName, List<Long> assignedCourseIds) {
        super(id, password, firstName, lastName);
        this.assignedCourseIds = assignedCourseIds;
    }
}
