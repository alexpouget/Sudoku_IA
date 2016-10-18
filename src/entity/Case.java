package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 17/10/2016.
 */
public class Case {

    private List<Case> relations = new ArrayList<>(); //liste des case relié
    private int value;
    private int position;
    private int line;
    private int column;
    private int square;
    private List<Integer> possible = new ArrayList<>();

    public Case() {
    }

    public Case(int position, int value) {
        this.position = position;
        this.value = value;
        for(int i = 1;i<10;i++){
            possible.add(i);
        }
    }

    public Case(int position,int value, int line, int column, int square) {
        this.value = value;
        this.position = position;
        this.line = line;
        this.column = column;
        this.square = square;
        for(int i = 1;i<10;i++){
            possible.add(i);
        }
    }

    public List<Case> getRelations() {
        return relations;
    }

    public void setRelations(List<Case> relations) {
        this.relations = relations;
    }

    public void addRelations(Case relation) {
        this.relations.add(relation);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public List<Integer> getPossible() {
        return possible;
    }

    public void setPossible(List<Integer> possible) {
        this.possible = possible;
    }

    public void eval() {
        for (Case c: relations
             ) {
            if(c.getValue()!=0){
                if(this.possible.contains(c.getValue())){
                    this.possible.remove((Integer)c.getValue());
                }
            }
        }
        if(this.possible.size()==1){
            this.setValue(this.possible.get(0));
            System.out.println("change value");
        }
        System.out.println(this.possible.size()+" - "+this.getValue());
    }
}
