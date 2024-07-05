package pageobjects.resumomensal;

import core.base.BasePage;
import objeto.login.Login;
import objeto.resumomensal.ResumoMensal;

public class PageResumoMensal extends BasePage {
    public void setURLResumoMensal(Login login) { dslResumoMensal.validarTelaResumoMensal(login); }
    public void setVerificarExisteSituacaoPendenteResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarExisteSituacaoPendenteResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarExisteSituacaoPagoResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarExisteSituacaoPagoResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarQuantidadeSituacaoPendenteResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarQuantidadeSituacaoPendenteResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarQuantidadeSituacaoPagoResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarQuantidadeSituacaoPagoResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarMaiorValorResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarMaiorValorResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarMenorValorResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarMenorValorResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarExisteValorZeroResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarExisteValorZeroResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarExisteContaPadraoResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarExisteContaPadraoResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarExisteContaDiferentePadraoResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarExisteContaDiferentePadraoResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarMenorValorDataPagamentoResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarMenorValorDataPagamentoResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarMaiorValorDataPagamentoResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarMaiorValorDataPagamentoResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarContaResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarContaResumoMensalPorDataAtual(resumoMensal); }
    public void setVerificarSaldoResumoMensalPorDataAtual(ResumoMensal resumoMensal) { dslResumoMensal.verificarSaldoResumoMensalPorDataAtual(resumoMensal); }
    public void setRemoverMovimentacoesContaResumoMensalPorDataAtual(ResumoMensal resumoMensal) throws InterruptedException { dslResumoMensal.removerMovimentacoesContaResumoMensalPorDataAtual(resumoMensal); }
    public void setRemoverContaAposRemocaoMovimentacoesResumoMensalPorDataAtual() throws InterruptedException { dslResumoMensal.removerContaAposRemocaoMovimentacoesResumoMensalPorDataAtual(); }
    public void setRealizarLogout() { dslResumoMensal.realizarLogout(); }
}
