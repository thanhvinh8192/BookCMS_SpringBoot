package SpringBoot.BookCMS_SpringBoot.controller.response;

import SpringBoot.BookCMS_SpringBoot.model.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class BookListResponse {
    private  Integer code;
    private String message;
    private List<BookEntity> data;
}
