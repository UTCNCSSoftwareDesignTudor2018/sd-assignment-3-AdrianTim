package com.Assig3.Assig3.RouterLayer;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.LoginDTO;
import com.Assig3.Assig3.BusinessLogic.IAuthenticationLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(path = "/auth")
public class AuthenticationController {

    private IAuthenticationLogic authenticationLogic;

    @Autowired
    public AuthenticationController(IAuthenticationLogic authenticationLogic) {
        this.authenticationLogic = authenticationLogic;
    }

    @PostMapping(path = "/login")
    public @ResponseBody LoginDTO login(@RequestBody LoginDTO loginDTO){

        return authenticationLogic.login(loginDTO.getUsername(), loginDTO.getPassword());

    }

    @GetMapping(path = "/register")
    public @ResponseBody void register(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String surname){
        authenticationLogic.register(username, password, name, surname);
    }

}
