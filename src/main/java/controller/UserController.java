package controller;

import controller.request.LoginRequest;
import controller.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserServices;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServices userServices;
    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterRequest request){
        String result = userServices.register(request);
        return result;
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest request){
        String result = userServices.login(request);
        return result;
    }

}
