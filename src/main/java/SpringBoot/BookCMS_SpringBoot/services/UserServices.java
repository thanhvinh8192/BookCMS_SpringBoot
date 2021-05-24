package SpringBoot.BookCMS_SpringBoot.services;

import SpringBoot.BookCMS_SpringBoot.controller.request.LoginRequest;
import SpringBoot.BookCMS_SpringBoot.controller.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServices {

    //@Autowired
    Connection connection;

    public String register(RegisterRequest register){
        //Check Phone number
        if(register.getPhoneNumber() == null || register.getPhoneNumber().equals("") || register.getPhoneNumber().length() != 10){
            return "Phone number is not correct";
        }

        //Check Email
        if(StringUtils.isEmpty(register.getEmail()) || !register.getEmail().contains("@gmail.com")){
            return "Email must be Gmail";
        }

        //Check Password
        if (StringUtils.isEmpty(register.getPassword()) || register.getPassword().length()<8){
            return "Password must be at least 8 characters";
        }

        //Query Database
        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + register.getPhoneNumber() + "'" + " OR Email = '" + register.getEmail() + "';";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            while (rs.next()){
                return "Phone number or email is exists";
            }
            //Insert user
            sqlQuery ="INSERT INTO `manage_book_market`.`USER` (`PhoneNumber`, `Username`, `Password`, `Email`) " +
                    "VALUES ('" + register.getPhoneNumber() + "', '" + register.getUserName() + "', '" + register.getPassword() + "', '" + register.getEmail() + "');";
            stm.executeUpdate(sqlQuery);
            stm.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return "Register failed by internal error";
        }

        return "Register Success";
    }

    public String login(LoginRequest request){
        //Query database
        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + request.getPhoneNumber() + "'";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            while (rs.next()) {
                if(request.getPhoneNumber().equals(rs.getString("PhoneNumber"))){
                    if(request.getPassword().equals(rs.getString("Password"))){
                        return  "Login Success";
                    }
                    else return "Email or Password is incorrect";
                }
            }
            stm.close();
        }
        catch (SQLException sqlException)
        {
            System.out.println(sqlException);
        }
        return "Account is not exist!";
    }
}
