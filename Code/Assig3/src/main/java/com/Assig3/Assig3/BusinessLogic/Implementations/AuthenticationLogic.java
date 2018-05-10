package com.Assig3.Assig3.BusinessLogic.Implementations;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.LoginDTO;
import com.Assig3.Assig3.BusinessLogic.IAuthenticationLogic;
import com.Assig3.Assig3.DataAccess.Entities.Writer;
import com.Assig3.Assig3.DataAccess.Repositories.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class AuthenticationLogic implements IAuthenticationLogic {

    private WriterRepository writerRepository;

    @Autowired
    public AuthenticationLogic(WriterRepository writerRepository){

        this.writerRepository = writerRepository;

    }

    @Override
    public void register(String username, String password, String name, String surname) {

        Writer checkWriter = writerRepository.findById(username).orElse(null);

        if(checkWriter == null) {

            try {

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

                String passwordHash = new String(Base64.getEncoder().encode(hash));

                Writer writer = new Writer();
                writer.setName(name);
                writer.setSurname(surname);
                writer.setUsername(username);
                writer.setPassword(passwordHash);

                writerRepository.save(writer);

            } catch (NoSuchAlgorithmException e) {
                System.out.println("The algorithm was not found!");
                e.printStackTrace();
            }

        }

    }

    @Override
    public LoginDTO login(String username, String password) {

        Writer writer = writerRepository.findById(username).orElse(null);

        if(writer == null){

            return null;


        }

        LoginDTO dto = new LoginDTO();
        dto.setUsername(writer.getUsername());

        return dto;

        /*

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String passwordHash = new String(Base64.getEncoder().encode(hash));

            if(passwordHash.equals(writer.getPassword())){
                return writer.getUsername();
            }

            return null;


        } catch (NoSuchAlgorithmException e) {
            System.out.println("The algorithm was not found!");
            return null;
        }

        */

    }
}
