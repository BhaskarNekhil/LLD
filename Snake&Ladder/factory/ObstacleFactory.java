package factory;
import Model.Ladder;
import Model.Obstacle; 

import Model.Snake;
public class ObstacleFactory {
    public static Obstacle createObstacle(String type, int start, int end) {
        switch (type) {
            case "ladder":
                return new Ladder(start, end);
            case "snake":
                return new Snake(start, end);
            default:
                throw new IllegalArgumentException("Invalid obstacle type: " + type);
        }
    }
}
