import gui.Window;
import ia.Agent;

public class Main {

    public static void main(String[] args) {
        Agent agent = Agent.getAgent();
        agent.readSudoku("./ressource/sudoku_difficile.txt");
        Window window = new Window();
    }
}
