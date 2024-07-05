package core.dsl.dsllogin;


import core.dsl.dslbase.DSLBase;
import objeto.login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;

import static core.drivefactory.DriveFactory.getDriver;

public class DSLLogin extends DSLBase {
    /* ______ ELEMENTOS DE TEXTO ______ */
    public void inserirSenha(Login login) {
        String msgEmail = retornarMensagemTela("");

        login.setIdentificadorSenha("senha");
        login.setSenha("123456");

        getDriver().findElement(By.id(login.getIdentificadorSenha())).sendKeys(login.getSenha());
        getDriver().findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Email é um campo obrigatório']")).getText());

        Assert.assertEquals("Email é um campo obrigatório",msgEmail);
    }
    public void inserirEmail(Login login) {
        String msgSenha = retornarMensagemTela("");

        login.setIdentificadorEmail("email");
        login.setEmail("sxandeogrande@yahoo.com.br");

        getDriver().findElement(By.id(login.getIdentificadorEmail())).sendKeys(login.getEmail());
        getDriver().findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
        msgSenha = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Senha é um campo obrigatório']")).getText());

        Assert.assertEquals("Senha é um campo obrigatório",msgSenha);
    }
    public void inserirCamposVazio() {
        String msgEmail = retornarMensagemTela("");
        String msgSenha = retornarMensagemTela("");

        getDriver().findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Email é um campo obrigatório']")).getText());
        msgSenha = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Senha é um campo obrigatório']")).getText());

        Assert.assertEquals("Email é um campo obrigatório",msgEmail);
        Assert.assertEquals("Senha é um campo obrigatório",msgSenha);
    }
    public void logarUsuarioInexistente(Login login) {
        String msgUsuarioInexistente = retornarMensagemTela("");

        login.setIdentificadorEmail("email");
        login.setEmail("usuario000@gmail.com.br");
        login.setIdentificadorSenha("senha");
        login.setSenha("123456");

        getDriver().findElement(By.id(login.getIdentificadorEmail())).sendKeys(login.getEmail());
        getDriver().findElement(By.id(login.getIdentificadorSenha())).sendKeys(login.getSenha());
        getDriver().findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
        msgUsuarioInexistente = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Problemas com o login do usuário",msgUsuarioInexistente);
    }
    public void realizarLoginComSucesso(Login login) {
        String msgUsuarioLogado = retornarMensagemTela("");
        String btnSair = retornarNomeBotao("");

        login.setIdentificadorEmail("email");
        login.setEmail("usuario1@gmail.com.br");
        login.setIdentificadorSenha("senha");
        login.setSenha("123456");

        getDriver().findElement(By.id(login.getIdentificadorEmail())).sendKeys(login.getEmail());
        getDriver().findElement(By.id(login.getIdentificadorSenha())).sendKeys(login.getSenha());
        getDriver().findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
        msgUsuarioLogado = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());
        btnSair = retornarNomeBotao(getDriver().findElement(By.cssSelector("a[href='/logout']")).getText());

        String usuario = retornarNomeObjeto(msgUsuarioLogado.substring(11));
        usuario = retornarNomeBotao(usuario.replace("!",""));

        Assert.assertEquals("Bem vindo, " + usuario + "!",msgUsuarioLogado);
        Assert.assertEquals("Sair",btnSair);
    }
    /* ______ ELEMENTOS DE TEXTO ______ */

    /* ______ ELEMENTOS DE TELA ______ */
    public void validarTelaLogin() {
        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/login",url);

        String nomeBotao = retornarNomeBotao("");
        nomeBotao = getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Entrar']")).getText();
        Assert.assertEquals("Entrar",nomeBotao);
    }
    /* ______ ELEMENTOS DE TELA ______ */
}
