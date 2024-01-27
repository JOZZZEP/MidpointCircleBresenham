import javax.swing.*;
import java.awt.*;

public class MidpointPanelEx6 extends JPanel {

    public MidpointPanelEx6(){
        setPreferredSize(new Dimension(600,400));
    }

    @Override
    public void paint(Graphics g) {
        int xc1=300,yc1=100;
        int xc2=100,yc2=300;
        int xc3=500,yc3=300;

        for (int i=60;i>=0;i-=10){
            midpoint(g, xc1, yc1, i);
            midpoint(g, xc2, yc2, i);
            midpoint(g, xc3, yc3, i);
        }

        bresenham(xc1,yc1,xc2,yc2,g);
        bresenham(xc2,yc2,xc3,yc3,g);
        bresenham(xc1,yc1,xc3,yc3,g);
    }

    public void plotQ(Graphics g, int xCenter, int yCenter, int x, int y){
        g.fillOval(xCenter+x, yCenter+y, 5, 5);//Q1
        g.fillOval(xCenter+y, yCenter+x, 5, 5);//Q2
        g.fillOval(xCenter+y, yCenter-x, 5, 5);//Q3
        g.fillOval(xCenter+x, yCenter-y, 5, 5);//Q4
        g.fillOval(xCenter-x, yCenter-y, 5, 5);//Q5
        g.fillOval(xCenter-y, yCenter-x, 5, 5);//Q6
        g.fillOval(xCenter-y, yCenter+x, 5, 5);//Q7
        g.fillOval(xCenter-x, yCenter+y, 5, 5);//Q8
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
    }

    public void bresenham(int x1, int y1, int x2,int y2, Graphics g){
        int x,y,dx,dy,p;

        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);

        p=2*dy-dx;
        x=x1;
        y=y1;

        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 5,5);

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
            g.fillOval(x, y, 5, 5);
        }
    }
}
