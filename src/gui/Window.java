package gui;

import gui.jpanel.Sudoku;
import ia.Agent;
import utils.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 17/10/2016.
 */
public class Window extends JFrame {

    JPanel sudoku;
    Agent agent = Agent.getAgent();

    public Window(){
        setTitle("sudoku");
        setResizable(false);
        setSize(Constant.WIDTH,Constant.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();

        //JPanel Sudoku
        sudoku = new Sudoku();
        container.add(sudoku);

        //left Panel
        JPanel panel = new JPanel();

        container.add(panel,BorderLayout.WEST);
        JButton resolve = new JButton("resolve");
        resolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("resolve");
                agent.resolve();
                System.out.println("resolved");
                repaintPanel();
            }
        });
        panel.add(resolve);



        setVisible(true);
    }

    public void repaintPanel() {
        sudoku.repaint();
    }
}
