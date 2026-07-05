package service;
import Model.Obstacle;

import java.util.List;
import Model.Player;
import Model.Dice;
public class Game {
   public final Obstacle cells[];
    public final Player players[];
    public final int totalCells;
    public final List<Obstacle> obstacles;
    public final int noOfDice;
    public final Dice dice;
   public Game(String players[],int totalCells,List<Obstacle> obstacles,int noOfDice){
        this.players = new Player[players.length];
        for (int i = 0; i < players.length; i++) {
            this.players[i] = new Player(players[i]);
        }
        this.totalCells = totalCells;
        this.noOfDice = noOfDice;
        this.obstacles = obstacles;
        this.dice = new Dice(noOfDice);
        this.cells = new Obstacle[totalCells + 1];
        for (Obstacle obstacle : obstacles) {
            cells[obstacle.start] = obstacle;
        }  
    }
    public void startGame(){
        boolean isGameOver = false;
        long i = 0;
        
        while (!isGameOver) {
            Player currentPlayer = players[(int)i];
            int x = dice.rollDice();
            int currentPosition = currentPlayer.getPosition();

            int newPosition = currentPlayer.getPosition() + x;
            if(newPosition > totalCells){
                newPosition = currentPosition;
            }
            currentPlayer.setPosition(newPosition);
            String currentPlayerName = currentPlayer.getName();
            System.out.println(currentPlayerName + " rolled a " + x + " and moved from " + currentPosition + " to " + newPosition);
            if(newPosition == totalCells){
                System.out.println(currentPlayerName + " has won the game!");
                isGameOver = true;
                break;
            }
            i++;
            i%=players.length;
          }
    }
}
