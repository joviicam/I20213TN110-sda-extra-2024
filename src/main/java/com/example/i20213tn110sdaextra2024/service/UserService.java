package com.example.i20213tn110sdaextra2024.service;

import com.example.i20213tn110sdaextra2024.dto.UserDto;
import com.example.i20213tn110sdaextra2024.model.User;
import com.example.i20213tn110sdaextra2024.repository.UserRepository;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registrar(UserDto userDto) throws ParseException {

        User user = userDto.registrarUser();
        return userRepository.save(user);
    }

    public String validar(Long id)  {
        Optional <User> userOpcional = userRepository.findUserById(id);
        if(userOpcional.isPresent()){
            Date fechaNac = userOpcional.get().getBirthdate();
            Date current = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaNac);
            int year = cal.get(Calendar.YEAR);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(current);
            int year2 = cal2.get(Calendar.YEAR);
            if(year2-year>=18){
                return "Usuario válido";
            }else{
                return "Usuario menor a 18 años";
            }
        }else{
            return "Usuario no encontrado";
        }

    }

}
