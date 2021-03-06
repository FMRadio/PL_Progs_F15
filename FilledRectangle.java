 /*
 * The FilledRectangle class is a child class and extends Rectangle. It has an
 * extra variable to hold the background color. It also extends the Draw and
 * ToString methods.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class FilledRectangle extends Rectangle
{
    int width; //an int to hold the width of the shape
    int height; //an int to hold the height of the shape
    Color mycolor; //a Color variable to hold the background color for the shape

    public FilledRectangle(int sx, int sy, int ex, int ey, Color fcolor, Color bcolor)
    {
        super(sx, sy, ex, ey, fcolor); //pass the params to the super class
        if(sx < ex) //set the start and end x values correctlly
        {
            startx = sx;
            endx = ex;
        }
        else
        {
            startx = ex;
            endx = sx;
        }

        if(sy < ey) //set the start and end y values correctly
        {
            starty = sy;
            endy = ey;
        }
        else
        {
            starty = ey;
            endy = sy;
	    }
        mycolor = bcolor; //set mycolor to the background color
        width = endx - startx; //calculate the width of the shape
        height = endy - starty; //calculate the height of the shape
    }

    /*
    * The Draw method takes a Graphics variable as a parameter. It sets the
    * color to the background color and calls fillRect. Then it sets the color
    * to the foreground color and calls drawRect.
    */
    public void Draw(Graphics g)
    {
        g.setColor(mycolor); //set color to background color
        g.fillRect(startx, starty, width, height); //draw filled rectangle
	    g.setColor(ShapeColor); //set color to foreground color
	    g.drawRect(startx, starty, width, height); //draw rectangle
    }

    /*
    * The ToString method converts the shape data into a displayable string.
    */
    public String ToString()
    {
        return "Shape: Filled Rectangle\nStart Point: (" + startx + ","
               + starty + ") End Point: (" + endx + "," + endy
               + ")\nForeground Color: " + ShapeColor + " Background Color: "
               + mycolor + "\n";
    }
}
