package SpringBoot.BookCMS_SpringBoot.controller;

import SpringBoot.BookCMS_SpringBoot.controller.response.BookListResponse;
import SpringBoot.BookCMS_SpringBoot.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookServices bookServices;
    @GetMapping(value = "/{category-id}")
    public BookListResponse getBookByCategoryID(@PathVariable(name = "category-id") Integer cateID,
                                                @RequestParam(name = "order", defaultValue = "ASC")String order,
                                                @RequestParam(name = "orderBy", defaultValue ="title" ) String orderBy){
        return  bookServices.getBookByCategoryID(cateID, order, orderBy);
    }
}
