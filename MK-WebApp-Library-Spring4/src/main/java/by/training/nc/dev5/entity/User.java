package by.training.nc.dev5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NamedQueries({ @NamedQuery(name = "User.findByNameAndPassword",
                    query = "SELECT u FROM users u WHERE u.name=?1 AND u.password=?2"),
                @NamedQuery(name = "User.selectAll",
                    query = "SELECT u FROM users u"),
                @NamedQuery(name = "User.findByName",
                    query = "SELECT u FROM users u WHERE u.name=?1 ")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

}
