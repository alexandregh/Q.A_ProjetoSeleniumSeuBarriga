package objeto.movimentacao;

public class Movimentacao {
    private String identificadorDataMovimentacao;
    private String dataMovimentacao;
    private String identificadorDataPagamento;
    private String dataPagamento;
    private String identificadorDescricao;
    private String descricao;
    private String identificadorInteressado;
    private String interessado;
    private String identificadorValor;
    private String valor;
    private String identificadorConta;
    private String conta;
    private String setIdentificadorTipoMovimentacao;
    private String tipoMovimentacao;
    private String identificadorSituacao;
    private String situacao;

    public enum TipoMovimentacao {
        RECEITA("Receita"),
        DESPESA("Despesa");
        private final String tipoMovimentacao;
        TipoMovimentacao(String tipoMovimentacao) {
            this.tipoMovimentacao = tipoMovimentacao;
        }
        public String getTipoMovimentacao() {
            return tipoMovimentacao;
        }
    }
    public enum Situacao {
        PAGO("Pago"),
        PENDENTE("Pendente");
        private final String situacao;
        Situacao(String situacao) { this.situacao = situacao; }
        public String getSituacao() {
            return situacao;
        }
    }

    public Movimentacao() {}

    public String getIdentificadorDataMovimentacao() {
        return identificadorDataMovimentacao;
    }

    public void setIdentificadorDataMovimentacao(String identificadorDataMovimentacao) {
        this.identificadorDataMovimentacao = identificadorDataMovimentacao;
    }

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getIdentificadorDataPagamento() {
        return identificadorDataPagamento;
    }

    public void setIdentificadorDataPagamento(String identificadorDataPagamento) {
        this.identificadorDataPagamento = identificadorDataPagamento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getIdentificadorDescricao() {
        return identificadorDescricao;
    }

    public void setIdentificadorDescricao(String identificadorDescricao) {
        this.identificadorDescricao = identificadorDescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentificadorInteressado() {
        return identificadorInteressado;
    }

    public void setIdentificadorInteressado(String identificadorInteressado) {
        this.identificadorInteressado = identificadorInteressado;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {
        this.interessado = interessado;
    }

    public String getIdentificadorValor() {
        return identificadorValor;
    }

    public void setIdentificadorValor(String identificadorValor) {
        this.identificadorValor = identificadorValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIdentificadorConta() {
        return identificadorConta;
    }

    public void setIdentificadorConta(String identificadorConta) {
        this.identificadorConta = identificadorConta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSetIdentificadorTipoMovimentacao() {
        return setIdentificadorTipoMovimentacao;
    }

    public void setSetIdentificadorTipoMovimentacao(String setIdentificadorTipoMovimentacao) {
        this.setIdentificadorTipoMovimentacao = setIdentificadorTipoMovimentacao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getIdentificadorSituacao() {
        return identificadorSituacao;
    }

    public void setIdentificadorSituacao(String identificadorSituacao) {
        this.identificadorSituacao = identificadorSituacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
