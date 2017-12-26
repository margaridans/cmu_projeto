package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class Pergunta {
    public static String NAME_TABLE = "tblPergunta";
    private int id_pergunta;
    private String pergunta_name;
    private int id_categoria;
    private int id_dificuldade;
    private String resposta1;
    private String resposta2;
    private String resposta3;
    private String resposta4;
    private String resposta_certa;

    public Pergunta(String pergunta_name, int id_categoria, int id_dificuldade, String resposta1, String resposta2, String resposta3, String resposta4, String resposta_certa) {
        this.pergunta_name = pergunta_name;
        this.id_categoria = id_categoria;
        this.id_dificuldade = id_dificuldade;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.resposta_certa = resposta_certa;
    }

    public Pergunta(int id_pergunta, String pergunta_name, int id_categoria, int id_dificuldade, String resposta1, String resposta2, String resposta3, String resposta4, String resposta_certa) {
        this.id_pergunta = id_pergunta;
        this.pergunta_name = pergunta_name;
        this.id_categoria = id_categoria;
        this.id_dificuldade = id_dificuldade;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.resposta_certa = resposta_certa;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public String getPergunta_name() {
        return pergunta_name;
    }

    public void setPergunta_name(String pergunta_name) {
        this.pergunta_name = pergunta_name;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_dificuldade() {
        return id_dificuldade;
    }

    public void setId_dificuldade(int id_dificuldade) {
        this.id_dificuldade = id_dificuldade;
    }

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3;
    }

    public String getResposta4() {
        return resposta4;
    }

    public void setResposta4(String resposta4) {
        this.resposta4 = resposta4;
    }

    public String getResposta_certa() {
        return resposta_certa;
    }

    public void setResposta_certa(String resposta_certa) {
        this.resposta_certa = resposta_certa;
    }
}
