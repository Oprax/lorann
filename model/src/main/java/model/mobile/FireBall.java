package model.mobile;

import contract.IFireball;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by Yog on 14/06/2016.
 */
public class FireBall extends Mobile implements IFireball {

    private int step = 1;

    public FireBall(Point pos) {
        super("fireball_1.png", true, pos);
    }

    public int getStep() {
        return step;
    }

    @Override
    public void setDirection(MobileOrder direction) {
        this.direction = direction;
    }

    public void animate() {
        if(this.step > 0 && this.step < 6) {
            this.loadSprite(String.format("sprite\\fireball_%d.png", this.step));
        }
        this.step++;

        System.out.println(this.step);
    }
}
