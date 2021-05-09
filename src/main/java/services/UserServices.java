package services;

import controller.request.LoginRequest;
import controller.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServices {

    @Autowired
    Connection connection;

    public String register(RegisterRequest register){
        //Check Phone number
        if(register.getPhoneNumber() == null || register.getPhoneNumber() == "" || register.getPhoneNumber().length() != 10){
            return "Phone number is not correct";
        }

        //Check Email
        if(StringUtils.isEmpty(register.getEmail()) || !register.getEmail().contains("@gmail.com")){
            return "Email khong hop le";
        }

        //Check Password
        if (StringUtils.isEmpty(register.getPassword()) || register.getPassword().length()<8){
            return "Password must be at least 8 characters";
        }

        //Query Database
        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + register.getPhoneNumber() + "'" + "OR Email = '" + register.getEmail() + "';";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            while (rs.next()){
                return "Phone number or email is exists";
            }

            //Insert user
            String sqlInsertUser = "INSERT INTO `manage_book_market`.`USER` (`PhoneNumber`, `Username`, `Password`, `Email`) VALUES ('" + register.getPhoneNumber() + "', '" + register.getUserName() + "', '" + register.getPassword() + "', '" + register.getEmail() + ");\n";
            stm.executeUpdate(sqlInsertUser);
            stm.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return "Register Success";
    }

    public String login(LoginRequest request){
        //Query database
        String sqlQuery = "SELECT * FROM manage_book_market.USER WHERE PhoneNumber = '" + request.getPhoneNumber() + "'";
        String msg = "";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlQuery);
            while (rs.next()) {
                if(request.getPhoneNumber().equals(rs.getString("PhoneNumber"))){
                    if(request.getPassword().equals(rs.getString("Password"))){
                        return  msg ="Login Success";
                    }
                    else return msg = "Email or Password is incorrect";
                }
                else return msg = "Account is not exist!";

            }
            stm.close();
        }
        catch (SQLException sqlException)
        {
            System.out.println(sqlException);
        }
        return msg;
    }
}
