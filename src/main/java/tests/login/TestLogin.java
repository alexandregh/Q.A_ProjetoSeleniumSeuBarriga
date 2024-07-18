package tests.login;

import core.base.BaseTest;
import objeto.login.Login;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobjects.login.PageLogin;

import static core.drivefactory.DriveFactory.getDriver;
import static core.drivefactory.DriveFactory.killDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLogin extends BaseTest {
    private PageLogin pageLogin;
    private Login login;

    @Before
    public void inicializar() {
        pageLogin = new PageLogin();
        login = new Login();
        BaseTest baseTest = new BaseTest();
        String nomeClasse = this.getClass().getSimpleName();
        baseTest.definirNomeClasse(nomeClasse);
        getDriver().get("https://seubarriga.wcaquino.me/");
    }
    @Test
    public void teste1_validarURLLogin() {
        pageLogin.setURLLogin();
    }
    @Test
    public void teste2_validarEmailVazio() {
        pageLogin.setSenha(login);
    }
    @Test
    public void teste3_validarSenhaVazio() {
        pageLogin.setEmail(login);
    }
    @Test
    public void teste4_validarEmailESenhaVazio() {
        pageLogin.setCamposVazio();
    }
    @Test
    public void teste5_validarUsuarioInexistente() { pageLogin.setUsuarioInexistente(login); }
    @Test
    public void teste6_realizarLoginComSucesso() { pageLogin.setLoginComSucesso(login); }
    @AfterClass
    public static void encerrarBrowser() {
        killDriver();
    }
}
