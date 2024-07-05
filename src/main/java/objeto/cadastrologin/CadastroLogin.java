package objeto.cadastrologin;

import objeto.baselogin.BaseLogin;

public class CadastroLogin extends BaseLogin {
    private String identificadorNome;
    private String nome;

    public CadastroLogin() {}

    public String getIdentificadorNome() {
        return identificadorNome;
    }

    public void setIdentificadorNome(String identificadorNome) {
        this.identificadorNome = identificadorNome;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
