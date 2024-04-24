package com.example.i20213tn110sdaextra2024.service;

import com.example.i20213tn110sdaextra2024.dto.UserDto;
import com.example.i20213tn110sdaextra2024.model.User;
import com.example.i20213tn110sdaextra2024.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registrar(UserDto userDto) throws ParseException, IOException {

        User user = userDto.registrarUser();
        if(user.getName()==null || user.getSurname()==null || user.getEmail()==null || user.getBirthdate()==null){
            throw new IOException("Faltan campos");
        }
        if(user.getPassword()!=null && user.getPassword().length()<8){
            throw new IOException("Longitud de la contraseña invalida");
        }
        if(user.getName().length()>30 || user.getSurname().length()>30){
            throw new IOException("Longitud nombre o apellidos debe ser menor a 30");
        }
        if(user.getEmail().length()>50){
            throw new IOException("Longitud del email debe ser menor a 50 caracteres");
        }
        Date fechaNac = user.getBirthdate();
        Date current = new Date();
        if(fechaNac.after(current)){
            throw new IOException("Fecha de nacimiento mayor a la fecha actual");
        }

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
