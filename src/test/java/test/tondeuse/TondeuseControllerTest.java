package test.tondeuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TondeuseControllerTest {

    private String instructions1 = "GAGAGAGAA"  ;
    private String instructions2 = "AADAADADDA" ;
    private String instructions_not_correct = "AARGG" ;

    private TondeuseController tondeuseController;

    @BeforeEach
    void setUp() {
        tondeuseController = new TondeuseController(new Coordinates(5,5));
    }

    @Test
    void should_find_correct_position() throws Exception {
        Tondeuse tondeuse = new Tondeuse(new Coordinates(1,2), Direction.NORTH);
        tondeuseController.handleInstructions(tondeuse, instructions1) ;
        assertEquals(new Tondeuse(new Coordinates(1,3), Direction.NORTH), tondeuse);
    }

    @Test
    void should_find_correct_position2() throws Exception {
        Tondeuse tondeuse = new Tondeuse(new Coordinates(3,3), Direction.EAST);
        tondeuseController.handleInstructions(tondeuse, instructions2) ;
        assertEquals(new Tondeuse(new Coordinates(5,1), Direction.EAST), tondeuse);
    }

    @Test()
    void should_raise_exception_when_command_not_correct() throws Exception {
        Tondeuse tondeuse = new Tondeuse(new Coordinates(3,3), Direction.EAST);
        assertThrows(Exception.class, () -> {
            tondeuseController.handleInstructions(tondeuse, instructions_not_correct);
        });
    }
}