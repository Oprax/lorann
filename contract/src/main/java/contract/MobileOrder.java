package contract;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * List of the directions possible
 * @author Dorian
 */
public enum MobileOrder {
    Right,
    Up,
    Left,
    Down;

    public static List<MobileOrder> getValues() {
        return VALUES;
    }

    /**
     * @param pos Abscissa and ordinate
     * @param direction increment or decrease
     * @return a new position with the direction
     * @author Dorian
     */
    public static Point getPos(Point pos, MobileOrder direction) {

        switch (direction) {
            case Left:
                return new Point(
                            pos.x,
                            pos.y - 1);
            case Right:
                return new Point(
                            pos.x,
                            pos.y + 1);
            case Up:
                return new Point(
                            pos.x - 1,
                            pos.y);
            case Down:
                return new Point(
                            pos.x + 1,
                            pos.y);
        }

        return null;
    }

    /**
     * Instanciate the different values for the enum
     * @author Dorian
     */
    private static final List<MobileOrder> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    /**
     *Size of the list of direction possible. Each one is treated like a number
     * @author Dorian
     */
    private static final int SIZE = VALUES.size();
    /**
     * A variable using the Java Math.Random() method to instantiate a random number each time it's necessary
     * @author Dorian
     */
    private static final Random RANDOM = new Random();

    /**
     * Make a random move
     * @return random move for monster
     */
    public static MobileOrder random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
