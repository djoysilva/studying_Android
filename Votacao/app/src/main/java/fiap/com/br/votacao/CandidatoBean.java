package fiap.com.br.votacao;

/**
 * Created by logonrm on 06/04/2017.
 */

public class CandidatoBean {
    private String nome;
    private String partido;

    public CandidatoBean() {
    }

    public CandidatoBean(String nome, String partido) {
        this.nome = nome;
        this.partido = partido;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome + " - " + partido;
    }
}
