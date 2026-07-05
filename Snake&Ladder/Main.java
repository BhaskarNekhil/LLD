import java.util.*;
import service.Game;
import Model.Obstacle;
import factory.ObstacleFactory;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        System.out.println("Enter the names of the players (space-separated): ");
        String[] playerNames = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            playerNames[i] = scanner.next();
        }
        System.out.println("Enter the total number of cells: ");
        int totalCells = scanner.nextInt();
        System.out.println("Enter the number of dice: ");
        int noOfDice = scanner.nextInt();
        System.out.println("Enter the number of obstacles: ");
        int numObstacles = scanner.nextInt();
        List<Obstacle> obstacles = new ArrayList<>();
        for (int i = 0; i < numObstacles; i++) {
            System.out.println("Enter the type of obstacle " + (i + 1) + " (Ladder/Snake): ");
            String type = scanner.next();
            System.out.println("Enter the star(source)t position of obstacle " + (i + 1) + ": ");
            int start = scanner.nextInt();
            System.out.println("Enter the end(destination) position of obstacle " + (i + 1) + ": ");
            int end = scanner.nextInt();
            obstacles.add(ObstacleFactory.createObstacle(type, start, end));
        }
        Game game = new Game(playerNames, totalCells, obstacles, noOfDice);
        game.startGame();
        scanner.close();
    }
}