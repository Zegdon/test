package hu.me.iit.malus.thesis.user.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter @Setter @AllArgsConstructor
@ToString @EqualsAndHashCode
/**
 * Aggregator class for all possible User objects.
 * It is not a real DTO, so it should not be used in inter-service communication,
 * use one of its child class instead.
 *
 * @author Javorek Dénes
 */
public class User
{
    @Id
    private final String email;
    private final String password;
    private final String firstName, lastName;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private boolean enabled;

    User withEmail(String email) {
        return new User(email, this.password, this.firstName, this.lastName, this.role, false);
    }
}
