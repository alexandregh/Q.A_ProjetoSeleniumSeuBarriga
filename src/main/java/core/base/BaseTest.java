package core.base;

import core.dsl.dslbase.DSLBase;
import core.properties.Properties;
import objeto.login.Login;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.drivefactory.DriveFactory.getDriver;
import static core.drivefactory.DriveFactory.killDriver;

public class BaseTest extends DSLBase {
    @Rule
    public TestName testName = new TestName();

    static String nomeClasse;

    @After
    public void finalizarTestes() throws IOException {
        capiturarScreenshot();
        fecharBrowser();
    }
    private void capiturarScreenshot() throws IOException {
        final String EXTENSAO = ".jpg";
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        File diretorio = new File(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + "screenshot"
                + File.separator + nomeClasse
                + File.separator + testName.getMethodName()
                + EXTENSAO);
        FileUtils.copyFile(arquivo, diretorio);
    }
    private void fecharBrowser() {
        if (Properties.FECHAR_BROWSER) {
            killDriver();
        }
    }
    public void definirNomeClasse(String nomeClasse) {
        BaseTest.nomeClasse = nomeClasse;
    }

    //____________________________________

    public void executarPreCondicoes(Login login) {
        realizarLogin(login);
    }
    private void realizarLogin(Login login) {
        String msgUsuarioLogado;
        String btnSair;

        login.setIdentificadorEmail("email");
        login.setEmail("usuario1@gmail.com.br");
        login.setIdentificadorSenha("senha");
        login.setSenha("123456");

        getDriver().findElement(By.id(login.getIdentificadorEmail())).sendKeys(login.getEmail());
        getDriver().findElement(By.id(login.getIdentificadorSenha())).sendKeys(login.getSenha());
        getDriver().findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
        msgUsuarioLogado = getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
        btnSair = getDriver().findElement(By.cssSelector("a[href='/logout']")).getText();

        String usuario = msgUsuarioLogado.substring(11);
        usuario = usuario.replace("!","");

        Assert.assertEquals("Bem vindo, " + usuario + "!",msgUsuarioLogado);
        Assert.assertEquals("Sair",btnSair);
    }
}
