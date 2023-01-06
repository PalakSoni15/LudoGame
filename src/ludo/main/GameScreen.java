package ludo.main;

import javax.swing.*;

public class GameScreen extends JFrame {
    static JFrame jframe;
    GameScreen(){
        jframe = new JFrame();
        jframe.setBounds(0,0,650,680);
        jframe.setTitle("LUDO");
        jframe.setResizable(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameMoves gm = new GameMoves();
        gm.setFocusable(true);
        gm.addKeyListener(gm);
        gm.addMouseListener(gm);
        jframe.add(gm);
        jframe.setVisible(true);
    }
    public static void main(String[] args) {
        GameScreen game = new GameScreen();

    }

}
