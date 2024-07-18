package tests.cadastrologin;

import core.base.BaseTest;
import objeto.cadastrologin.CadastroLogin;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobjects.cadastrologin.PageCadastroLogin;

import static core.drivefactory.DriveFactory.getDriver;
import static core.drivefactory.DriveFactory.killDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCadastroLogin extends BaseTest {
    private PageCadastroLogin pageCadastroLogin;
    private CadastroLogin cadastroLogin;

    @Before
    public void inicializar() {
        pageCadastroLogin = new PageCadastroLogin();
        cadastroLogin = new CadastroLogin();
        BaseTest baseTest = new BaseTest();
        getDriver().get("https://seubarriga.wcaquino.me/");
        String nomeClasse = this.getClass().getSimpleName();
        baseTest.definirNomeClasse(nomeClasse);
    }
    @Test
    public void teste1_validarURLCadastrarLogin() {
        pageCadastroLogin.setURLCadastroLogin();
    }
    @Test
    public void teste2_validarNomeVazio() {
        pageCadastroLogin.setEmailSenha(cadastroLogin);
    }
    @Test
    public void teste3_validarEmailVazio() {
        pageCadastroLogin.setNomeSenha(cadastroLogin);
    }
    @Test
    public void teste4_validarSenhaVazio() {
        pageCadastroLogin.setNomeEmail(cadastroLogin);
    }
    @Test
    public void teste5_validarCamposVazio() {
        pageCadastroLogin.setCamposVazio();
    }
    @Test
    public void teste6_validarEmailUtilizado() {
        pageCadastroLogin.setEmailUtilizado(cadastroLogin);
    }
    @AfterClass
    public static void encerrarBrowser() {
        killDriver();
    }
}
