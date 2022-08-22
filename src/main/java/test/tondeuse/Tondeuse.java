package test.tondeuse;

import java.util.Objects;

public class Tondeuse {
    private Coordinates coordinates;
    private Direction direction;

    public Tondeuse(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return coordinates + " " + direction ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tondeuse tondeuse = (Tondeuse) o;
        return Objects.equals(coordinates, tondeuse.coordinates) && direction == tondeuse.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction);
    }
}
