package SpringBoot.BookCMS_SpringBoot.services;

import SpringBoot.BookCMS_SpringBoot.controller.response.BookListResponse;
import SpringBoot.BookCMS_SpringBoot.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServices {

    @Autowired
    Connection connection;

    public BookListResponse getBookByCategoryID(Integer cateID, String order, String orderBy){
        BookListResponse response = new BookListResponse();
        List<BookEntity> data = null;
        String sqlQuery = "SELECT * FROM BOOK WHERE CATEGORY_idBOOK_CATEGORY = " + cateID + " ORDER BY "+ orderBy + " " + order + ";";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                if(data == null){
                    data = new ArrayList<>();
                }
                int idBook = rs.getInt("idBOOK");
                String title = rs.getString("Title");
                Time releaseTime = rs.getTime("ReleaseTime");
                String description = rs.getString("Decription");
                String author = rs.getString("Author");
                int price = rs.getInt("Price");
                String photoLink = rs.getString("PhotoLink");
                int idCate = rs.getInt("CATEGORY_idBOOK_CATEGORY");
                BookEntity item = new BookEntity(idBook, title, releaseTime, description, author, price, photoLink, idCate);
                data.add(item);
            }
            response.setData(data);
            response.setCode(200);
            response.setMessage("Success");
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return  response;
    }
}
