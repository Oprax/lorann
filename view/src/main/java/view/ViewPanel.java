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
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

    private static String[][] tileMap = new String[50][50];

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
        this.tileMap = this.viewFrame.getController().parser(this.viewFrame.getModel().getMap());
        this.setSize(this.tileMap.length, this.tileMap[0].length);
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
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        //graphics.drawString(this.getViewFrame().getModel().getMap(), 10, 20);

        for (int i = 0; i < this.tileMap.length; i++)
        {
            for(int j = 0; j < this.tileMap[0].length; j++)
            {
                if(this.tileMap[i][j].equals(""))
                {
                    System.out.println(i);
                    System.out.println(j);
                }
                else
                {
                    System.out.println(String.format("sprite\\%s", this.tileMap[i][j]));
                    BufferedImage image = null;
                    try {
                        image = ImageIO.read(new File(String.format("sprite\\%s", this.tileMap[i][j])));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    graphics.drawImage(image, i*32, j*32, null);
                }
            }
        }
    }
}
