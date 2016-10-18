package gui.jpanel;

import ia.Agent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 17/10/2016.
 */
public class Sudoku extends JPanel {
    private Agent agent;

    public Sudoku() {
        agent = Agent.getAgent();
        setBackground(Color.WHITE);
        setLayout(new GridLayout(9,9));
        ArrayList<JLabel> fieldArrayList = new ArrayList<>();

        for(int i=0;i<81;i++){
            JLabel label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            fieldArrayList.add(label);
            label.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            label.setText(String.valueOf(agent.getList().get(i).getValue()));

            this.add(label);
        }
    }


}
