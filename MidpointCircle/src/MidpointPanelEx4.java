import javax.swing.*;
import java.awt.*;

public class MidpointPanelEx4 extends JPanel {

    public MidpointPanelEx4(){
        setPreferredSize(new Dimension(400,250));
    }

    @Override
    public void paint(Graphics g) {
        midpoint(g, 200, 200, 140);
    }

    public void plotQ(Graphics g, int xCenter, int yCenter, int x, int y){
        g.fillOval(xCenter+y, yCenter-x, 10, 10);//Q3
        g.fillOval(xCenter+x, yCenter-y, 10, 10);//Q4
        g.fillOval(xCenter-x, yCenter-y, 10, 10);//Q5
        g.fillOval(xCenter-y, yCenter-x, 10, 10);//Q6
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
}
