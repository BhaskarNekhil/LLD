package Model;
public class Dice {
    private final int noOfDice;
    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }
    public int rollDice(){
        int total =0;
        for(int i=0;i<noOfDice;i++){
            total += (int)(Math.random()*6)+1;
        }
        return total;
    }
    
}
