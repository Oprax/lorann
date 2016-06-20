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
 * Created by Quentin Strinati on 13/06/2016.
 */

/** Class used to create the Mobile class, extending from Element and implementing IMobile */
public abstract class Mobile extends Element implements IMobile {


    /** Method that gets the mobile position
     * @return the mobile's position
     */
    public Point getPos() {
        return pos.getLocation();
    }

    /**
     * Variable containing the mobile position
     */
    protected Point pos = new Point();

    /**
     * Variable containing the mobile direction
     */
    protected MobileOrder direction = MobileOrder.Down;

    /** Method used to instantiate the Mobile object
     * @param imagePath contains the path to the image file
     * @param permeability tells if the mobile is solid or something the hero can get through
     * @param pos contains the mobile's position
     */
    public Mobile(String imagePath, boolean permeability, Point pos) {
        super(imagePath, permeability);
        this.pos.setLocation(pos);
    }

    /** Method used to set the mobile's position
     * @param loc contains the location given to the mobile
     */
    public void setLocation(Point loc) {
        this.pos.setLocation(loc);
    }

    /** Method that gets the mobile's direction
     * @return the mobile's direction
     */
    public MobileOrder getDirection() {
        return direction;
    }

    /** Method that moves the mobile
     * @param order contains the order such as right, left, up or down
     */
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
