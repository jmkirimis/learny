
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
