package suitetests;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.cadastrologin.TestCadastroLogin;
import tests.conta.TestConta;
import tests.login.TestLogin;
import tests.movimentacao.TestMovimentacao;
import tests.resumomensal.TestResumoMensal;

import static core.drivefactory.DriveFactory.killDriver;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestLogin.class,
    TestCadastroLogin.class,
    TestConta.class,
    TestMovimentacao.class,
    TestResumoMensal.class
})
public class SuiteTests {
    @AfterClass
    public static void finalizarSuiteTests() {
        killDriver();
    }
}
