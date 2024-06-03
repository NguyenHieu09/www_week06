package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "post_comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostComment {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @Column(length = 100)
    private String tittle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;

    private Boolean published;
    @Lob
    private String content;
    @Column(name = "published_at")
    private Instant publishedAt;
    @Column(name = "created_at")
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment parent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
