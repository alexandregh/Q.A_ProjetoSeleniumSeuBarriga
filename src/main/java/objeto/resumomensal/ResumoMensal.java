package objeto.resumomensal;

public class ResumoMensal {
    private String identificadorMes;
    private String mes;
    private String identificadorAno;
    private String ano;

    public ResumoMensal() {}

    public String getIdentificadorMes() {
        return identificadorMes;
    }

    public void setIdentificadorMes(String identificadorMes) {
        this.identificadorMes = identificadorMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getIdentificadorAno() {
        return identificadorAno;
    }

    public void setIdentificadorAno(String identificadorAno) {
        this.identificadorAno = identificadorAno;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
