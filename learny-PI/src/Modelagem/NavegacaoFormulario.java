/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Visualizacao.FOpcoes;
import Visualizacao.FPerfil;
import javax.swing.JFrame;

public class NavegacaoFormulario extends JFrame {

    public enum TelaOrigem {
        PERFIL,
        OPCOES
    }

    private JFrame telaDeOrigem;
    private TelaOrigem telaOrigemEnum;

    public NavegacaoFormulario(JFrame telaDeOrigem, TelaOrigem telaOrigemEnum) {
        this.telaDeOrigem = telaDeOrigem;
        this.telaOrigemEnum = telaOrigemEnum;
        initComponentsComuns();
    }

    private void initComponentsComuns() {
        // Inicialize componentes comuns a todos os formulários que estendem essa classe
    }

    // Método para retornar à tela de origem
    public void voltarParaOrigem() {
        if (telaDeOrigem != null) {
            telaDeOrigem.setVisible(true);
            this.dispose();
        } else {
            System.out.println("Nenhuma tela de origem definida.");
        }
    }
}
