package core.dsl.dslcadastrologin;

import core.dsl.dslbase.DSLBase;
import objeto.cadastrologin.CadastroLogin;
import org.junit.Assert;
import org.openqa.selenium.By;

import static core.drivefactory.DriveFactory.getDriver;

public class DSLCadastroLogin extends DSLBase {
    /* ______ ELEMENTOS DE TEXTO ______ */
    public void inserirEmailSenha(CadastroLogin cadastroLogin) {
        String msgNome;

        cadastroLogin.setIdentificadorEmail("email");
        cadastroLogin.setEmail("sxandeogrande@yahoo.com.br");
        cadastroLogin.setIdentificadorSenha("senha");
        cadastroLogin.setSenha("123456");

        getDriver().findElement(By.cssSelector("a[href='/cadastro']")).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorEmail())).sendKeys(cadastroLogin.getEmail());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorSenha())).sendKeys(cadastroLogin.getSenha());
        getDriver().findElement(By.xpath("//input[@value='Cadastrar']")).click();
        msgNome = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Nome é um campo obrigatório",msgNome);
    }
    public void inserirNomeSenha(CadastroLogin cadastroLogin) {
        String msgEmail;

        cadastroLogin.setIdentificadorNome("nome");
        cadastroLogin.setNome("Alexandre");
        cadastroLogin.setIdentificadorSenha("senha");
        cadastroLogin.setSenha("123456");

        getDriver().findElement(By.cssSelector("a[href='/cadastro']")).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorNome())).sendKeys(cadastroLogin.getNome());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorSenha())).sendKeys(cadastroLogin.getSenha());
        getDriver().findElement(By.xpath("//input[@value='Cadastrar']")).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Email é um campo obrigatório",msgEmail);
    }
    public void inserirNomeEmail(CadastroLogin cadastroLogin) {
        String msgEmail;

        cadastroLogin.setIdentificadorNome("nome");
        cadastroLogin.setNome("Alexandre");
        cadastroLogin.setIdentificadorEmail("email");
        cadastroLogin.setEmail("sxandeogrande@yahoo.com.br");

        getDriver().findElement(By.cssSelector("a[href='/cadastro']")).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorNome())).sendKeys(cadastroLogin.getNome());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorEmail())).sendKeys(cadastroLogin.getEmail());
        getDriver().findElement(By.xpath("//input[@value='Cadastrar']")).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Senha é um campo obrigatório",msgEmail);
    }
    public void inserirCamposVazio() {
        String msgNome;
        String msgEmail;
        String msgSenha;

        getDriver().findElement(By.cssSelector("a[href='/cadastro']")).click();
        getDriver().findElement(By.xpath("//input[@value='Cadastrar']")).click();
        msgNome = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Nome é um campo obrigatório']")).getText());
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Email é um campo obrigatório']")).getText());
        msgSenha = retornarMensagemTela(getDriver().findElement(By.xpath("//div[normalize-space()='Senha é um campo obrigatório']")).getText());

        Assert.assertEquals("Nome é um campo obrigatório",msgNome);
        Assert.assertEquals("Email é um campo obrigatório",msgEmail);
        Assert.assertEquals("Senha é um campo obrigatório",msgSenha);
    }
    public void inserirEmailUtilizado(CadastroLogin cadastroLogin) {
        String msgEmailUtilizado;

        cadastroLogin.setIdentificadorNome("nome");
        cadastroLogin.setNome("Alexandre");
        cadastroLogin.setIdentificadorEmail("email");
        cadastroLogin.setEmail("usuario1@gmail.com.br");
        cadastroLogin.setIdentificadorSenha("senha");
        cadastroLogin.setSenha("123456");

        getDriver().findElement(By.cssSelector("a[href='/cadastro']")).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorNome())).sendKeys(cadastroLogin.getNome());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorEmail())).sendKeys(cadastroLogin.getEmail());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorSenha())).sendKeys(cadastroLogin.getSenha());
        getDriver().findElement(By.xpath("//input[@value='Cadastrar']")).click();
        msgEmailUtilizado = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Endereço de email já utilizado",msgEmailUtilizado);
    }
    /* ______ ELEMENTOS DE TEXTO ______ */

    /* ______ ELEMENTOS DE TELA ______ */
    public void validarTelaNovoUsuario() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Novo usuário?']")).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/cadastro",url);

        String nomeBotao;
        nomeBotao = getDriver().findElement(By.xpath("//div//form//input[@value='Cadastrar']")).getAttribute("value");
        Assert.assertEquals("Cadastrar",nomeBotao);
    }
    /* ______ ELEMENTOS DE TELA ______ */
}
