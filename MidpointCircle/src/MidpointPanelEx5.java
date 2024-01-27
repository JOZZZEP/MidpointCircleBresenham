import javax.swing.*;
import java.awt.*;

public class MidpointPanelEx5 extends JPanel {

    public MidpointPanelEx5(){
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    public void paint(Graphics g) {
        midpoint(g, 200, 200, 140);
    }

    public void plotQ(Graphics g, int xCenter, int yCenter, int x, int y){
        g.fillOval(xCenter+x, yCenter+y, 10, 10);//Q1
        g.fillOval(xCenter+x, yCenter-y, 10, 10);//Q4
        g.fillOval(xCenter-x, yCenter-y, 10, 10);//Q5
        g.fillOval(xCenter-x, yCenter+y, 10, 10);//Q8
    }

    public void midpoint(Graphics g, int xCenter, int yCenter, int r){
        int x=0;
        int y=r;
        int p=1-r;

        g.setColor(Color.PINK);
        plotQ(g, xCenter, yCenter, x, y);
        while (x<=y){
            x+=1;
            if (p<0){
                p+=2*x+1;
            }
            else{
                y-=1;
                p+=2*x+1-2*y;
            }
            plotQ(g, xCenter, yCenter, x, y);
        }
        bresenham(xCenter-x,yCenter+y,xCenter+x,yCenter-y,g);
        bresenham(xCenter-x,yCenter-y,xCenter+x,yCenter+y,g);
    }

    public void bresenham(int x1, int y1, int x2,int y2, Graphics g){
        int x,y,dx,dy,p;

        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);

        p=2*dy-dx;
        x=x1;
        y=y1;

        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 10,10);

        int stepX = x1 < x2 ? 1 : -1;
        int stepY = y1 < y2 ? 1 : -1;

        while (x != x2) {
            x += stepX;
            if (p < 0) {
                p += 2 * dy;
            } else {
                y += stepY;
                p += 2 * dy - 2 * dx;
            }
            g.fillOval(x, y, 10, 10);
        }
    }
}
