package pageobjects.cadastrologin;

import core.base.BasePage;
import objeto.cadastrologin.CadastroLogin;

public class PageCadastroLogin extends BasePage {
    public void setURLCadastroLogin() {
        dslCadastroLogin.validarTelaNovoUsuario();
    }
    public void setEmailSenha(CadastroLogin cadastroLogin) {
        dslCadastroLogin.inserirEmailSenha(cadastroLogin);
    }
    public void setNomeSenha(CadastroLogin cadastroLogin) {
        dslCadastroLogin.inserirNomeSenha(cadastroLogin);
    }
    public void setNomeEmail(CadastroLogin cadastroLogin) {
        dslCadastroLogin.inserirNomeEmail(cadastroLogin);
    }
    public void setCamposVazio() {
        dslCadastroLogin.inserirCamposVazio();
    }
    public void setEmailUtilizado(CadastroLogin cadastroLogin) { dslCadastroLogin.inserirEmailUtilizado(cadastroLogin); }
}
