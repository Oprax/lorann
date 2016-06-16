package contract;

public interface IMonster extends IMobile {
    IElement[][] move(IElement[][] tileMap, IView view, IModel model);
}
