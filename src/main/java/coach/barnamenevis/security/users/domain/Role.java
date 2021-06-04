package coach.barnamenevis.security.users.domain;

import coach.barnamenevis.security.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ElementCollection(targetClass = Authority.class,fetch = FetchType.EAGER)
    private List<Authority> authorities;
}
