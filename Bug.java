import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Maze game character "Bug" moves through the maze guided by the player's arrow keys.
 * This scenario utilizes the typical isKeyDown()/setLocation() strategy for controlling character motion,
 * but notice that within each conditional statement associated with the arrow keys, another conditional 
 * statement is embedded. This embedded conditional statement tests for a collision with (a) the wall and 
 * (b) the world edge.
 * 
 * @author (Brian Myers) 
 * @version (February 2010)
 */
public class Bug extends Actor
{       
    private boolean moveNormal;
   
    public Bug (boolean move)
    {
        moveNormal = move;
        getImage().scale(30,30);
    }

    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
        {
            if (moveNormal)
            {
                setLocation(getX() + 5, getY() );
                setRotation(0);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX() - 5 , getY()  ) ;
            }
            if (!moveNormal)
            {
                setLocation(getX() - 5, getY() );
                setRotation(180);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX() + 5, getY()  ) ;
            }
        }
        if (Greenfoot.isKeyDown("left"))
        {
            if (moveNormal)
            {
                setLocation(getX() - 5, getY() );
                setRotation(180);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX() + 5 , getY()  ) ;
            }
            if (!moveNormal)
            {
                setLocation(getX() + 5, getY() );
                setRotation(0);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX() - 5, getY()  ) ;
            }
        }
        if (Greenfoot.isKeyDown("down"))
        {
            if (moveNormal)
            {
                setLocation(getX() , getY() + 5);
                setRotation(90);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX() , getY() - 5 ) ;
            }
            if (!moveNormal)
            {
                setLocation(getX() , getY() - 5);
                setRotation(270);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX() , getY() + 5) ;
            }
        }
        if (Greenfoot.isKeyDown("up"))
        {
            if (moveNormal)
            {
                setLocation(getX() , getY() - 5);
                setRotation(270);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX()  , getY() + 5 ) ;
            }
            if (!moveNormal)
            {
                setLocation(getX() , getY() + 5);
                setRotation(90);
                Actor aWallCell = getOneIntersectingObject(Wall.class) ;
                if (aWallCell != null)
                    setLocation (getX() , getY() - 5 ) ;
            }
        }
        if(isTouching(Bug.class))
        {
            Level level = (Level)getWorld();
            level.nextLevel();
        }
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }   

    /**  
     * Returns true if the Bug is within the World's borders
     */

    public boolean canMove()

    {

        if (getX() > 0)
        {
            return true; 
        }

        else if (getY() > 0)
        {
            return true; 
        }

        else if (getX() < 500)
        {
            return true; 
        }

        else if (getY() < 500)
        {
            return true; 
        }

        else

            return false;

    }
}


