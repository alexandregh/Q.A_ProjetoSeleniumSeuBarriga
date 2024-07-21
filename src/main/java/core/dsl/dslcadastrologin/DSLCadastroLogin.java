package core.dsl.dslcadastrologin;

import core.dsl.dslbase.DSLBase;
import objeto.cadastrologin.CadastroLogin;
import org.junit.Assert;
import org.openqa.selenium.By;

import static core.drivefactory.DriveFactory.getDriver;

public class DSLCadastroLogin extends DSLBase {
    /* ______ TELA CADASTRO LOGIN ______ */
    public void validarTelaNovoUsuario() {
        getDriver().findElement(By.xpath(retornarCliqueNovoUsuario())).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/cadastro",url);

        String nomeBotao = getDriver().findElement(By.xpath(retornarNomeBotaoCadastrar())).getAttribute("value");
        Assert.assertEquals("Cadastrar",nomeBotao);
    }
    public void inserirEmailSenha(CadastroLogin cadastroLogin) {
        String msgNome;

        cadastroLogin.setIdentificadorEmail("email");
        cadastroLogin.setEmail("sxandeogrande@yahoo.com.br");
        cadastroLogin.setIdentificadorSenha("senha");
        cadastroLogin.setSenha("123456");

        getDriver().findElement(By.xpath(retornarCliqueNovoUsuario())).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorEmail())).sendKeys(cadastroLogin.getEmail());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorSenha())).sendKeys(cadastroLogin.getSenha());
        getDriver().findElement(By.xpath(retornarCliqueBotaoCadastro())).click();
        msgNome = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());

        Assert.assertEquals("Nome é um campo obrigatório",msgNome);
    }
    public void inserirNomeSenha(CadastroLogin cadastroLogin) {
        String msgEmail;

        cadastroLogin.setIdentificadorNome("nome");
        cadastroLogin.setNome("Alexandre");
        cadastroLogin.setIdentificadorSenha("senha");
        cadastroLogin.setSenha("123456");

        getDriver().findElement(By.xpath(retornarCliqueNovoUsuario())).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorNome())).sendKeys(cadastroLogin.getNome());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorSenha())).sendKeys(cadastroLogin.getSenha());
        getDriver().findElement(By.xpath(retornarCliqueBotaoCadastro())).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());

        Assert.assertEquals("Email é um campo obrigatório",msgEmail);
    }
    public void inserirNomeEmail(CadastroLogin cadastroLogin) {
        String msgEmail;

        cadastroLogin.setIdentificadorNome("nome");
        cadastroLogin.setNome("Alexandre");
        cadastroLogin.setIdentificadorEmail("email");
        cadastroLogin.setEmail("sxandeogrande@yahoo.com.br");

        getDriver().findElement(By.xpath(retornarCliqueNovoUsuario())).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorNome())).sendKeys(cadastroLogin.getNome());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorEmail())).sendKeys(cadastroLogin.getEmail());
        getDriver().findElement(By.xpath(retornarCliqueBotaoCadastro())).click();
        msgEmail = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());

        Assert.assertEquals("Senha é um campo obrigatório",msgEmail);
    }
    public void inserirCamposVazio() {
        String msgNome;
        String msgEmail;
        String msgSenha;

        getDriver().findElement(By.xpath(retornarCliqueNovoUsuario())).click();
        getDriver().findElement(By.xpath(retornarCliqueBotaoCadastro())).click();
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

        getDriver().findElement(By.xpath(retornarCliqueNovoUsuario())).click();
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorNome())).sendKeys(cadastroLogin.getNome());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorEmail())).sendKeys(cadastroLogin.getEmail());
        getDriver().findElement(By.id(cadastroLogin.getIdentificadorSenha())).sendKeys(cadastroLogin.getSenha());
        getDriver().findElement(By.xpath(retornarCliqueBotaoCadastro())).click();
        msgEmailUtilizado = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());

        Assert.assertEquals("Endereço de email já utilizado",msgEmailUtilizado);
    }
    /* ______ TELA CADASTRO LOGIN ______ */

    /* ______ ELEMENTOS DE BOTÃO ______ */
    private String retornarCliqueNovoUsuario() {
        return "//div[@id='bs-example-navbar-collapse-1']//ul//li//a[normalize-space()='Novo usuário?']";
    }
    private String retornarCliqueBotaoCadastro() { return "//div//form//input[@value='Cadastrar']"; }
    private String retornarNomeBotaoCadastrar() {
        return "//div//form//input[@value='Cadastrar']";
    }
    /* ______ ELEMENTOS DE BOTÃO ______ */

    /* ______ ELEMENTOS DE MENSAGEM ______ */
    private String retornarMensagemGenerica() {
        return "//div[@role='alert']";
    }
    /* ______ ELEMENTOS DE MENSAGEM ______ */
}
