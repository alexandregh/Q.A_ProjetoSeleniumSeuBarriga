package objeto.login;

import objeto.baselogin.BaseLogin;

public class Login extends BaseLogin {
    public Login() {}

    public String getIdentificadorEmail() {
        return identificadorEmail;
    }

    public void setIdentificadorEmail(String identificadorEmail) {
        this.identificadorEmail = identificadorEmail;
    }

    public String getIdentificadorSenha() {
        return identificadorSenha;
    }

    public void setIdentificadorSenha(String identificadorSenha) {
        this.identificadorSenha = identificadorSenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
