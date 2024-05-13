package gabs.validacao.senha.DTOs;

public class passwordRequest {

    private String password;

    public passwordRequest() {
    }

    public passwordRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
