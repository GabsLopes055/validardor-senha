package gabs.validacao.senha.controller;

import gabs.validacao.senha.DTOs.passwordRequest;
import gabs.validacao.senha.service.ValidarSenha;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/")
public class ValidarSenhaController {

    private final ValidarSenha service;

    public ValidarSenhaController(ValidarSenha service) {
        this.service = service;
    }

    @PostMapping(value = "validate-password")
    public ResponseEntity<List<String>> validarSenha(@RequestBody passwordRequest password) {
        List<String> listaErros = service.validarSenha(password);
        if (listaErros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaErros);
        }
    }

}
