package tests.resumomensal;

import core.base.BaseTest;
import objeto.login.Login;
import objeto.resumomensal.ResumoMensal;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobjects.resumomensal.PageResumoMensal;

import static core.drivefactory.DriveFactory.getDriver;
import static core.drivefactory.DriveFactory.killDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestResumoMensal extends BaseTest {
    private PageResumoMensal pageResumoMensal;
    private Login login;
    private ResumoMensal resumoMensal;

    @Before
    public void inicializar() {
        pageResumoMensal = new PageResumoMensal();
        login = new Login();
        resumoMensal = new ResumoMensal();
        BaseTest baseTest = new BaseTest();
        String nomeClasse = this.getClass().getSimpleName();
        baseTest.definirNomeClasse(nomeClasse);
        getDriver().get("https://seubarriga.wcaquino.me/");
    }
    @Test
    public void teste01_validarURLResumoMensal() { pageResumoMensal.setURLResumoMensal(login); }
    @Test
    public void teste02_verificarExisteSituacaoPendenteResumoMensalPorDataAtual() { pageResumoMensal.setVerificarExisteSituacaoPendenteResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste03_verificarExisteSituacaoPagoResumoMensalPorDataAtual() { pageResumoMensal.setVerificarExisteSituacaoPagoResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste04_verificarQuantidadeSituacaoPendenteResumoMensalPorDataAtual() { pageResumoMensal.setVerificarQuantidadeSituacaoPendenteResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste05_verificarQuantidadeSituacaoPagoResumoMensalPorDataAtual() { pageResumoMensal.setVerificarQuantidadeSituacaoPagoResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste06_verificarMaiorValorResumoMensalPorDataAtual() { pageResumoMensal.setVerificarMaiorValorResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste07_verificarMenorValorResumoMensalPorDataAtual() { pageResumoMensal.setVerificarMenorValorResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste08_verificarExisteValorZeroResumoMensalPorDataAtual() { pageResumoMensal.setVerificarExisteValorZeroResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste09_verificarExisteContaPadraoResumoMensalPorDataAtual() { pageResumoMensal.setVerificarExisteContaPadraoResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste10_verificarExisteContaDiferentePadraoResumoMensalPorDataAtual() { pageResumoMensal.setVerificarExisteContaDiferentePadraoResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste11_verificarMenorValorDataPagamentoResumoMensalPorDataAtual() { pageResumoMensal.setVerificarMenorValorDataPagamentoResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste12_verificarMaiorValorDataPagamentoResumoMensalPorDataAtual() { pageResumoMensal.setVerificarMaiorValorDataPagamentoResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste13_verificarContaResumoMensalPorDataAtual() { pageResumoMensal.setVerificarContaResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste14_verificarSaldoResumoMensalPorDataAtual() { pageResumoMensal.setVerificarSaldoResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste15_removerMovimentacoesContaResumoMensalPorDataAtual() throws InterruptedException { pageResumoMensal.setRemoverMovimentacoesContaResumoMensalPorDataAtual(resumoMensal); }
    @Test
    public void teste16_removerContaAposRemocaoMovimentacoesResumoMensalPorDataAtual() throws InterruptedException { pageResumoMensal.setRemoverContaAposRemocaoMovimentacoesResumoMensalPorDataAtual(); }
    @Test
    public void teste17_realizarLogout() { pageResumoMensal.setRealizarLogout(); }
    @AfterClass
    public static void encerrarBrowser() {
        killDriver();
    }
}
