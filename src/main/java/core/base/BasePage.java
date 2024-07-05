package core.base;

import core.dsl.dslcadastrologin.DSLCadastroLogin;
import core.dsl.dslconta.DSLConta;
import core.dsl.dsllogin.DSLLogin;
import core.dsl.dslmovimentacao.DSLMovimentacao;
import core.dsl.dslresumomensal.DSLResumoMensal;

public class BasePage {
    protected DSLLogin dslLogin;
    protected DSLCadastroLogin dslCadastroLogin;
    protected DSLConta dslConta;
    protected DSLMovimentacao dslMovimentacao;
    protected DSLResumoMensal dslResumoMensal;
    public BasePage() {
        dslLogin = new DSLLogin();
        dslCadastroLogin = new DSLCadastroLogin();
        dslConta = new DSLConta();
        dslMovimentacao = new DSLMovimentacao();
        dslResumoMensal = new DSLResumoMensal();
    }
}
