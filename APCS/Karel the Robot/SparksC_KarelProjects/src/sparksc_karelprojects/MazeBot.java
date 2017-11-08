/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sparksc_karelprojects;

import java.awt.Color;

/**
 *
 * @author CSLAB313-1740
 */
public class MazeBot extends AdvRobot {
    public MazeBot(int street, int avenue, Direction d, int beepers, Color c) {
        super(street, avenue, d, beepers, c);
    }
    public void followWallRight()
    {
        while(this.nextToABeeper()==false)
        {
            isRightClear();
        }
    }
    public void isRightClear()
    {
        this.turnRight();
        while(!frontIsClear())
        {
            this.turnLeft();
        }
        this.move();
    }
}
