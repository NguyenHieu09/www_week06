package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Column(length = 15)
    private String mobile;
    @Column(length = 6)
    private Instant lastLogin;
    @Column(length = 50, name = "last_name")
    private String lastName;
    @Lob
    private String intro;
    @Lob
    private String profile;
    @Column(length = 50, name = "middle_name")
    private String middleName;

    private Instant registeredAt;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<PostComment> commments;
    @Column(name = "password_hash", length = 32)
    private String passwordHash;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Post> posts;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String email;

//    public User(String mobile, Instant lastLogin, String lastName, String intro, String profile, Instant registeredAt, String passwordHash, String firstName, String email) {
//        this.mobile = mobile;
//        this.lastLogin = lastLogin;
//        this.lastName = lastName;
//        this.intro = intro;
//        this.profile = profile;
//        this.registeredAt = registeredAt;
//        this.passwordHash = passwordHash;
//        this.firstName = firstName;
//        this.email = email;
//    }


    public User(String mobile, Instant lastLogin, String lastName, String intro, String profile, Instant registeredAt, String passwordHash, String middleName, String firstName, String email) {
        this.mobile = mobile;
        this.lastLogin = lastLogin;
        this.lastName = lastName;
        this.intro = intro;
        this.profile = profile;
        this.registeredAt = registeredAt;
        this.passwordHash = passwordHash;
        this.middleName = middleName;
        this.firstName = firstName;
        this.email = email;
    }
}
