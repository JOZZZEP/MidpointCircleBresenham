import javax.swing.*;
import java.awt.*;

public class MidpointPanel extends JPanel {

    public MidpointPanel(){
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    public void paint(Graphics g) {
        midpoint(g, 200, 200, 140);
    }

    public void plotQ(Graphics g, int xCenter, int yCenter, int x, int y){
        g.fillOval(xCenter+x, yCenter+y, 10, 10);//Q1
//        g.fillOval(xCenter+y, yCenter+x, 10, 10);//Q2
//        g.fillOval(xCenter+y, yCenter-x, 10, 10);//Q3
        g.fillOval(xCenter+x, yCenter-y, 10, 10);//Q4
        g.fillOval(xCenter-x, yCenter-y, 10, 10);//Q5
//        g.fillOval(xCenter-y, yCenter-x, 10, 10);//Q6
//        g.fillOval(xCenter-y, yCenter+x, 10, 10);//Q7
        g.fillOval(xCenter-x, yCenter+y, 10, 10);//Q8
    }

    public void midpoint(Graphics g, int xCenter, int yCenter, int r){
        int x=0;
        int y=r;
        int p=1-r;

        g.setColor(Color.PINK);
//        g.fillOval(xCenter+x, yCenter+y, 10, 10);
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
//            g.fillOval(xCenter+x, yCenter+y, 10, 10);
            plotQ(g, xCenter, yCenter, x, y);
        }
    }
}
