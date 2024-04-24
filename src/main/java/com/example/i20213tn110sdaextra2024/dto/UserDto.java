package com.example.i20213tn110sdaextra2024.dto;

import com.example.i20213tn110sdaextra2024.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    Long id;

    @NotBlank(message = "Nombre requerido")
    @Size(max =30, message="No mas de 30 caracteres")
    String name;

    @NotBlank(message = "Apellidos requerido")
    @Size(max =30, message="No mas de 30 caracteres")
    String surname;

    @NotBlank(message = "Email requerido")
    @Size(max =50, message="No mas de 50 caracteres")
    @Email(message = "Formato de email incorrecto")
    String email;

    @NotBlank(message = "Fecha de nacimiento requerida")
    String birthdate;

    @Size(min =8, message="Mínimo 8 caracteres")
    String password;

    public User registrarUser() throws ParseException {
        Date fechaNac;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac = formato.parse(birthdate);
        }catch(ParseException e){
            throw new RuntimeException();
        }

        return new User(getName(),getSurname(),getEmail(),fechaNac,getPassword());
    }
}
