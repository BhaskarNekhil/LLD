package Model;
import enums.ObstacleType;
public abstract class Obstacle {
   public int start;
    public int end;
    public Obstacle(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public int movePlayer(){
        return end;
    }
    public abstract ObstacleType getType();

}
