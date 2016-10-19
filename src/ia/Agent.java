package ia;

import entity.Case;

import java.io.*;
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

    public void readSudoku(String s) {
        try {
            FileReader file = new FileReader(new File(s));
            BufferedReader buf = new BufferedReader(file);
            String line = buf.readLine();
            int i = 0;
            for (Case c: list) {
                if(i==9){
                    line=buf.readLine();
                    i=0;
                }
                if(String.valueOf(line.charAt(i)).equals("*")){
                    c.setValue(0);
                    i++;
                    continue;
                }
                c.setValue(Integer.valueOf(String.valueOf(line.charAt(i))));
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resolve() {
        //res by value
        int resolved = -1;
        while(0 != resolved) {
            resolved = 0;
            for (Case c : list) {
                if (c.getValue() != 0) {
                    continue;
                }
                if (c.eval()) {
                    resolved++;
                }
                ;
            }
        }
        //check if all have value
        resolved = 0;
        for (Case c : list) {
            if (c.getValue() == 0) {
                resolved++;
                break;
            }
        }
        //resolve by possibility

    }
}
