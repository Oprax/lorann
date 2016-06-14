package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;

    private String[][] tileMap;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
        this.tileMap = this.viewFrame.getController().parser(
                this.viewFrame.getModel().getMap());
		this.setSize(this.tileMap[0].length, this.tileMap.length);
		this.repaint();
	}

    /**
     * Modified windows size taking border in count and sprite size (32x32)
     *
     * @param width
     * @param height
     */
    public void setSize(int width, int height) {
        super.setSize((width*32) + this.getInsets().left + this.getInsets().right,
                (height*32) + this.getInsets().top + this.getInsets().bottom);
        this.viewFrame.setSize(width*32, height*32);
    }

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

        if(this.tileMap != null)
        {
            for (int i = 0; i < this.tileMap[0].length; i++)
            {
                for(int j = 0; j < this.tileMap.length; j++)
                {
                    if(!this.tileMap[j][i].equals(""))
                    {
                        BufferedImage image = null;
                        try {
                            image = ImageIO.read(new File(
                                    String.format("sprite\\%s", this.tileMap[j][i])));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        graphics.drawImage(image, i*32, j*32, null);
                    }
                }
            }
        }

    }
}
