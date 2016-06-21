package model.mobile;

import contract.IFireball;
import contract.MobileOrder;
import model.Element;

import java.awt.*;

/**
 * Created by Quentin Strinati on 14/06/2016.
 */


/** Class that is used to build a fireball which will be the weapon for our hero */
public class FireBall extends Mobile implements IFireball {

    /** Speed of the fireball, 1 case at a time */
    private int step = 1;

    /** Method which instantiate the fireball object */
    public FireBall(Point pos) {
        super("fireball_1.png", true, pos);
    }

    /** Method which returns the step variable */
    public int getStep() {
        return step;
    }

    /**
     * Set the direction which to go for the fireball
     * @param direction variable defining the direction
     */
    public void setDirection(MobileOrder direction) {
        this.direction = direction;
    }

    /** Method that changes the fireball sprite so it's multicolour */
    public void animate() {
        this.step++;
        if(this.step > 0 && this.step < 6) {
            this.image = Element.loadSprite(String.format("fireball_%d.png", this.step));
        }
    }
}
