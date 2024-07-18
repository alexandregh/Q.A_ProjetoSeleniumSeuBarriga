package core.assistant;

import core.dsl.dslbase.DSLBase;
import objeto.conta.Conta;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static core.drivefactory.DriveFactory.getDriver;

public class Assistant extends DSLBase {
    public static void executarInserirConta() {
        Conta conta = new Conta();
        conta.setIdentificadorNome("nome");
        conta.setNome("Conta1_Usuário1");

        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();

        String tabelaVazia = retornarNomeObjeto(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText());
        if (!tabelaVazia.equals("")) {
            getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody//span[@class='glyphicon glyphicon-remove-circle']")).click();
            String msgContaRemovida = getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
            Assert.assertEquals("Conta removida com sucesso!",msgContaRemovida);
        }
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Adicionar']")).click();

        String txtBtnSalvar = retornarNomeBotao(getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).getText());
        Assert.assertEquals("Salvar",txtBtnSalvar);

        getDriver().findElement(By.id(conta.getIdentificadorNome())).sendKeys(conta.getNome());
        getDriver().findElement(By.xpath("//button[normalize-space()='Salvar']")).click();

        String msgConta;
        msgConta = retornarMensagemTela(getDriver().findElement(By.xpath("//div[@role='alert']")).getText());
        Assert.assertEquals("Conta adicionada com sucesso!",msgConta);
    }
    public static String retornarDataAtual() {
        Date dataAtual = new Date();
        return new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
    }
    public static String retornarMesAnoAtual(String dataAtual) {
        int mes; int ano;

        mes = Integer.parseInt(dataAtual.substring(3,5));
        ano = Integer.parseInt(dataAtual.substring(6,10));

        // Mês
        String mesString = String.valueOf(mes);
        int qtdCaracterMes = mesString.length();
        if (qtdCaracterMes == 1) {
            mesString = "0" + mes;
        }

        return mesString + "/" + ano;
    }
    public static String[] retornarVetorDiaMesAnoAtual(String dataAtual) {
        int dia; int mes; int ano;

        dia = Integer.parseInt(dataAtual.substring(0,2));
        mes = Integer.parseInt(dataAtual.substring(3,5));
        ano = Integer.parseInt(dataAtual.substring(6,10));

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

        String dataMesAno = diaString + "/" + mesString + "/" + ano;
        return dataMesAno.split("/");
    }
}
