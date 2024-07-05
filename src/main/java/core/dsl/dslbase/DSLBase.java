package core.dsl.dslbase;

public class DSLBase {
    /* ______ ELEMENTOS DE BOTÕES ______ */
    public static String retornarNomeBotao(String txtNomeBotao) {
        String textoBotao = txtNomeBotao;
        textoBotao.trim();
        return textoBotao;
    }
    /* ______ ELEMENTOS DE BOTÕES ______ */

    /* ______ MENSAGENS ______ */
    public static String retornarMensagemTela(String msg) {
        String mensagem = msg;
        mensagem.trim();
        return mensagem;
    }
    /* ______ MENSAGENS ______ */

    /* ______ INSTANCIAS DE OBJETOS ______ */
    public static String retornarNomeObjeto(String nomeOBJ) {
        String nomeObjeto = nomeOBJ;
        nomeOBJ.trim();
        return  nomeObjeto;
    }
    /* ______ INSTANCIAS DE OBJETOS ______ */

    /* ______ VALORES DE ELEMENTOS ______ */
    public static String retornarValorElemento(String valorElemento) {
        String elemento = valorElemento;
        elemento.trim();
        return  elemento;
    }
    /* ______ VALORES DE ELEMENTOS ______ */
}
