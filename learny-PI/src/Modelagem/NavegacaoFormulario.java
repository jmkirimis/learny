/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import javax.swing.JFrame;

public class NavegacaoFormulario extends JFrame {
    private JFrame telaDeOrigem;

    public NavegacaoFormulario(JFrame telaDeOrigem) {
        this.telaDeOrigem = telaDeOrigem;
        initComponentsComuns();
    }

    private void initComponentsComuns() {
        // Inicialize seus componentes comuns aqui
    }

    // Método para retornar à tela de origem
    public void voltarParaOrigem() {
        if (telaDeOrigem != null) {
            telaDeOrigem.setVisible(true);
            this.dispose();
        } else {
            // Lógica caso não haja uma tela de origem definida
            System.out.println("Nenhuma tela de origem definida.");
        }
    }
}
