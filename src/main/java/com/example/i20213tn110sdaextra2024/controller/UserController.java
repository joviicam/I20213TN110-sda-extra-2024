package com.example.i20213tn110sdaextra2024.controller;

import com.example.i20213tn110sdaextra2024.dto.UserDto;
import com.example.i20213tn110sdaextra2024.service.UserService;

import com.example.i20213tn110sdaextra2024.utils.Response;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar (@RequestBody @Valid UserDto userDto){
        try{
            userService.registrar(userDto);
            return ResponseEntity.ok("Registro exitoso!");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(new Response(true, e.getMessage()));
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<?> validar (@RequestParam Long id){
        try{
            String message = userService.validar(id);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.ok("No");
        }
    }

}
