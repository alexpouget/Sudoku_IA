import gui.Window;
import ia.Agent;

public class Main {

    public static void main(String[] args) {
        Agent agent = Agent.getAgent();
        agent.readSudoku("./ressource/sudoku.txt");
        Window window = new Window();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after sleep");
        agent.resolve();
        agent.resolve();
        agent.resolve();
        agent.resolve();
        
    }
}
