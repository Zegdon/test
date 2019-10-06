package hu.me.iit.malus.thesis.course.client.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@ToString @EqualsAndHashCode
/**
 * Aggregator class for Student and Teacher objects.
 * It is not a real DTO, so it should not be used in inter-service communication,
 * use one of its child class instead.
 *
 * @author Javorek Dénes
 */
public class User
{
    private final String email;
    private String password;
    private String firstName, lastName;

    private UserRole role;
    private boolean enabled;

    public User() {
        super();
        this.email = null;
        this.enabled = false;
    }

    public User withEmail(String email) {
        return new User(email, this.password, this.firstName, this.lastName, this.role, false);
    }
}
