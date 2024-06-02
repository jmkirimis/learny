
package Modelagem;

public class Session {
    private static Session instance;
    private Aluno alunoLogado;

    private Session() {
        // Construtor privado para evitar instanciamento
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Aluno getAlunoLogado() {
        return alunoLogado;
    }

    public void setAlunoLogado(Aluno aluno) {
        this.alunoLogado = aluno;
    }
}
