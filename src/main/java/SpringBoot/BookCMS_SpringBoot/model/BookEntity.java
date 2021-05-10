package SpringBoot.BookCMS_SpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class BookEntity {
    private  int idBook;
    private String title;
    private Time releaseTime;
    private String description;
    private String author;
    private long price;
    private String photoLink;
    private int idCategory;
}
