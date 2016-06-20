package contract;

/**
 *Interface fireball
 */
public interface IFireball extends IMobile {
    /**
     * @param direction
     * Initialize a direction
     * @author Dorian
     */
    void setDirection(MobileOrder direction);

    /**
     * The step is the speed of the fireball
     * @return step : int for number of case the fireball pass
     * @author Dorian
     */
    int getStep();

    /**
     * Method that changes the fireball sprite at each case of the array, so it's multicolour
     * @author Dorian
     */
    void animate();
}
