package test.tondeuse;

public class TondeuseController {
    private final Coordinates maxCoordinates;

    public TondeuseController(Coordinates maxCoordinates) {
        this.maxCoordinates = maxCoordinates;
    }

    public void handleInstructions(Tondeuse tondeuse, String commands) throws Exception {
        // TODO check nullity
        handleInstructions(tondeuse, commands.toCharArray());
    }

    private void handleInstructions(Tondeuse tondeuse, char[] commands) throws Exception {
        for (char inst : commands) {
            Command command = Command.valueOf(inst);
            switch (command) {
                case G:
                case D: {
                    Direction direction = CommandApplier.applyCommand(tondeuse.getDirection(), command);
                    tondeuse.setDirection(direction);
                    break;
                }
                case A: {
                    Coordinates coordinates = tondeuse.getDirection().getMove().apply(tondeuse.getCoordinates());
                    if (canMove(coordinates)) {
                        tondeuse.setCoordinates(coordinates);
                    }
                    break;
                }
                default: {
                    // use non generic exception and decide if using runtime exception is better
                    // no need any way an exception will be raised in valueof
                    throw new Exception("test.tondeuse.Command not recognized");
                }
            }
        }
    }

    private boolean canMove(Coordinates coordinates) {
        return coordinates.getX() <= maxCoordinates.getX() && coordinates.getY() <= maxCoordinates.getY();
    }
}
