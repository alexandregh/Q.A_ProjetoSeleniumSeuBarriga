package core.dsl.dslconta;

import core.base.BaseTest;
import objeto.conta.Conta;
import objeto.login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;

import static core.drivefactory.DriveFactory.getDriver;

public class DSLConta extends BaseTest {
    /* ______ TELA CONTA ______ */
    public void inserirConta(Login login,Conta conta) {
        executarPreCondicoes(login);

        conta.setIdentificadorNome("nome");
        conta.setNome("Conta1_Usuário1");

        getDriver().findElement(By.xpath(retornarCliqueMenuContas())).click();
        getDriver().findElement(By.xpath(retornarCliqueMenuListar())).click();

        String tabelaVazia = retornarNomeObjeto(getDriver().findElement(By.xpath(retornarCorpoTabelaContas())).getText());
        if (tabelaVazia.equals("")) {
            getDriver().findElement(By.xpath(retornarCliqueMenuContas())).click();
            getDriver().findElement(By.xpath(retornarCliqueMenuAdicionar())).click();

            String url = getDriver().getCurrentUrl();
            Assert.assertEquals("https://seubarriga.wcaquino.me/addConta",url);

            String txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).getText());
            Assert.assertEquals("Salvar",txtBtnSalvar);

            getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
            getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).click();

            String msgConta;
            msgConta = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());

            Assert.assertEquals("Conta adicionada com sucesso!",msgConta);

            String txtConta;
            txtConta = retornarNomeObjeto(getDriver().findElement(By.xpath(retornarCorpoTabelaContas() + "//td[normalize-space()='" + conta.getNome() + "']")).getText());

            Assert.assertEquals("Conta1_Usuário1",txtConta);
        }
        if (!tabelaVazia.equals("")) {
            getDriver().findElement(By.xpath(retornarCorpoTabelaContas() + "//tr//a[2]")).click();
            String msgContaRemovida = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());

            Assert.assertEquals("Conta removida com sucesso!",msgContaRemovida);

            getDriver().findElement(By.xpath(retornarCliqueMenuContas())).click();
            getDriver().findElement(By.xpath(retornarCliqueMenuAdicionar())).click();

            String url = getDriver().getCurrentUrl();
            Assert.assertEquals("https://seubarriga.wcaquino.me/addConta",url);

            String txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).getText());
            Assert.assertEquals("Salvar",txtBtnSalvar);

            getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
            getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).click();

            String msgConta;
            msgConta = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());
            Assert.assertEquals("Conta adicionada com sucesso!",msgConta);
        }
        getDriver().findElement(By.xpath(retornarCliqueBotaoSair())).click();
    }
    public void inserirContaCadastrada(Login login,Conta conta) {
        executarPreCondicoes(login);

        conta.setIdentificadorNome("nome");
        conta.setNome("Conta1_Usuário1");

        getDriver().findElement(By.xpath(retornarCliqueMenuContas())).click();
        getDriver().findElement(By.xpath(retornarCliqueMenuAdicionar())).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/addConta",url);

        String txtBtnSalvar;
        txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).getText());
        Assert.assertEquals("Salvar",txtBtnSalvar);

        getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
        getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).click();

        String msgContaCadastrada;
        msgContaCadastrada = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());
        Assert.assertEquals("Já existe uma conta com esse nome!", msgContaCadastrada);

        getDriver().findElement(By.xpath(retornarCliqueBotaoSair())).click();
    }
    public void alterarConta(Login login,Conta conta) {
        executarPreCondicoes(login);

        getDriver().findElement(By.xpath(retornarCliqueMenuContas())).click();
        getDriver().findElement(By.xpath(retornarCliqueMenuListar())).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/contas",url);

        conta.setNome(retornarMensagemTela(getDriver().findElement(By.xpath(retornarCorpoTabelaContas() + "//td[normalize-space()='Conta1_Usuário1']")).getText()));
        Assert.assertEquals("Conta1_Usuário1",conta.getNome());

        getDriver().findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();

        String txtBtnSalvar;
        txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).getText());
        Assert.assertEquals("Salvar",txtBtnSalvar);

        conta.setIdentificadorNome("nome");
        conta.setNome("Conta1_Usuário10");

        getDriver().findElement(By.id("nome")).clear();
        getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
        getDriver().findElement(By.xpath(retornarCliqueBotaoSalvar())).click();

        String msgContaAlterada;
        msgContaAlterada = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());
        Assert.assertEquals("Conta alterada com sucesso!", msgContaAlterada);

        conta.setNome(retornarMensagemTela(getDriver().findElement(By.xpath(retornarCorpoTabelaContas() + "//td[normalize-space()='" + conta.getNome() + "']")).getText()));

        Assert.assertEquals("Conta1_Usuário10",conta.getNome());
        getDriver().findElement(By.xpath(retornarCliqueBotaoSair())).click();
    }
    public void removerConta(Login login,Conta conta) {
        executarPreCondicoes(login);

        getDriver().findElement(By.xpath(retornarCliqueMenuContas())).click();
        getDriver().findElement(By.xpath(retornarCliqueMenuListar())).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/contas",url);

        String tabelaVazia = retornarNomeObjeto(getDriver().findElement(By.xpath(retornarCorpoTabelaContas())).getText());
        if (tabelaVazia.equals("")) {
            getDriver().findElement(By.xpath(retornarCliqueBotaoSair())).click();
        }
        if (!tabelaVazia.equals("")) {
            conta.setNome(retornarNomeObjeto(getDriver().findElement(By.xpath(retornarCorpoTabelaContas() + "//td[1]")).getText()));
            Assert.assertEquals("Conta1_Usuário10",conta.getNome());

            getDriver().findElement(By.xpath(retornarCorpoTabelaContas() + "//tr//a[2]")).click();
            String msgContaRemovida = retornarMensagemTela(getDriver().findElement(By.xpath(retornarMensagemGenerica())).getText());
            Assert.assertEquals("Conta removida com sucesso!",msgContaRemovida);

            conta.setNome(retornarNomeObjeto(getDriver().findElement(By.xpath(retornarCorpoTabelaContas())).getText()));
            Assert.assertEquals("",conta.getNome());
        }
    }
    /* ______ TELA CONTA ______ */

    /* ______ ELEMENTOS DE MENU ______ */
    private String retornarCliqueMenuContas() {
        return "//div[@id='navbar']//a[normalize-space()='Contas']";
    }
    private String retornarCliqueMenuListar() {
        return "//div[@id='navbar']//a[normalize-space()='Listar']";
    }
    private String retornarCliqueMenuAdicionar() { return "//div[@id='navbar']//a[normalize-space()='Adicionar']"; }
    /* ______ ELEMENTOS DE MENU ______ */

    /* ______ ELEMENTOS DE BOTÃO ______ */
    private String retornarCliqueBotaoSalvar() { return "//button[normalize-space()='Salvar']"; }
    private String retornarCliqueBotaoSair() { return  "//div[@id='navbar']//a[normalize-space()='Sair']"; }
    /* ______ ELEMENTOS DE BOTÃO ______ */

    /* ______ ELEMENTOS DE TABELA ______ */
    private String retornarCorpoTabelaContas() {
        return "//table[@id='tabelaContas']//tbody";
    }
    /* ______ ELEMENTOS DE TABELA ______ */

    /* ______ ELEMENTOS DE MENSAGEM ______ */
    private String retornarMensagemGenerica() {
        return "//div[@role='alert']";
    }
    /* ______ ELEMENTOS DE MENSAGEM ______ */
}
