
package Modelagem;

import Controle.Conexao;
import Visualizacao.AlertaGeral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class VerificadorDiarias {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private Aluno alunoLogado;
    private JFrame parentFrame;

    public VerificadorDiarias(JFrame parentFrame) {
        alunoLogado = Session.getInstance().getAlunoLogado();
        conexao = Conexao.conecta();
        this.parentFrame = parentFrame;
    }

    public void verificarDiarias() {
        String sqlFasesConcluidas = "select tipo from fasesConcluidas "
                + "join fases using(idFase) where dataConclusao = CURDATE() and idAluno = ?";
        try (PreparedStatement pstFasesConcluidas = conexao.prepareStatement(sqlFasesConcluidas)) {
            pstFasesConcluidas.setInt(1, alunoLogado.getIdAluno());
            try (ResultSet rsFasesConcluidas = pstFasesConcluidas.executeQuery()) {
                while (rsFasesConcluidas.next()) {
                    String tipoFase = rsFasesConcluidas.getString("tipo");
                    verificarMissao(tipoFase);
                }
                // Verificar missões baseadas na quantidade de fases concluídas
                verificarMissaoPorQuantidade();
                
                // Verificar se todas as quatro fases foram concluídas
                verificarQuatroFasesConcluidas();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void verificarMissao(String tipoFase) {
        String sqlMissoes = "select * from missoesDiarias join missoes using(idMissao) "
                + "where idAluno = ? and dataInsercao = CURDATE()";
        try (PreparedStatement pstMissoes = conexao.prepareStatement(sqlMissoes)) {
            pstMissoes.setInt(1, alunoLogado.getIdAluno());
            try (ResultSet rsMissoes = pstMissoes.executeQuery()) {
                while (rsMissoes.next()) {
                    int idMissaoDiaria = rsMissoes.getInt("idMissaoDiaria");
                    String descMissao = rsMissoes.getString("descMissao");

                    if (tipoFase.equals("Visual") && descMissao.equals("Conclua a fase visual")) {
                        contabilizarPontos();
                        deletar(idMissaoDiaria);
                    } else if (tipoFase.equals("Observacao") && descMissao.equals("Conclua a fase observacao")) {
                        contabilizarPontos();
                        deletar(idMissaoDiaria);
                    } else if (tipoFase.equals("Ouvir") && descMissao.equals("Conclua a fase de escuta")) {
                        contabilizarPontos();
                        deletar(idMissaoDiaria);
                    } else if (tipoFase.equals("Numeros") && descMissao.equals("Conclua a fase de numeros")) {
                        contabilizarPontos();
                        deletar(idMissaoDiaria);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void verificarMissaoPorQuantidade() {
        int fasesConcluidasHoje = contarFasesConcluidasHoje();
        String sqlMissoes = "select * from missoesDiarias join missoes using(idMissao) "
                + "where idAluno = ? and dataInsercao = CURDATE()";
        try (PreparedStatement pstMissoes = conexao.prepareStatement(sqlMissoes)) {
            pstMissoes.setInt(1, alunoLogado.getIdAluno());
            try (ResultSet rsMissoes = pstMissoes.executeQuery()) {
                while (rsMissoes.next()) {
                    int idMissaoDiaria = rsMissoes.getInt("idMissaoDiaria");
                    String descMissao = rsMissoes.getString("descMissao");

                    if (descMissao.equals("Conclua 3 fases") && fasesConcluidasHoje >= 3) {
                        contabilizarPontos();
                        deletar(idMissaoDiaria);
                    } else if (descMissao.equals("Conclua 5 fases") && fasesConcluidasHoje >= 5) {
                        contabilizarPontos();
                        deletar(idMissaoDiaria);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void verificarQuatroFasesConcluidas() {
        String sql = "SELECT COUNT(DISTINCT tipo) AS totalFases FROM fasesConcluidas "
                   + "JOIN fases USING(idFase) WHERE dataConclusao = CURDATE() AND idAluno = ? "
                   + "AND tipo IN ('Visual', 'Observacao', 'Ouvir', 'Numeros')";
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, alunoLogado.getIdAluno());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int totalFasesConcluidas = rs.getInt("totalFases");
                    if (totalFasesConcluidas >= 4) {
                        String sqlMissoes = "SELECT idMissaoDiaria FROM missoesDiarias "
                                           + "JOIN missoes USING(idMissao) WHERE idAluno = ? "
                                           + "AND dataInsercao = CURDATE() AND descMissao = 'Conclua um mundo'";
                        try (PreparedStatement pstMissoes = conexao.prepareStatement(sqlMissoes)) {
                            pstMissoes.setInt(1, alunoLogado.getIdAluno());
                            try (ResultSet rsMissoes = pstMissoes.executeQuery()) {
                                while (rsMissoes.next()) {
                                    int idMissaoDiaria = rsMissoes.getInt("idMissaoDiaria");
                                    contabilizarPontos();
                                    deletar(idMissaoDiaria);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private int contarFasesConcluidasHoje() {
        String sql = "select count(*) as total from fasesConcluidas where dataConclusao = CURDATE() and idAluno = ?";
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, alunoLogado.getIdAluno());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }

    private void deletar(int idMissaoDiaria) {
        String sql = "delete from missoesDiarias where idMissaoDiaria = ?";
        try (PreparedStatement pstDeletar = conexao.prepareStatement(sql)) {
            pstDeletar.setInt(1, idMissaoDiaria);
            pstDeletar.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void contabilizarPontos() {
        String sql = "select count(*) from missoesDiarias where idAluno = ? and dataInsercao = CURDATE()";
        try (PreparedStatement pstContabilizar = conexao.prepareStatement(sql)) {
            pstContabilizar.setInt(1, alunoLogado.getIdAluno());
            try (ResultSet rsContabilizar = pstContabilizar.executeQuery()) {
                if (rsContabilizar.next()) {
                    int numDiarias = rsContabilizar.getInt(1);

                    int pontos = 0;
                    String mensagem = "";

                    if (numDiarias == 1) {
                        pontos = 200;
                        mensagem = "Você concluiu sua última missão! +200pts";
                    } else if (numDiarias == 2) {
                        pontos = 150;
                        mensagem = "Você concluiu sua segunda missão! +150pts";
                    } else if (numDiarias == 3) {
                        pontos = 100;
                        mensagem = "Você concluiu sua primeira missão! +100pts";
                    }

                    if (pontos > 0) {
                        inserirPontos(pontos);
                        ImageIcon icon = new ImageIcon("src/Imagens/icon-diarias-alerta.png");
                        AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Missões Diárias", mensagem, 50, 50);
                        alert.setVisible(true);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void inserirPontos(int pontos) {
        String sql = "update alunos set pontosTotais = pontosTotais + ? where idAluno = ?";
        try (PreparedStatement pstInserirPontos = conexao.prepareStatement(sql)) {
            pstInserirPontos.setInt(1, pontos);
            pstInserirPontos.setInt(2, alunoLogado.getIdAluno());
            alunoLogado.setPontosTotais(alunoLogado.getPontosTotais() + pontos);
            pstInserirPontos.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
