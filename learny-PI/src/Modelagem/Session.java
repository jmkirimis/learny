/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

/**
 *
 * @author João
 */
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
