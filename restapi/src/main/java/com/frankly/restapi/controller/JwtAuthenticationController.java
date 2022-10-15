package com.frankly.restapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class JwtAuthenticationController {
/*

    @Autowired
    private UserAuthProvider userAuthProvider;


    @Autowired
    private JwtUserDetailsService userDetailsService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserRequestDTO authenticationRequest) throws Exception {

        try {
            userAuthProvider.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getName(), authenticationRequest.getPassword()));

            UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getName());
            //String token = jwtTokenUtil.generateToken(userDetails);


            return null;

        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }


    }

*/
}
