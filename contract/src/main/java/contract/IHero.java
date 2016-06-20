package contract;

/**
 * Interface Hero
 */
public interface IHero extends IMobile {
    /**
     * @author Dorian
     * @param order from the user
     * @param tileMap check element and size map
     * @param view
     * Override move method from mobile for Hero element
     */
    void move(MobileOrder order, IElement[][] tileMap, IView view);
}
