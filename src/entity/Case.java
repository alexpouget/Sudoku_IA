package entity;

import java.util.List;

/**
 * Created by alex on 17/10/2016.
 */
public class Case {

    private List<Case> relations; //liste des case relié
    private int value;
    private int position;
    private int line;
    private int column;
    private int square;

    public Case() {
    }

    public Case(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public Case(int value, int position, int line, int column, int square) {
        this.value = value;
        this.position = position;
        this.line = line;
        this.column = column;
        this.square = square;
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
}
