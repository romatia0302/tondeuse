package test.tondeuse;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

// This class has not been tested automatically
public class TonteManager {

    public static void main(String[] args) throws Exception {
        TonteManager tonteManager = new TonteManager();
        String file = "C:\\Users\\youss\\IdeaProjects\\tondeuse\\src\\main\\resources\\program.txt";
        tonteManager.loadAndlaunchProgram(file);
    }

    public void loadAndlaunchProgram(String file) throws Exception {
        List<String> lines = Files.lines(Paths.get(file)).collect(Collectors.toList());
        if (lines != null && !lines.isEmpty()) {
            parseAndLaunchProgram(lines);
        } else {
            // use non generic exception and decide if using runtime exception is better
            throw new Exception("program file is not correct");
        }
    }

    private void parseAndLaunchProgram(List<String> lines) throws Exception {
        Coordinates maxCoordinates = parseMaxCoordinate(lines.get(0).trim());
        TondeuseController tondeuseController = new TondeuseController(maxCoordinates);
        for (int i = 1; i < lines.size(); i += 2) {
            Tondeuse tondeuse = extractTondeuse(lines.get(i).trim());
            // decided to launch it now and not to put them in list and launch later
            tondeuseController.handleInstructions(tondeuse, lines.get(i + 1).trim());
            // TODO use proper logger
            System.out.println("------------------------------------");
            System.out.println("initial position :" + lines.get(i));
            System.out.println("instructions :" + lines.get(i + 1));
            System.out.println("final position :" + tondeuse);
        }
    }

    private Tondeuse extractTondeuse(String initialPosition) throws Exception {
        String[] values = initialPosition.split(" ");
        if(values.length != 3){
            // use non generic exception and decide if using runtime exception is better
            throw new Exception("program file is not correct");
        }
        Direction direction = Direction.of(values[2]);
        Coordinates coordinates = new Coordinates(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        Tondeuse tondeuse = new Tondeuse(coordinates, direction);
        return tondeuse;
    }

    private Coordinates parseMaxCoordinate(String maxCoordinates) throws Exception {
        String[] values = maxCoordinates.split(" ");
        if(values.length != 2){
            // use non generic exception and decide if using runtime exception is better
            throw new Exception("program file is not correct");
        }
        return new Coordinates(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }
}
