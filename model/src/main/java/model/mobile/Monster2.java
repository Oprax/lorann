package model.mobile;

import contract.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Quentin Strinati on 14/06/2016.
 */

/** Class used to create the monster 2 */
public class Monster2 extends Mobile implements IMonster {

    /** Method that instantiates the Monster2 object
     * @param pos contains the monster's position
     */
    public Monster2(Point pos)
    {
        super("monster_2.png", true, pos);
    }

    /** Method used to get the direction of the monster
     * @param heroPos contains the position of the hero so the monster knows what's up
     * @param tileMap contains the map in the memory
     * @return the monster's direction
     */
    @Override
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        MobileOrder direction = MobileOrder.random();
/*
        Point pos = this.getPos().getLocation();
        Point curPos = pos.getLocation();

        ArrayList<IElement> open = new ArrayList<IElement>();
        ArrayList<IElement> close = new ArrayList<IElement>();

        open.add(tileMap[curPos.x][curPos.y]);
        close.add(tileMap[curPos.x][curPos.y]);

        while(!open.isEmpty() && !curPos.equals(heroPos)) {
            for (MobileOrder dir : MobileOrder.values()) {
                Point aroundPos = MobileOrder.getPos(curPos, dir);

            }
        }
*/
        return direction;
    }
}
