package gabs.validacao.senha.service;

import gabs.validacao.senha.DTOs.passwordRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidarSenha {

    public List<String> validarSenha(passwordRequest password) {

        List<String> listaErros = new ArrayList<>();

        validarTamanhoSenha(password.getPassword(), listaErros);
        validarLetraMaiscula(password.getPassword(), listaErros);
        validarLetraMinuscula(password.getPassword(), listaErros);
        validarNumero(password.getPassword(), listaErros);
        validarContemCaracterEspecial(password.getPassword(), listaErros);

        return listaErros;
    }

    /*Verificar se a senha possui pelo menos 08 caracteres.*/
    public void validarTamanhoSenha(String password, List<String> listaErros) {
        if (password.length() < 8) {
            listaErros.add("Senha menor que 8 caracteres");
        }
    }

    /*Verificar se a senha contém pelo menos uma letra maiúscula.*/
    public void validarLetraMaiscula(String password, List<String> listaErros) {

        Pattern regex = Pattern.compile("[A-Z]");

        Matcher contemMaiusculo = regex.matcher(password);

        if (!contemMaiusculo.find()) {
            listaErros.add("Senha não contem letra maiúscula");
        }
    }

    /*Verificar se a senha contém pelo menos uma letra minuscula.*/
    public void validarLetraMinuscula(String password, List<String> listaErros) {

        Pattern regex = Pattern.compile("[a-z]");

        Matcher contemMinuscula = regex.matcher(password);

        if (!contemMinuscula.find()) {
            listaErros.add("Senha não contem letra minúscula");
        }
    }

    /*Verificar se a senha contém pelo menos um dígito numérico*/
    public void validarNumero(String password, List<String> listaErros) {

        Pattern regex = Pattern.compile("[0-9]");

        Matcher contemMinuscula = regex.matcher(password);

        if (!contemMinuscula.find()) {
            listaErros.add("Senha não contem números");
        }
    }

    /*Verificar se a senha contém pelo menos um caractere especial (e.g, !@#$%).*/
    private void validarContemCaracterEspecial(String password, List<String> listaErros) {

        if(!(password.contains("!") || password.contains("@") || password.contains("#") || password.contains("$") || password.contains("!") || password.contains("%"))) {
            listaErros.add("Senha não contem caracteres especiais");
        }

    }

}
