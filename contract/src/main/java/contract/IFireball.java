package contract;

/**
 *
 */
public interface IFireball extends IMobile {
    /**
     * @param direction
     */
    void setDirection(MobileOrder direction);

    /**
     * @return step
     */
    int getStep();

    /**
     *
     */
    void animate();
}
