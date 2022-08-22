package test.tondeuse;

import java.util.HashMap;
import java.util.Map;

public class CommandApplier {

    private static Map<Direction, Map<Command, Direction>> commandDirectionGraph = new HashMap<>();
    static {
        Map<Command, Direction> eastMap = new HashMap<>();
        eastMap.put(Command.G, Direction.NORTH);
        eastMap.put(Command.D, Direction.SOUTH);
        commandDirectionGraph.put(Direction.EAST, eastMap) ;

        Map<Command, Direction> northMap = new HashMap<>();
        northMap.put(Command.G, Direction.WEST);
        northMap.put(Command.D, Direction.EAST);
        commandDirectionGraph.put(Direction.NORTH, northMap) ;

        Map<Command, Direction> westMap = new HashMap<>();
        westMap.put(Command.G, Direction.SOUTH);
        westMap.put(Command.D, Direction.NORTH);
        commandDirectionGraph.put(Direction.WEST, westMap) ;

        Map<Command, Direction> southMap = new HashMap<>();
        southMap.put(Command.G, Direction.EAST);
        southMap.put(Command.D, Direction.WEST);
        commandDirectionGraph.put(Direction.SOUTH, southMap) ;
    }

    public static Direction applyCommand(Direction direction, Command command){
        // TODO check nullity
        return commandDirectionGraph.get(direction).get(command);
    }
}
