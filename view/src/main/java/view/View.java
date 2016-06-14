package view;

import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

    /**
     * Return Hashtable<Character, String> of associate sprite
     * @return assocSprite
     */
    public Hashtable<Character, String> getAssocSprite() {
        return assocSprite;
    }

    /**
     * Array have letter in key and the sprite's name in value
     */
    private Hashtable<Character, String> assocSprite = new Hashtable<Character, String>();

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
		this.fillAssoc();
	}

    /**
     * Associate all sprite with a letter representing hin in tileMap
     */
    private void fillAssoc() {
        this.assocSprite.put('B', "bone.png");
        this.assocSprite.put('K', "crystal_ball.png");
        this.assocSprite.put('H', "horizontal_bone.png");
        this.assocSprite.put('V', "vertical_bone.png");
        this.assocSprite.put('C', "gate_closed.png");
        this.assocSprite.put('O', "gate_open.png");
        this.assocSprite.put('P', "purse.png");
        this.assocSprite.put('L', "lorann_b.png");
        this.assocSprite.put('1', "monster_1.png");
        this.assocSprite.put('2', "monster_2.png");
        this.assocSprite.put('3', "monster_3.png");
        this.assocSprite.put('4', "monster_4.png");
        this.assocSprite.put(' ', "");
    }

    /**
	 * CrystalBall code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.Map1;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.Map2;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.Map3;
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.Map4;
            case KeyEvent.VK_NUMPAD5:
                return ControllerOrder.Map5;
			case KeyEvent.VK_NUMPAD6:
				return ControllerOrder.Map6;
			case KeyEvent.VK_NUMPAD7:
				return ControllerOrder.Map7;
			case KeyEvent.VK_NUMPAD8:
				return ControllerOrder.Map8;
			case KeyEvent.VK_NUMPAD9:
				return ControllerOrder.Map8;
			case KeyEvent.VK_NUMPAD0:
				return ControllerOrder.Test;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.MOVELEFT;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.MOVERIGHT;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.MOVEDOWN;
			case KeyEvent.VK_UP:
				return ControllerOrder.MOVEUP;
			default:
				return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
