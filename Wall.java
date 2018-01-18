import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    public Wall()
    {
        GreenfootImage squareImage = new GreenfootImage(40, 40);
        squareImage.setColor(new Color(50, 100, 200, 255));

        squareImage.fill();
        setImage(squareImage);

    }
  
}
