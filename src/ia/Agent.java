package ia;

import entity.Case;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 17/10/2016.
 */
public class Agent {

    private static Agent agent;
    private List<Case> list = new ArrayList<>();

    private Agent(){
        initSudoku();

    }

    public void initSudoku() {
        int column = 0;
        int line = 0;
        int square = 0;
        for(int i = 0;i<81;i++){
            list.add(new Case(i,0,line,column,square));
            column++;
            if(9 == column){
                column =0;
                line++;
            }
            if(line>5){
                square = (column / 3) + 6;
            }else if(line>2){
                square = (column / 3) + 3;
            }else{
                square = column / 3;
            }

        }
        for (Case c: list) {
            for (Case c2 : list
                 ) {
                if(c.getPosition() != c2.getPosition() &&
                        (c2.getColumn() == c.getColumn() ||
                                c2.getLine() == c.getLine() ||
                                c2.getSquare() == c.getSquare())){ //if in the same line, column or square
                    c.addRelations(c2); //add relations
                }
            }
        }

    }

    public static Agent getAgent(){
        if(agent==null){
            agent = new Agent();
        }
        return agent;
    }

    public List<Case> getList() {
        return list;
    }
}