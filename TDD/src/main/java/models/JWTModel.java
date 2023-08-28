package models;

import lombok.Data;

@Data
public class JWTModel {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String image;
    private String token;
}
