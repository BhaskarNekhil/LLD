package Model;
import enums.ObstacleType;
public class Ladder extends Obstacle {
    public Ladder(int start, int end) {
        super(start, end);
    }
    @Override
    public ObstacleType getType() {
        return ObstacleType.LADDER;
    }
}