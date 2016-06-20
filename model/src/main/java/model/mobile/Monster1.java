package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by Yog on 14/06/2016.
 */
public class Monster1 extends Mobile implements IMonster {
    public Monster1(Point pos)
    {
        super("monster_1.png", true, pos);
    }

    @Override
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {


        Point pos = this.getPos().getLocation();

        System.out.printf("Hero : %s%n", heroPos);
        System.out.printf("Monster : %s%n", pos);

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

        System.out.printf("Dir : %s%n", direction);

        return direction;
    }
}
