package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean published;
    @Lob
    private String content;
    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;

    @Column(length = 100, name = "meta_title")
    private String metaTitle;
    @Lob
    private String summary;
    @Column(name = "create_at")
    private Instant createdAt;
    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();
    @Column(length = 75)
    private String title;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    private User author;
}
