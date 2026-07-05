package Model;
import enums.ObstacleType;
public class Snake extends Obstacle {   
    public Snake(int start, int end) {
        super(start, end);
    }
    @Override
    public ObstacleType getType() {
        return ObstacleType.SNAKE;
    }
}

