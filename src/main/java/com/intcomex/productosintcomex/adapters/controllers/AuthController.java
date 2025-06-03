package com.intcomex.productosintcomex.adapters.controllers;

import com.intcomex.productosintcomex.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Demo: acepta cualquier usuario/clave
        String token = JwtUtil.generateToken(username);
        return ResponseEntity.ok(token);
    }
}
