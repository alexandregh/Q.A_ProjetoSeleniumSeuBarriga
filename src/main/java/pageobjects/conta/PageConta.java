package pageobjects.conta;

import core.base.BasePage;
import objeto.conta.Conta;
import objeto.login.Login;

public class PageConta extends BasePage {
    public void setInserirConta(Login login,Conta conta) { dslConta.inserirConta(login,conta); }
    public void setInserirContaCadastrada(Login login,Conta conta) { dslConta.inserirContaCadastrada(login,conta); }
    public void setAlterarConta(Login login,Conta conta) { dslConta.alterarConta(login,conta); }
    public void setRemoverConta(Login login,Conta conta) { dslConta.removerConta(login,conta); }
}
