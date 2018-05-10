package com.Assig3.Assig3.BusinessLogic;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.LoginDTO;

public interface IAuthenticationLogic {

    void register(String username, String password, String name, String surname);
    LoginDTO login(String username, String password);

}
