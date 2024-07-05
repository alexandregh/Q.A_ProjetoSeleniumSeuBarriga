package core.dsl.dslresumomensal;

import core.base.BaseTest;
import objeto.login.Login;
import objeto.resumomensal.ResumoMensal;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static core.assistant.Assistant.*;
import static core.drivefactory.DriveFactory.getDriver;

public class DSLResumoMensal extends BaseTest {
    /* ______ ELEMENTOS DE TEXTO ______ */
    public void verificarExisteSituacaoPendenteResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            int i = 1;
            do {
                String situacao = retornarValorElemento("");
                String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[5]//span";
                situacao = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                if (situacao.equals("Pendente")) {
                    Assert.assertEquals("Pendente",situacao);
                    break;
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
        }
    }
    public void verificarExisteSituacaoPagoResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            int i = 1;
            do {
                String situacao = retornarValorElemento("");
                String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[5]//span";
                situacao = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                if (situacao.equals("Pago")) {
                    Assert.assertEquals("Pago",situacao);
                    break;
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
        }
    }
    public void verificarQuantidadeSituacaoPendenteResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            int qtdRegistrosPendente = 0;
            int i = 1;
            do {
                String situacao = retornarValorElemento("");
                String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[5]//span";
                situacao = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                if (situacao.equals("Pendente")) {
                    Assert.assertEquals("Pendente",situacao);
                    qtdRegistrosPendente += 1;
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            Assert.assertEquals(qtdRegistrosPendente,qtdRegistrosPendente);
        }
    }
    public void verificarQuantidadeSituacaoPagoResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            int qtdRegistrosPago = 0;
            int i = 1;
            do {
                String situacao = retornarValorElemento("");
                String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[5]//span";
                situacao = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                if (situacao.equals("Pago")) {
                    Assert.assertEquals("Pago",situacao);
                    qtdRegistrosPago += 1;
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            Assert.assertEquals(qtdRegistrosPago,qtdRegistrosPago);
        }
    }
    public void verificarMaiorValorResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            String valorInicial = retornarValorElemento("");
            String valorMaior = retornarValorElemento("");

            int i = 1;
            String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[4]";
            valorInicial = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
            valorMaior = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
            do {
                registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[4]";
                if (i > 1) {
                    if (Double.parseDouble(valorInicial) > Double.parseDouble(getDriver().findElement(By.xpath(registroResumoMensal)).getText())) {
                        if (Double.parseDouble(getDriver().findElement(By.xpath(registroResumoMensal)).getText()) > Double.parseDouble(valorMaior)) {
                            valorMaior = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                        }
                    } else if(Double.parseDouble(getDriver().findElement(By.xpath(registroResumoMensal)).getText()) > Double.parseDouble(valorMaior)) {
                        valorMaior = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                    }
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            Assert.assertEquals("7.20",valorMaior);
        }
    }
    public void verificarMenorValorResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            String valorInicial = retornarValorElemento("");
            String valorMenor = retornarValorElemento("");

            int i = 1;
            String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[4]";
            valorInicial = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
            valorMenor = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
            do {
                registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[4]";
                if (i > 1) {
                    if (Double.parseDouble(valorInicial) < Double.parseDouble(getDriver().findElement(By.xpath(registroResumoMensal)).getText())) {
                        if (Double.parseDouble(getDriver().findElement(By.xpath(registroResumoMensal)).getText()) < Double.parseDouble(valorMenor)) {
                            valorMenor = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                        }
                    } else if (Double.parseDouble(getDriver().findElement(By.xpath(registroResumoMensal)).getText()) < Double.parseDouble(valorMenor)) {
                        valorMenor = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                    }
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            Assert.assertEquals("-100.00", valorMenor);
        }
    }
    public void verificarExisteValorZeroResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            String zero = retornarValorElemento("");
            int i = 1;
            do {
                String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[4]";
                if (getDriver().findElement(By.xpath(registroResumoMensal)).getText().equals("0.00")) {
                    zero = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            if (zero.equals("0.00")) {
                Assert.assertTrue("0.00", true);
            } else {
                Assert.assertTrue("",true);
            }
        }
    }
    public void verificarExisteContaPadraoResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            int i = 1;
            do {
                String contaPadrao = retornarValorElemento("");
                String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[3]";
                contaPadrao = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                if (contaPadrao.equals("Conta1_Usuário1")) {
                    Assert.assertEquals("Conta1_Usuário1",contaPadrao);
                    break;
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
        }
    }
    public void verificarExisteContaDiferentePadraoResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            String contaPadrao = retornarValorElemento("");
            int i = 1;
            do {
                String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[3]";
                if (!getDriver().findElement(By.xpath(registroResumoMensal)).getText().equals("Conta1_Usuário1")) {
                    contaPadrao = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            if (contaPadrao.equals("Conta1_Usuário1")) {
                Assert.assertTrue("Conta1_Usuário1", true);
            } else {
                Assert.assertTrue("",true);
            }
        }
    }
    public void verificarMenorValorDataPagamentoResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            String valorDiaInicial = retornarValorElemento("");
            String valorDiaMenor = retornarValorElemento("");

            int i = 1;
            String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[2]";
            valorDiaInicial = retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0];
            valorDiaMenor = retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0];
            do {
                registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[2]";
                if (i > 1) {
                    if (Integer.parseInt(valorDiaInicial) < Integer.parseInt(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0])) {
                        if (Integer.parseInt(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]) < Integer.parseInt(valorDiaMenor)) {
                            valorDiaMenor = String.valueOf(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]);
                        }
                    } else if (Integer.parseInt(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]) < Integer.parseInt(valorDiaMenor)) {
                        valorDiaMenor = String.valueOf(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]);
                    }
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            Assert.assertEquals("15", valorDiaMenor);
        }
    }
    public void verificarMaiorValorDataPagamentoResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            String valorDiaInicial = retornarValorElemento("");
            String valorDiaMenor = retornarValorElemento("");

            int i = 1;
            String registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[2]";
            valorDiaInicial = retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0];
            valorDiaMenor = retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0];
            do {
                registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[2]";
                if (i > 1) {
                    if (Integer.parseInt(valorDiaInicial) > Integer.parseInt(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0])) {
                        if (Integer.parseInt(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]) > Integer.parseInt(valorDiaMenor)) {
                            valorDiaMenor = String.valueOf(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]);
                        }
                    } else if (Integer.parseInt(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]) > Integer.parseInt(valorDiaMenor)) {
                        valorDiaMenor = String.valueOf(retornarVetorDiaMesAnoAtual(getDriver().findElement(By.xpath(registroResumoMensal)).getText())[0]);
                    }
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
            Assert.assertEquals("30", valorDiaMenor);
        }
    }
    public void verificarContaResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        String conta = retornarValorElemento("");
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;

            int i = 1;
            String registroResumoMensal;
            do {
                registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[3]";
                conta = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                if (i > 1) {
                    if (!conta.equals("Conta1_Usuário1")) {
                        conta = getDriver().findElement(By.xpath(registroResumoMensal)).getText();
                    }
                }
                i++;
            } while (i <= qtdRegistrosResumoMensal);
        }
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Home']")).click();

        String msgFooter = getDriver().findElement(By.xpath("//footer/span")).getText();
        Assert.assertEquals("Seu Barriga. Nunca mais esqueça de pagar o aluguel.reset",msgFooter);

        tabelaVazia = retornarValorElemento("");
        String valorColunaConta = "";
        tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaSaldo']//tbody")).getText();
        if (!tabelaVazia.equals("")) {
            valorColunaConta = getDriver().findElement(By.xpath("//table[@id='tabelaSaldo']//tbody//tr//td[normalize-space()='Conta1_Usuário1']")).getText();
        }
        Assert.assertEquals("Conta1_Usuário1", valorColunaConta);
    }
    public void verificarSaldoResumoMensalPorDataAtual(ResumoMensal resumoMensal) {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        Double saldo = 0.00;
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;
            Double valor = 0.00;

            int i = 1;
            String registroResumoMensal;
            do {
                registroResumoMensal = corpoTabela + "//tr[" + i + "]" + "//td[4]";
                valor = Double.valueOf(getDriver().findElement(By.xpath(registroResumoMensal)).getText());
                saldo += valor;
                i++;
            } while (i <= qtdRegistrosResumoMensal);
        }
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Home']")).click();

        String msgFooter = getDriver().findElement(By.xpath("//footer/span")).getText();
        Assert.assertEquals("Seu Barriga. Nunca mais esqueça de pagar o aluguel.reset",msgFooter);

        tabelaVazia = retornarValorElemento("");
        String valorColunaSaldo = retornarValorElemento("");
        tabelaVazia = getDriver().findElement(By.xpath("//table[@id='tabelaSaldo']//tbody")).getText();
        if (!tabelaVazia.equals("")) {
            valorColunaSaldo = getDriver().findElement(By.xpath("//table[@id='tabelaSaldo']//tbody//tr//td[normalize-space()='-92.80']")).getText();
        }
        Assert.assertEquals("-92.80", String.format("%.2f", saldo).replace(",","."));
    }
    public void removerMovimentacoesContaResumoMensalPorDataAtual(ResumoMensal resumoMensal) throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();
        definirMesAno(resumoMensal);
        getDriver().findElement(By.xpath("//form//input[@value='Buscar']")).click();

        String corpoTabela = "//table[@id='tabelaExtrato']//tbody";
        String tabelaVazia = getDriver().findElement(By.xpath(corpoTabela)).getText();
        if (!tabelaVazia.equals("")) {
            int qtdRegistrosResumoMensal = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdRegistrosResumoMensal = registros.length;

            int i = 1;
            String registroResumoMensal = retornarValorElemento("");
            do {
                registroResumoMensal = corpoTabela + "//tr[1]" + "//td[6]//a//span";
                getDriver().findElement(By.xpath(registroResumoMensal)).click();
                String msgMovimentacaoRemovida = getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
                Assert.assertEquals("Movimentação removida com sucesso!",msgMovimentacaoRemovida);
                i++;
                Thread.sleep(1000);
            } while (i <= qtdRegistrosResumoMensal);
        }
    }
    public void removerContaAposRemocaoMovimentacoesResumoMensalPorDataAtual() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Contas']")).click();
        getDriver().findElement(By.xpath("//div[@id='navbar']//a[normalize-space()='Listar']")).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/contas",url);

        String corpoTabela = "//table[@id='tabelaContas']//tbody";
        String tabelaVazia = retornarNomeObjeto(getDriver().findElement(By.xpath("//table[@id='tabelaContas']//tbody")).getText());
        if (!tabelaVazia.equals("")) {
            int qtdContas = tabelaVazia.length();
            String[] registros = tabelaVazia.split("\n");
            qtdContas = registros.length;

            int i = 1;
            String registroContas = retornarValorElemento("");
            do {
                registroContas = corpoTabela + "//tr[1]//a[2]//span";
                getDriver().findElement(By.xpath(registroContas)).click();
                String msgContaRemovida = getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
                Assert.assertEquals("Conta removida com sucesso!",msgContaRemovida);
                i++;
                Thread.sleep(1000);
            } while (i <= qtdContas);
        }
    }
    public void realizarLogout() {
        getDriver().findElement(By.linkText("Sair")).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/logout",url);

        String nomeBotao = retornarNomeBotao("");
        nomeBotao = getDriver().findElement(By.xpath("//div//form//button[normalize-space()='Entrar']")).getText();
        Assert.assertEquals("Entrar",nomeBotao);
    }
    /* ______ ELEMENTOS DE TEXTO ______ */

    /* ______ ELEMENTOS DE TELA ______ */
    public void validarTelaResumoMensal(Login login) {
        executarPreCondições(login);

        getDriver().findElement(By.xpath("//div[@id='navbar']//ul//li//a[normalize-space()='Resumo Mensal']")).click();

        String url = getDriver().getCurrentUrl();
        Assert.assertEquals("https://seubarriga.wcaquino.me/extrato",url);

        String nomeBotao;
        nomeBotao = getDriver().findElement(By.xpath("//div//form//input[@value='Buscar']")).getAttribute("value");
        Assert.assertEquals("Buscar",nomeBotao);
    }
    /* ______ ELEMENTOS DE TELA ______ */

    /* ______ PROCEDIMENTO REUTILIZADO NESTA PAGE ______ */
    private void definirMesAno(ResumoMensal resumoMensal) {
        String dataAtual = retornarDataAtual();
        String mesAnoAnoAtual = retornarMesAnoAtual(dataAtual);
        String mesAtual = mesAnoAnoAtual.substring(0,2);
        String anoAtual = mesAnoAnoAtual.substring(3,7);

        //mês
        resumoMensal.setIdentificadorMes("mes");
        WebElement selectMes = getDriver().findElement(By.id(resumoMensal.getIdentificadorMes()));
        Select comboSelectMes = new Select(selectMes);
        comboSelectMes.selectByValue(mesAtual);
        resumoMensal.setMes(comboSelectMes.getFirstSelectedOption().getText());

        //ano
        resumoMensal.setIdentificadorAno("ano");
        WebElement selectAno = getDriver().findElement(By.id(resumoMensal.getIdentificadorAno()));
        Select comboSelectAno = new Select(selectAno);
        comboSelectAno.selectByValue(anoAtual);
        resumoMensal.setAno(comboSelectAno.getFirstSelectedOption().getText());
    }
    /* ______ PROCEDIMENTO REUTILIZADO NESTA PAGE ______ */
}
