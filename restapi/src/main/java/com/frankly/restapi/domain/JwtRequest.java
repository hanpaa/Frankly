package com.frankly.restapi.domain;

import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.Serializable;

@Getter @Setter
//JSON parse 위해 default 생성자 필요
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private String email;
    private String password;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}
