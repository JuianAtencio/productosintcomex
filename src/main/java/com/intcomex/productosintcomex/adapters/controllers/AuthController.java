package com.intcomex.productosintcomex.adapters.controllers;

import com.intcomex.productosintcomex.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * Endpoint para autenticación de usuarios.
     * Genera un token JWT si las credenciales son válidas.
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String token = JwtUtil.generateToken(username);
        return ResponseEntity.ok(token);
    }
}
