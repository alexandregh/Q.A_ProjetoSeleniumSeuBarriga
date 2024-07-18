package core.dsl.dslmovimentacao;

import core.base.BaseTest;
import objeto.login.Login;
import objeto.movimentacao.Movimentacao;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static core.assistant.Assistant.*;
import static core.drivefactory.DriveFactory.getDriver;

public class DSLMovimentacao extends BaseTest {
    /* ______ ELEMENTOS DE TEXTO ______ */
    public void validarTodosCamposVazios() {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
            getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();
            getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
            verificarAssertivasTodosCamposVazios();
        } else {
            getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();
            getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
            verificarAssertivasTodosCamposVaziosContaExcecao();
        }
    }
    public void validarCampoDataMovimentacaoCaracteresAlfabeticos(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("Data da Movimentação");
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("20/06/2024");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("10.0");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data da Movimentação inválida (DD/MM/YYYY)']")).getText());

        Assert.assertEquals("Data da Movimentação inválida (DD/MM/YYYY)",msgDataMovimentacao);
    }
    public void validarCampoDataMovimentacaoCaracteresAlfanumericos(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("2ab6202c");
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("20/06/2024");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("10.0");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data da Movimentação inválida (DD/MM/YYYY)']")).getText());

        Assert.assertEquals("Data da Movimentação inválida (DD/MM/YYYY)",msgDataMovimentacao);
    }
    public void validarCampoDataMovimentacaoCaracteresNumericosSemFormatacao(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("20062024");
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("20/06/2024");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("10.0");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data da Movimentação inválida (DD/MM/YYYY)']")).getText());

        Assert.assertEquals("Data da Movimentação inválida (DD/MM/YYYY)",msgDataMovimentacao);
    }
    public void validarCampoDataMovimentacaoMenorIgualDataAtual(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;
        String dataAtual = retornarDataAtual();
        String dataMovimentacaoMaiorDataAtual = retornarDataMovimentacaoMaiorDataAtual();

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao(dataMovimentacaoMaiorDataAtual);
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("20/06/2024");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("10.0");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[contains(text(),'Data da Movimentação deve ser menor ou igual à data atual')]")).getText());

        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual",msgDataMovimentacao);
    }
    public void validarCampoDataPagamentoCaracteresAlfabeticos(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("20/06/2024");
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("Data do Pagamento");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("10.0");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data do pagamento inválida (DD/MM/YYYY)']")).getText());

        Assert.assertEquals("Data do pagamento inválida (DD/MM/YYYY)",msgDataMovimentacao);
    }
    public void validarCampoDataPagamentoCaracteresAlfanumericos(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("20/06/2024");
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("2a0b20c4");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("10.0");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data do pagamento inválida (DD/MM/YYYY)']")).getText());

        Assert.assertEquals("Data do pagamento inválida (DD/MM/YYYY)",msgDataMovimentacao);
    }
    public void validarCampoDataPagamentoCaracteresNumericosSemFormatacao(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("20/06/2024");
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("20062024");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("10.0");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data do pagamento inválida (DD/MM/YYYY)']")).getText());

        Assert.assertEquals("Data do pagamento inválida (DD/MM/YYYY)",msgDataMovimentacao);
    }
    public void validarCampoValorComoNumeroInvalido(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgDataMovimentacao;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("20/06/2024");
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("20/06/2024");
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Interessado");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("Valor");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement select = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelect = new Select(select);
        comboSelect.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelect.getFirstSelectedOption().getText());

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgDataMovimentacao = retornarMensagemTela(getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Valor deve ser um número']")).getText());

        Assert.assertEquals("Valor deve ser um número",msgDataMovimentacao);
    }
    public void criarMovimentacaoReceitaPendenteDataAtual(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgCadastroSucesso;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setSetIdentificadorTipoMovimentacao("tipo");
        WebElement selectTipoMovimentacao = getDriver().findElement(By.id(movimentacao.getSetIdentificadorTipoMovimentacao()));
        Select comboSelectTipoMovimentacao = new Select(selectTipoMovimentacao);
        comboSelectTipoMovimentacao.selectByVisibleText(Movimentacao.TipoMovimentacao.RECEITA.getTipoMovimentacao());
        movimentacao.setConta(comboSelectTipoMovimentacao.getFirstSelectedOption().getText());

        String dataAtual = retornarDataAtual();
        String[] diaMesAnoAtual = retornarVetorDiaMesAnoAtual(dataAtual);

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao(diaMesAnoAtual[0] + "/" + diaMesAnoAtual[1] + "/" + diaMesAnoAtual[2]);
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento(diaMesAnoAtual[0] + "/" + diaMesAnoAtual[1] + "/" + diaMesAnoAtual[2]);
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição Movimentação Receita Pendente");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Ana Maria");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("3.80");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement selectConta = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelectConta = new Select(selectConta);
        comboSelectConta.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelectConta.getFirstSelectedOption().getText());

        getDriver().findElement(By.cssSelector("#status_pendente")).click();

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgCadastroSucesso = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Movimentação adicionada com sucesso!",msgCadastroSucesso);
    }
    public void criarMovimentacaoReceitaPagaDataAtual(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgCadastroSucesso;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setSetIdentificadorTipoMovimentacao("tipo");
        WebElement selectTipoMovimentacao = getDriver().findElement(By.id(movimentacao.getSetIdentificadorTipoMovimentacao()));
        Select comboSelectTipoMovimentacao = new Select(selectTipoMovimentacao);
        comboSelectTipoMovimentacao.selectByVisibleText(Movimentacao.TipoMovimentacao.RECEITA.getTipoMovimentacao());
        movimentacao.setConta(comboSelectTipoMovimentacao.getFirstSelectedOption().getText());

        String dataAtual = retornarDataAtual();
        String mesAnoAtual = retornarMesAnoAtual(dataAtual);
        String mesAtual = mesAnoAtual.substring(0,2);
        String anoAtual = mesAnoAtual.substring(3,7);

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao("09/" + mesAtual + "/" + anoAtual);
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento("15/" + mesAtual + "/" + anoAtual);
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição Movimentação Receita Paga");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Júlio César");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("7.20");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement selectConta = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelectConta = new Select(selectConta);
        comboSelectConta.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelectConta.getFirstSelectedOption().getText());

        getDriver().findElement(By.cssSelector("#status_pago")).click();

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgCadastroSucesso = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert' and .='Movimentação adicionada com sucesso!']")).getText());

        Assert.assertEquals("Movimentação adicionada com sucesso!",msgCadastroSucesso);
    }
    public void criarMovimentacaoDespesaPendenteDataAtual(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgCadastroSucesso;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setSetIdentificadorTipoMovimentacao("tipo");
        WebElement selectTipoMovimentacao = getDriver().findElement(By.id(movimentacao.getSetIdentificadorTipoMovimentacao()));
        Select comboSelectTipoMovimentacao = new Select(selectTipoMovimentacao);
        comboSelectTipoMovimentacao.selectByVisibleText(Movimentacao.TipoMovimentacao.DESPESA.getTipoMovimentacao());
        movimentacao.setConta(comboSelectTipoMovimentacao.getFirstSelectedOption().getText());

        String dataAtual = retornarDataAtual();
        String[] diaMesAnoAtual = retornarVetorDiaMesAnoAtual(dataAtual);

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao(diaMesAnoAtual[0] + "/" + diaMesAnoAtual[1] + "/" + diaMesAnoAtual[2]);
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento(diaMesAnoAtual[0] + "/" + diaMesAnoAtual[1] + "/" + diaMesAnoAtual[2]);
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição Movimentação Despesa Pendente");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Ana Maria");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("3.80");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement selectConta = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelectConta = new Select(selectConta);
        comboSelectConta.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelectConta.getFirstSelectedOption().getText());

        getDriver().findElement(By.cssSelector("#status_pendente")).click();

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgCadastroSucesso = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Movimentação adicionada com sucesso!",msgCadastroSucesso);
    }
    public void criarMovimentacaoDespesaPagaDataAtual(Movimentacao movimentacao) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();
        }
        String msgCadastroSucesso;

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

        movimentacao.setSetIdentificadorTipoMovimentacao("tipo");
        WebElement selectTipoMovimentacao = getDriver().findElement(By.id(movimentacao.getSetIdentificadorTipoMovimentacao()));
        Select comboSelectTipoMovimentacao = new Select(selectTipoMovimentacao);
        comboSelectTipoMovimentacao.selectByVisibleText(Movimentacao.TipoMovimentacao.DESPESA.getTipoMovimentacao());
        movimentacao.setConta(comboSelectTipoMovimentacao.getFirstSelectedOption().getText());

        String dataAtual = retornarDataAtual();
        String[] diaMesAnoAtual = retornarVetorDiaMesAnoAtual(dataAtual);

        movimentacao.setIdentificadorDataMovimentacao("data_transacao");
        movimentacao.setDataMovimentacao(diaMesAnoAtual[0] + "/" + diaMesAnoAtual[1] + "/" + diaMesAnoAtual[2]);
        getDriver().findElement(By.id("data_transacao")).sendKeys(movimentacao.getDataMovimentacao());

        movimentacao.setIdentificadorDataPagamento("data_pagamento");
        movimentacao.setDataPagamento(diaMesAnoAtual[0] + "/" + diaMesAnoAtual[1] + "/" + diaMesAnoAtual[2]);
        getDriver().findElement(By.id("data_pagamento")).sendKeys(movimentacao.getDataPagamento());

        movimentacao.setIdentificadorDescricao("descricao");
        movimentacao.setDescricao("Descrição Movimentação Despesa Paga");
        getDriver().findElement(By.id("descricao")).sendKeys(movimentacao.getDescricao());

        movimentacao.setIdentificadorInteressado("interessado");
        movimentacao.setInteressado("Bianca Sales");
        getDriver().findElement(By.id("interessado")).sendKeys(movimentacao.getInteressado());

        movimentacao.setIdentificadorValor("valor");
        movimentacao.setValor("100");
        getDriver().findElement(By.id("valor")).sendKeys(movimentacao.getValor());

        movimentacao.setIdentificadorConta("conta");
        WebElement selectConta = getDriver().findElement(By.id(movimentacao.getIdentificadorConta()));
        Select comboSelectConta = new Select(selectConta);
        comboSelectConta.selectByVisibleText("Conta1_Usuário1");
        movimentacao.setConta(comboSelectConta.getFirstSelectedOption().getText());

        getDriver().findElement(By.cssSelector("#status_pago")).click();

        getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).click();
        msgCadastroSucesso = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());

        Assert.assertEquals("Movimentação adicionada com sucesso!",msgCadastroSucesso);
    }
    /* ______ ELEMENTOS DE TEXTO ______ */

    /* ______ ELEMENTOS DE TELA ______ */
    public void validarTelaMovimentacao(Login login) {
        executarPreCondicoes(login);

        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();
        String tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText();
        if (tabelaVazia.equals("")) {
            executarInserirConta();

            getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Criar Movimentação']")).click();

            String url = getDriver().getCurrentUrl();
            Assert.assertEquals("https://seubarriga.wcaquino.me/movimentacao",url);

            String nomeBotao;
            nomeBotao = getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Salvar']")).getText();
            Assert.assertEquals("Salvar",nomeBotao);
        }
    }
    /* ______ ELEMENTOS DE TELA ______ */

    /* ______ PROCEDIMENTO REUTILIZADO NESTA PAGE ______ */
    private void verificarAssertivasTodosCamposVazios() {
        Assert.assertEquals("Data da Movimentação é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data da Movimentação é obrigatório']")).getText());
        Assert.assertEquals("Data do pagamento é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data do pagamento é obrigatório']")).getText());
        Assert.assertEquals("Descrição é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Descrição é obrigatório']")).getText());
        Assert.assertEquals("Interessado é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Interessado é obrigatório']")).getText());
        Assert.assertEquals("Valor é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Valor é obrigatório']")).getText());
        Assert.assertEquals("Valor deve ser um número",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Valor deve ser um número']")).getText());
        Assert.assertEquals("Conta é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Conta é obrigatório']")).getText());
    }
    private void verificarAssertivasTodosCamposVaziosContaExcecao() {
        Assert.assertEquals("Data da Movimentação é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data da Movimentação é obrigatório']")).getText());
        Assert.assertEquals("Data do pagamento é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Data do pagamento é obrigatório']")).getText());
        Assert.assertEquals("Descrição é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Descrição é obrigatório']")).getText());
        Assert.assertEquals("Interessado é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Interessado é obrigatório']")).getText());
        Assert.assertEquals("Valor é obrigatório",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Valor é obrigatório']")).getText());
        Assert.assertEquals("Valor deve ser um número",getDriver().findElement(By.xpath("//div//ul//li[normalize-space()='Valor deve ser um número']")).getText());
    }
    private String retornarDataMovimentacaoMaiorDataAtual() {
        String dataAtual = retornarDataAtual();
        int dia; int mes; int ano;

        dia = Integer.parseInt(dataAtual.substring(0,2));
        mes = Integer.parseInt(dataAtual.substring(3,5));
        ano = Integer.parseInt(dataAtual.substring(6,10));

        if (dia <= 30) {
            dia += 1;
        } else if (mes <= 12) {
            mes += 1;
        }

        // Dia
        String diaString = String.valueOf(dia);
        int qtdCaracterDia = diaString.length();
        if (qtdCaracterDia == 1) {
            diaString = "0" + dia;
        }

        // Mês
        String mesString = String.valueOf(mes);
        int qtdCaracterMes = mesString.length();
        if (qtdCaracterMes == 1) {
            mesString = "0" + mes;
        }

        return diaString + "/" + mesString + "/" + ano;
    }
    /* ______ PROCEDIMENTO REUTILIZADO NESTA PAGE ______ */
}
