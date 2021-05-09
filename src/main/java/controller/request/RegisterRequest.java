package controller.request;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RegisterRequest {
    private String phoneNumber;
    private String userName;
    private String password;
    private String email;
}
