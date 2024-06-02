
package Modelagem;

import Controle.Conexao;
import Visualizacao.PanelRoundBorda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ranking {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    ArrayList<Double> pontosAlunos = new ArrayList<Double>();
    private Aluno alunoLogado;
    
    public Ranking(){
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
    }
    
    public void carregarPontos() {
        String sql = "SELECT nome, pontosTotais FROM alunos";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                double pontosTotais = rs.getDouble("pontosTotais");
                pontosAlunos.add(pontosTotais);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void merge(ArrayList<Double> v, int inicio, int meio, int fim) {
        ArrayList<Double> aux = new ArrayList<>(v.subList(inicio, fim + 1));

        int i = 0;
        int j = meio - inicio + 1;
        int k = inicio;

        while (i <= meio - inicio && j <= fim - inicio) {
            if (aux.get(i) >= aux.get(j)) {
                v.set(k, aux.get(i));
                i++;
            } else {
                v.set(k, aux.get(j));
                j++;
            }
            k++;
        }

        while (i <= meio - inicio) {
            v.set(k, aux.get(i));
            i++;
            k++;
        }

        while (j <= fim - inicio) {
            v.set(k, aux.get(j));
            j++;
            k++;
        }
    }

    private void mergesort(ArrayList<Double> v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergesort(v, inicio, meio);
            mergesort(v, meio + 1, fim);
            merge(v, inicio, meio, fim);
        }
    }

    public void ordenarPontos() {
        if (!pontosAlunos.isEmpty()) {
            mergesort(pontosAlunos, 0, pontosAlunos.size() - 1);
        }
    }
    
    public void exibirPontosOrdenados(JLabel[] lblsNomes, JLabel[] lblsPontos, JLabel[] lblsPts, PanelRoundBorda[] panelsFotos) {
        int i  = 0;
        Set<Integer> exibidos = new HashSet<>(); // Conjunto para armazenar IDs dos alunos já exibidos
        
        for (double ponto : pontosAlunos) {
            if (i >= lblsNomes.length) {
                break; // Interrompe o loop após preencher todas as labels disponíveis
            }
            String sql = "SELECT idAluno, nome, pontosTotais, foto FROM alunos where pontosTotais = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setDouble(1,  ponto);
                rs = pst.executeQuery();

                while (rs.next()) {
                    int idAluno = rs.getInt("idAluno");
                    if (exibidos.contains(idAluno)) {
                        continue; // Pula se o aluno já foi exibido
                    }
                    String nomeAluno = rs.getString("nome");
                    String fotoAluno = rs.getString("foto");
                    lblsNomes[i].setText(nomeAluno);
                    lblsPontos[i].setText(String.valueOf(ponto));
                    if (i < panelsFotos.length) {
                        panelsFotos[i].setImg(new ImageIcon("src/Imagens/" + fotoAluno));
                    }
                    exibidos.add(idAluno); // Marca o aluno como exibido
                    i++;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        // Preencher labels restantes com valores vazios
        for (; i < lblsNomes.length; i++) {
            lblsNomes[i].setText("");
            lblsPontos[i].setText("");
            lblsPts[i].setText("");
            if (i < panelsFotos.length) {
                panelsFotos[i].setImg(null); // Definir a imagem para null ou um ícone vazio
            }
        }
    }
    
    public void atualizarRanking() {
        int i = 0;
        for (double ponto : pontosAlunos) {
            String sql = "SELECT idAluno FROM alunos WHERE pontosTotais = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setDouble(1, ponto);
                rs = pst.executeQuery();

                while (rs.next()) {
                    int idAluno = rs.getInt("idAluno");
                    String alteraRank = "UPDATE alunos SET ranque = ? WHERE idAluno = ?";
                    try {
                        pst = conexao.prepareStatement(alteraRank);
                        pst.setInt(1, i + 1);
                        pst.setInt(2, idAluno);
                        if (idAluno == alunoLogado.getIdAluno()) {
                            alunoLogado.setRanque(String.valueOf(i + 1));
                        }
                        pst.executeUpdate();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            i++;
        }
    }
}
