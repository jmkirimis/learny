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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
public class WindowManager {
    private static final List<JFrame> frames = new ArrayList<>();

    public static void register(JFrame frame) {
        frames.add(frame);
        addWindowListener(frame);
    }

    private static void addWindowListener(JFrame frame) {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                fecharLogin();
            }
        });
    }

    public static void fecharLogin() {
        AlunoLogado alunoLogado = new AlunoLogado();
        alunoLogado.fecharLogin();
    }
}
