package tests.conta;

import core.base.BaseTest;
import objeto.conta.Conta;
import objeto.login.Login;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobjects.conta.PageConta;

import static core.drivefactory.DriveFactory.getDriver;
import static core.drivefactory.DriveFactory.killDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestConta extends BaseTest {
    private PageConta pageConta;
    private Login login;
    private Conta conta;
    private BaseTest baseTest;
    private String nomeClasse;
    @Before
    public void inicializar() {
        pageConta = new PageConta();
        login = new Login();
        conta = new Conta();
        baseTest = new BaseTest();
        nomeClasse = this.getClass().getSimpleName();
        baseTest.definirNomeClasse(nomeClasse);
        getDriver().get("https://seubarriga.wcaquino.me/");
    }
    @Test
    public void teste1_inserirConta() {
        pageConta.setInserirConta(login,conta);
    }
    @Test
    public void teste2_inserirContaCadastrada() {
        pageConta.setInserirContaCadastrada(login,conta);
    }
    @Test
    public void teste3_alterarConta() {
        pageConta.setAlterarConta(login,conta);
    }
    @Test
    public void teste4_removerConta() {
        pageConta.setRemoverConta(login,conta);
    }
    @AfterClass
    public static void encerrarBrowser() {
        killDriver();
    }
}
