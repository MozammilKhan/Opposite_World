import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    private int level = 1;
    private String maze1=
        "00000000000000H"+
        "000000000000000"+
        "000000000000000"+
        "000WWWWWWWWW000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "000000000000000"+
        "000000000000000"+
        "000000000000000"+
        "h00000000000000";

    private String maze2=
       "00000000000000H"+
        "0000000000WW00"+
        "000000000000000"+
        "000W0000000W000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "000000000000000"+
        "0000WWW00000000"+
        "000000000000000"+
        "000000000000000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "00000000WWWW000"+
        "h00000000000000";

    private String maze3=
        "00WWW000000000H"+
        "00000W00WW00000"+
        "00WW000000W0000"+
        "0000000000W0000"+
        "000000000000000"+
        "0000000WWW00000"+
        "000000000000000"+
        "00WW000W0000000"+
        "000000000000000"+
        "0000000W0000000"+
        "0000000W0000000"+
        "000000000000000"+
        "0000WW000000000"+
        "00000000000WW00"+
        "h00000000000000";
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        buildMaze(maze1);
        
    }

    public void buildMaze(String maze)
    {
        removeObjects (getObjects(null));
        int x=20;
        int y=20;
        for(int p=0;p<maze.length();p++){
            if(maze.charAt(p)=='W'){
                addObject(new Wall(),x,y);
            }
            if(maze.charAt(p)=='H'){
                addObject(new Bug(true),x,y);
            }
            if(maze.charAt(p)=='h'){
                addObject(new Bug(false),x,y);
            }

            x+=40;    //move one space to the right
            if(x>getWidth()){    //when at the right edge of the world, move to the next row
                y+=40;
                x=20;
            }
        } 
    }

    public void nextLevel()
    {
        level++;
        switch(level) 
        {
            case 1: buildMaze(maze1); break;
            case 2: buildMaze(maze2); break;
            case 3: buildMaze(maze3); break;
        }
        if(level==4)
        {
            Greenfoot.setWorld( new Win() );
        }
    }

}
