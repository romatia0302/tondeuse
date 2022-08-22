package test.tondeuse;

public enum Command {
    D, G, A;

    public static Command valueOf(char inst) {
        return valueOf(String.valueOf(inst));
    }
}
