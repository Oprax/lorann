package model.mobile;

import contract.*;

import java.awt.*;

/**
 * Created by Quentin Strinati on 14/06/2016.
 */

/** Class used to create the monster 4 */
public class Monster4 extends Mobile implements IMonster {

    /** Method that instantiates the Monster4 object
     * @param pos contains the monster's position
     */
    public Monster4(Point pos)
    {
        super("monster_4.png", true, pos);
    }

    @Override
    /** Method used to get the direction of the monster
     * @param heroPos contains the position of the hero so the monster knows what's up
     * @param tileMap contains the map in the memory
     * @return the monster's direction
     */
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return null;
    }
}
