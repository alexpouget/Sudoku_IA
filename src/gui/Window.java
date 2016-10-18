package gui;

import gui.jpanel.Sudoku;
import utils.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 17/10/2016.
 */
public class Window extends JFrame {

    JPanel sudoku;

    public Window(){
        setTitle("sudoku");
        setResizable(false);
        setSize(Constant.WIDTH,Constant.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();

        //JPanel Sudoku
        sudoku = new Sudoku();
        container.add(sudoku);



        setVisible(true);
    }

    public void repaintPanel() {
        sudoku.repaint();
    }
}
