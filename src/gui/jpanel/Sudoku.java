package gui.jpanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 17/10/2016.
 */
public class Sudoku extends JPanel {

    public Sudoku() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(3,3));
        ArrayList<JTextField> fieldArrayList = new ArrayList<>();
        for(int i=0;i<9;i++){
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3,3));
            for(int y=0;y<9;y++){
                JTextField field = new JTextField();
                fieldArrayList.add(field);
                panel.add(field);

            }
            panel.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(panel);
        }



    }
}
