package pageobjects.movimentacao;

import core.base.BasePage;
import objeto.login.Login;
import objeto.movimentacao.Movimentacao;

public class PageMovimentacao extends BasePage {
    public void setURLMovimentacao(Login login) {
        dslMovimentacao.validarTelaMovimentacao(login);
    }
    public void setValidarTodosCamposVazios() { dslMovimentacao.validarTodosCamposVazios(); }
    public void setValidarCampoDataMovimentacaoCaracteresAlfabeticos(Movimentacao movimentacao) { dslMovimentacao.validarCampoDataMovimentacaoCaracteresAlfabeticos(movimentacao); }
    public void setValidarCampoDataMovimentacaoCaracteresAlfanumericos(Movimentacao movimentacao) { dslMovimentacao.validarCampoDataMovimentacaoCaracteresAlfanumericos(movimentacao); }
    public void setValidarCampoDataMovimentacaoCaracteresNumericosSemFormatacao(Movimentacao movimentacao) { dslMovimentacao.validarCampoDataMovimentacaoCaracteresNumericosSemFormatacao(movimentacao); }
    public void setValidarCampoDataMovimentacaoMenorIgualDataAtual(Movimentacao movimentacao) { dslMovimentacao.validarCampoDataMovimentacaoMenorIgualDataAtual(movimentacao); }
    public void setValidarCampoDataPagamentoCaracteresAlfabeticos(Movimentacao movimentacao) { dslMovimentacao.validarCampoDataPagamentoCaracteresAlfabeticos(movimentacao); }
    public void setValidarCampoDataPagamentoCaracteresAlfanumericos(Movimentacao movimentacao) { dslMovimentacao.validarCampoDataPagamentoCaracteresAlfanumericos(movimentacao); }
    public void setValidarCampoDataPagamentoCaracteresNumericosSemFormatacao(Movimentacao movimentacao) { dslMovimentacao.validarCampoDataPagamentoCaracteresNumericosSemFormatacao(movimentacao); }
    public void setValidarCampoValorComoNumeroInvalido(Movimentacao movimentacao) { dslMovimentacao.validarCampoValorComoNumeroInvalido(movimentacao); }
    public void setCriarMovimentacaoReceitaPendenteDataAtual(Movimentacao movimentacao) { dslMovimentacao.criarMovimentacaoReceitaPendenteDataAtual(movimentacao); }
    public void setCriarMovimentacaoReceitaPagaDataAtual(Movimentacao movimentacao) { dslMovimentacao.criarMovimentacaoReceitaPagaDataAtual(movimentacao); }
    public void setCriarMovimentacaoDespesaPendenteDataAtual(Movimentacao movimentacao) { dslMovimentacao.criarMovimentacaoDespesaPendenteDataAtual(movimentacao); }
    public void setCriarMovimentacaoDespesaPagaDataAtual(Movimentacao movimentacao) { dslMovimentacao.criarMovimentacaoDespesaPagaDataAtual(movimentacao); }
}
