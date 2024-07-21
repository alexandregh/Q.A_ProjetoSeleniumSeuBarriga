package core.dsl.dsllogin;


import core.dsl.dslbase.DSLBase;
import objeto.login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;

import static core.drivefactory.DriveFactory.getDriver;

public class DSLLogin extends DSLBase {
    /* ______ TELA LOGIN ______ */
    public void validarTelaLogin() {
        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/login",url);

        String nomeBotao;
        nomeBotao = getDriver().findElement(By.xpath(retornarNomeBotaoEntrar())).getText();
        Assert.assertEquals("Entrar",nomeBotao);
    }
    public void inserirSenha(Login login) {
        String msgEmail;

        login.setIdentificadorSenha("senha");
        login.setSenha("123456");

        getDriver().findElement(By.id(login.getIdentificadorSenha())).sendKeys(login.getSenha());
        getDriver().findElement(By.xpath(retornarCliqueBotaoEntrar())).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Email é um campo obrigatório']")).getText());

        Assert.assertEquals("Email é um campo obrigatório",msgEmail);
    }
    public void inserirEmail(Login login) {
        String msgSenha;

        login.setIdentificadorEmail("email");
        login.setEmail("sxandeogrande@yahoo.com.br");

        getDriver().findElement(By.id(login.getIdentificadorEmail())).sendKeys(login.getEmail());
        getDriver().findElement(By.xpath(retornarCliqueBotaoEntrar())).click();
        msgSenha = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Senha é um campo obrigatório']")).getText());

        Assert.assertEquals("Senha é um campo obrigatório",msgSenha);
    }
    public void inserirCamposVazio() {
        String msgEmail;
        String msgSenha;

        getDriver().findElement(By.xpath(retornarCliqueBotaoEntrar())).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Email é um campo obrigatório']")).getText());
        msgSenha = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Senha é um campo obrigatório']")).getText());

        Assert.assertEquals("Email é um campo obrigatório",msgEmail);
        Assert.assertEquals("Senha é um campo obrigatório",msgSenha);
    }
    public void logarUsuarioInexistente(Login login) {
        String msgUsuarioInexistente;

        login.setIdentificadorEmail("email");
        login.setEmail("usuario000@gmail.com.br");
        login.setIdentificadorSenha("senha");
        login.setSenha("123456");

        getDriver().findElement(By.id(login.getIdentificadorEmail())).sendKeys(login.getEmail());
        getDriver().findElement(By.id(login.getIdentificadorSenha())).sendKeys(login.getSenha());
        getDriver().findElement(By.xpath(retornarCliqueBotaoEntrar())).click();
        msgUsuarioInexistente = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());

        Assert.assertEquals("Problemas com o login do usuário",msgUsuarioInexistente);
    }
    public void realizarLoginComSucesso(Login login) {
        String msgUsuarioLogado;
        String btnSair;

        login.setIdentificadorEmail("email");
        login.setEmail("usuario1@gmail.com.br");
        login.setIdentificadorSenha("senha");
        login.setSenha("123456");

        getDriver().findElement(By.id(login.getIdentificadorEmail())).sendKeys(login.getEmail());
        getDriver().findElement(By.id(login.getIdentificadorSenha())).sendKeys(login.getSenha());
        getDriver().findElement(By.xpath(retornarCliqueBotaoEntrar())).click();
        msgUsuarioLogado = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());
        btnSair = retornarNomeBotao(getDriver().findElement(By.cssSelector("a[href='/logout']")).getText());

        String usuario = retornarNomeObjeto(msgUsuarioLogado.substring(11));
        usuario = retornarNomeBotao(usuario.replace("!",""));

        Assert.assertEquals("Bem vindo, " + usuario + "!",msgUsuarioLogado);
        Assert.assertEquals("Sair",btnSair);
    }
    /* ______ ELEMENTOS DE TEXTO ______ */

    /* ______ ELEMENTOS DE BOTÃO ______ */
    private String retornarNomeBotaoEntrar() {
        return "//div//form//button[normalize-space()='Entrar']";
    }
    private String retornarCliqueBotaoEntrar() {
        return "//button[normalize-space()='Entrar']";
    }
    /* ______ ELEMENTOS DE BOTÃO ______ */

    /* ______ ELEMENTOS DE MENSAGEM ______ */
    private String retornarMensagemGenerica() {
        return "//div[@role='alert']";
    }
    /* ______ ELEMENTOS DE MENSAGEM ______ */
}
