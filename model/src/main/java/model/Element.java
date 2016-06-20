package model;

import contract.IElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Quentin Strinati on 13/06/2016.
 */

/** The class that creates an element, implementing IElement */
public abstract class Element implements IElement {
    /**
     * Variable containing the image
     */
    protected BufferedImage image = null;
    /**
     * Variable telling if the hero can get through it or not
     */
    protected boolean permeability;

    /** Method that instantiates the Element object
     * @param path contains path to the sprite file
     * @param permeability tells if the hero can get through it or not
     */
    public Element(String path, boolean permeability)
    {
        if(!path.equals("")) {
            this.loadSprite(path);
        }
        this.permeability = permeability;
    }

    /** Method loading the sprite
     * @param path contains path to the sprite file
     */
    protected void loadSprite(String path) {
        System.out.println(String.format("Working Directory = /sprite/%s", path));
        if(path == null)
            return;
        try {
            this.image = ImageIO.read(
                    getClass().getResource(
                            String.format("/sprite/%s", path)));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Pathname is '%s'%n", path);
        }
    }

    /** Getting the image
     * @return the element's image
     */
    public BufferedImage getImage()
    {
        return this.image;
    }

    /** Getting the permeability
     * @return true if permeable, false if not
     */
    public boolean getPermeability()
    {
        return permeability;
    }


}
