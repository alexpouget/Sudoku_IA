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
            this.possible.add(i);
        }
    }

    public Case(int position,int value, int line, int column, int square) {
        this.value = value;
        this.position = position;
        this.line = line;
        this.column = column;
        this.square = square;
        for(int i = 1;i<10;i++){
            this.possible.add(i);
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

    public boolean eval() {
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
            return true;
            //value has attributed
        }
        return false;
    }

    public boolean reeval(){
        //by square
        int result = 0;
        if((result = bySquare())!=0){
            this.setValue(result);
            this.possible = new ArrayList<>();
            this.possible.add(0,this.getValue());
            return true;
        }
        //byLine
        else if((result = byLine())!=0){
            this.setValue(result);
            this.possible = new ArrayList<>();
            this.possible.add(0,this.getValue());
            return true;
        }
        //byColumn
        else if((result = byColumn())!=0){
            this.setValue(result);
            this.possible = new ArrayList<>();
            this.possible.add(0,this.getValue());
            return true;
        }
        return false;
    }

    public int bySquare(){
        for (int p:possible) {
            boolean contain = false;
            for (Case c: relations) {
                if(c.getPosition()!= this.getPosition() && c.getValue()==0 && c.getSquare()==this.getSquare()){
                    if(c.possible.contains(p)){
                        contain = true;
                        break;
                    }
                }
            }
            if(!contain){
                return p;
            }
        }
        return 0;
    }

    public int byLine(){
        for (int p:possible) {
            boolean contain = false;
            for (Case c: relations) {
                if(c.getPosition()!= this.getPosition() && c.getValue()==0 && c.getLine()==this.getLine()){
                    if(c.possible.contains(p)){
                        contain = true;
                        break;
                    }
                }
            }
            if(!contain){
                return p;
            }
        }
        return 0;
    }

    public int byColumn(){
        for (int p:possible) {
            boolean contain = false;
            for (Case c: relations) {
                if(c.getPosition()!= this.getPosition() && c.getValue()==0 && c.getColumn()==this.getColumn()){
                    if(c.possible.contains(p)){
                        contain = true;
                        break;
                    }
                }
            }
            if(!contain){
                return p;
            }
        }
        return 0;
    }
}
