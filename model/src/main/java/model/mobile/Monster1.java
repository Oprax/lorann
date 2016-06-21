package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by Quentin Strinati on 14/06/2016.
 */

/** Class that is used to create the monster 1 */
public class Monster1 extends Mobile implements IMonster {

    /** Method used to instantiate the Monster1 object
     * @param pos contains the position of the monster
     */
    public Monster1(Point pos)
    {
        super("monster_1.png", true, pos);
    }

    /** Method used to get the direction of the monster depending of the hero position
     * @param heroPos contains the position of the hero, so the monster knows what's up
     * @param tileMap contains the map loaded in memory
     * @return contains the direction of the monster
     */
    @Override
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {


        Point pos = this.getPos().getLocation();

        MobileOrder direction = MobileOrder.random();

        int distance = 10000;

        for (MobileOrder dir : MobileOrder.values()) {
            Point aroundPos = MobileOrder.getPos(pos, dir);
            if (tileMap[aroundPos.x][aroundPos.y].getPermeability()) {
                int aroundDist = (heroPos.x-aroundPos.x)*(heroPos.x-aroundPos.x) +
                        (heroPos.y-aroundPos.y)*(heroPos.y-aroundPos.y);

                if(aroundDist < distance) {
                    distance = aroundDist;
                    direction = dir;
                }
            }
        }

        return direction;
    }
}
