package model.mobile;

import contract.IMobile;
import contract.IModel;
import contract.MobileOrder;
import model.Element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Yog on 13/06/2016.
 */
public abstract class Mobile extends Element implements IMobile {
    public Point getPos() {
        return pos.getLocation();
    }

    protected Point pos = new Point();

    protected MobileOrder direction = MobileOrder.Down;

    public Mobile(String imagePath, boolean permeability, Point pos) {
        super(imagePath, permeability);
        this.pos.setLocation(pos);
    }

    protected Point[] getPosAround(Point pos) {
        Point[] posAround = new Point[4];

        posAround[0] = new Point(pos.x - 1, pos.y);
        posAround[1] = new Point(pos.x + 1, pos.y);
        posAround[2] = new Point(pos.x, pos.y - 1);
        posAround[3] = new Point(pos.x, pos.y + 1);

        return posAround;
    }

    public void setLocation(Point loc) {
        this.pos.setLocation(loc);
    }

    public MobileOrder getDirection() {
        return direction;
    }

    public void move(MobileOrder order)
    {
        switch (order) {
            case Left:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() - 1);
                break;
            case Right:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() + 1);
                break;
            case Up:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY());
                break;
            case Down:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY());
                break;
        }
        this.direction = order;
        System.out.println("POS : " + pos);
    }
}
