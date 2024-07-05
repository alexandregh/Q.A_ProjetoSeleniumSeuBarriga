package pageobjects.login;

import core.base.BasePage;
import objeto.login.Login;

public class PageLogin extends BasePage {
    public void setURLLogin() {
        dslLogin.validarTelaLogin();
    }
    public void setSenha(Login login) {
        dslLogin.inserirSenha(login);
    }
    public void setEmail(Login login) {
        dslLogin.inserirEmail(login);
    }
    public void setUsuarioInexistente(Login login) { dslLogin.logarUsuarioInexistente(login); }
    public void setCamposVazio() {
        dslLogin.inserirCamposVazio();
    }
    public void setLoginComSucesso(Login login) { dslLogin.realizarLoginComSucesso(login); }
}
