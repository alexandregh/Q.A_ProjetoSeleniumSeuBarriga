package tests.movimentacao;

import core.base.BaseTest;
import objeto.login.Login;
import objeto.movimentacao.Movimentacao;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobjects.movimentacao.PageMovimentacao;

import static core.drivefactory.DriveFactory.getDriver;
import static core.drivefactory.DriveFactory.killDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMovimentacao extends BaseTest {
    private PageMovimentacao pageMovimentacao;
    private Login login;
    private Movimentacao movimentacao;
    private BaseTest baseTest;
    private String nomeClasse;
    @Before
    public void inicializar() {
        pageMovimentacao = new PageMovimentacao();
        login = new Login();
        movimentacao = new Movimentacao();
        baseTest = new BaseTest();
        nomeClasse = this.getClass().getSimpleName();
        baseTest.definirNomeClasse(nomeClasse);
        getDriver().get("https://seubarriga.wcaquino.me/");
    }
    @Test
    public void teste01_validarURLMovimentacao() { pageMovimentacao.setURLMovimentacao(login); }
    @Test
    public void teste02_validarTodosCamposVazios() { pageMovimentacao.setValidarTodosCamposVazios(); }
    @Test
    public void teste03_validarCampoDataMovimentacaoCaracteresAlfabeticos() { pageMovimentacao.setValidarCampoDataMovimentacaoCaracteresAlfabeticos(movimentacao); }
    @Test
    public void teste04_validarCampoDataMovimentacaoCaracteresAlfanumericos() { pageMovimentacao.setValidarCampoDataMovimentacaoCaracteresAlfanumericos(movimentacao); }
    @Test
    public void teste05_validarCampoDataMovimentacaoCaracteresNumericosSemFormatacao() { pageMovimentacao.setValidarCampoDataMovimentacaoCaracteresNumericosSemFormatacao(movimentacao); }
    @Test
    public void teste06_validarCampoDataMovimentacaoMenorIgualDataAtual() { pageMovimentacao.setValidarCampoDataMovimentacaoMenorIgualDataAtual(movimentacao); }
    @Test
    public void teste07_validarCampoDataPagamentoCaracteresAlfabeticos() { pageMovimentacao.setValidarCampoDataPagamentoCaracteresAlfabeticos(movimentacao); }
    @Test
    public void teste08_validarCampoDataPagamentoCaracteresAlfanumericos() { pageMovimentacao.setValidarCampoDataPagamentoCaracteresAlfanumericos(movimentacao); }
    @Test
    public void teste09_validarCampoDataPagamentoCaracteresNumericosSemFormatacao() { pageMovimentacao.setValidarCampoDataPagamentoCaracteresNumericosSemFormatacao(movimentacao); }
    @Test
    public void teste10_validarCampoValorComoNumeroInvalido() { pageMovimentacao.setValidarCampoValorComoNumeroInvalido(movimentacao); }
    @Test
    public void teste11_criarMovimentacaoReceitaPendenteDataAtual() { pageMovimentacao.setCriarMovimentacaoReceitaPendenteDataAtual(movimentacao); }
    @Test
    public void teste12_criarMovimentacaoReceitaPagaDataAtual() { pageMovimentacao.setCriarMovimentacaoReceitaPagaDataAtual(movimentacao); }
    @Test
    public void teste13_criarMovimentacaoDespesaPendenteDataAtual() { pageMovimentacao.setCriarMovimentacaoDespesaPendenteDataAtual(movimentacao); }
    @Test
    public void teste14_criarMovimentacaoDespesaPagaDataAtual() { pageMovimentacao.setCriarMovimentacaoDespesaPagaDataAtual(movimentacao); }
    @AfterClass
    public static void encerrarBrowser() {
        killDriver();
    }
}
