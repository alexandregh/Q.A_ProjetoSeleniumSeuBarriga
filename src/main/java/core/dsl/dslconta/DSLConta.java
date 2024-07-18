package core.dsl.dslconta;

import core.base.BaseTest;
import objeto.conta.Conta;
import objeto.login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;

import static core.drivefactory.DriveFactory.getDriver;

public class DSLConta extends BaseTest {
    /* ______ ELEMENTOS DE TEXTO ______ */
    public void inserirConta(Login login,Conta conta) {
        executarPreCondicoes(login);

        conta.setIdentificadorNome("nome");
        conta.setNome("Conta1_Usuário1");

        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();

        String tabelaVazia = retornarNomeObjeto(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText());
        if (tabelaVazia.equals("")) {
            getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
            getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Adicionar']")).click();

            String url = getDriver().getCurrentUrl();
            Assert.assertEquals("https://seubarriga.wcaquino.me/addConta",url);

            String txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).getText());
            Assert.assertEquals("Salvar",txtBtnSalvar);

            getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
            getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).click();

            String msgConta;
            msgConta = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

            Assert.assertEquals("Conta adicionada com sucesso!",msgConta);

            String txtConta;
            txtConta = retornarNomeObjeto(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody//td[normalize-space()='" + conta.getNome() + "']")).getText());

            Assert.assertEquals("Conta1_Usuário1",txtConta);
        }
        if (!tabelaVazia.equals("")) {
            getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody//tr//a[2]")).click();
            String msgContaRemovida = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

            Assert.assertEquals("Conta removida com sucesso!",msgContaRemovida);

            getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
            getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Adicionar']")).click();

            String url = getDriver().getCurrentUrl();
            Assert.assertEquals("https://seubarriga.wcaquino.me/addConta",url);

            String txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).getText());
            Assert.assertEquals("Salvar",txtBtnSalvar);

            getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
            getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).click();

            String msgConta;
            msgConta = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());
            Assert.assertEquals("Conta adicionada com sucesso!",msgConta);
        }
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Sair']")).click();
    }
    public void inserirContaCadastrada(Login login,Conta conta) {
        executarPreCondicoes(login);

        conta.setIdentificadorNome("nome");
        conta.setNome("Conta1_Usuário1");

        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Adicionar']")).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/addConta",url);

        String txtBtnSalvar;
        txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).getText());
        Assert.assertEquals("Salvar",txtBtnSalvar);

        getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
        getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).click();

        String msgContaCadastrada;
        msgContaCadastrada = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());
        Assert.assertEquals("Já existe uma conta com esse nome!", msgContaCadastrada);

        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Sair']")).click();
    }
    public void alterarConta(Login login,Conta conta) {
        executarPreCondicoes(login);

        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/contas",url);

        conta.setNome(retornarMensagemTela(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody//td[normalize-space()='Conta1_Usuário1']")).getText()));
        Assert.assertEquals("Conta1_Usuário1",conta.getNome());

        getDriver().findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();

        String txtBtnSalvar;
        txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).getText());
        Assert.assertEquals("Salvar",txtBtnSalvar);

        conta.setIdentificadorNome("nome");
        conta.setNome("Conta1_Usuário10");

        getDriver().findElement(By.id("nome")).clear();
        getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
        getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).click();

        String msgContaAlterada;
        msgContaAlterada = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());
        Assert.assertEquals("Conta alterada com sucesso!", msgContaAlterada);

        conta.setNome(retornarMensagemTela(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody//td[normalize-space()='" + conta.getNome() + "']")).getText()));

        Assert.assertEquals("Conta1_Usuário10",conta.getNome());
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Sair']")).click();
    }
    public void removerConta(Login login,Conta conta) {
        executarPreCondicoes(login);

        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/contas",url);

        String tabelaVazia = retornarNomeObjeto(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText());
        if (tabelaVazia.equals("")) {
            getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Sair']")).click();
        }
        if (!tabelaVazia.equals("")) {
            conta.setNome(retornarNomeObjeto(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody//td[1]")).getText()));
            Assert.assertEquals("Conta1_Usuário10",conta.getNome());

            getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody//tr//a[2]")).click();
            String msgContaRemovida = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());
            Assert.assertEquals("Conta removida com sucesso!",msgContaRemovida);

            conta.setNome(retornarNomeObjeto(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText()));
            Assert.assertEquals("",conta.getNome());
        }
    }
    /* ______ ELEMENTOS DE TEXTO ______ */
}
