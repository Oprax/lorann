package model.mobile;

import contract.*;

import java.awt.*;

public abstract class Monster extends Mobile implements IMonster {
    public Monster(String imagePath, boolean permeability, Point pos) {
        super(imagePath, permeability, pos);
    }

    @Override
    public IElement[][] move(IElement[][] tileMap, IView view, IModel model) {
        Point nextPos = pos.getLocation();
        switch (MobileOrder.random()){
            case Left:
                if(pos.y > 0 &&
                        tileMap[pos.x][pos.y - 1].getPermeability())
                {
                    nextPos = new Point(
                            pos.x,
                            pos.y - 1);
                }
                break;
            case Right:
                if(pos.y < (view.getWidth() / 32) - 1 &&
                        tileMap[pos.x][pos.y + 1].getPermeability())
                {
                    nextPos = new Point(
                            pos.x,
                            pos.y + 1);
                }
                break;
            case Up:
                if(pos.x > 0 &&
                        tileMap[pos.x - 1][pos.y].getPermeability()) {
                    nextPos = new Point(
                            pos.x - 1,
                            pos.y);
                }
                break;
            case Down:
                if(pos.x < (view.getHeight() / 32) - 1 &&
                        tileMap[pos.x + 1][pos.y].getPermeability()) {
                    nextPos = new Point(
                            pos.x + 1,
                            pos.y);
                }
                break;
        }
        if(nextPos != pos) {
            tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());
            this.setLocation(nextPos);
            tileMap[nextPos.x][nextPos.y] = this;
        }
        return tileMap;
    }
}
