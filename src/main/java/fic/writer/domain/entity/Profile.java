package fic.writer.domain.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 2, max = 255)
    private String username;
    @Length(min = 5, max = 255)
    @Email
    private String email;
    private String imageUrl;
    private String about;
    private String information;

    @ManyToMany(mappedBy = "coauthors", fetch = FetchType.LAZY)
    @Singular("booksAsCoauthor")
    private Set<Book> booksAsCoauthor;

    @OneToMany(fetch = FetchType.LAZY)
    @Singular("booksAsAuthor")
    private Set<Book> booksAsAuthor;
}
