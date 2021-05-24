package SpringBoot.BookCMS_SpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private  Integer idBook;

    @Column(name = "Title")
    private String title;

    @Column(name = "ReleaseTime")
    private Time releaseTime;

    @Column(name = "Description")
    private String description;

    @Column(name = "Author")
    private String author;

    @Column(name = "Price")
    private Long price;

    @Column(name = "PhotoLink")
    private String photoLink;

    @Column(name = "CATEGORY_idBOOK_CATEGORY")
    private Integer cateID;
}
