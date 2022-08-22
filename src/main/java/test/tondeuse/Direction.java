package test.tondeuse;

import java.util.Arrays;
import java.util.function.Function;

public enum Direction {
    EAST("E", (coordinates) -> new Coordinates(coordinates.getX() + 1, coordinates.getY()))
    , WEST("W", (coordinates) -> new Coordinates(coordinates.getX() - 1, coordinates.getY()))
    , NORTH("N", (coordinates) -> new Coordinates(coordinates.getX(), coordinates.getY() + 1))
    , SOUTH("S", (coordinates) -> new Coordinates(coordinates.getX(), coordinates.getY() - 1));

    private final String direction;
    private final Function<Coordinates, Coordinates> move;

    Direction(String direction, Function<Coordinates, Coordinates> move) {
        this.direction = direction;
        this.move = move;
    }

    public String getDirection() {
        return direction;
    }

    public static Direction of(String dir) throws Exception {
        // use non generic exception and decide if using runtime exception is better
        return Arrays.stream(values()).filter(d -> d.direction.equals(dir)).findAny().orElseThrow(() -> new Exception("No Direction matches"));
    }

    public Function<Coordinates, Coordinates> getMove() {
        return move;
    }

    @Override
    public String toString() {
        return direction;
    }
}
