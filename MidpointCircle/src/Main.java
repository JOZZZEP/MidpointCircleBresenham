import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        midpointFrame(new MidpointPanelEx4(), "EX4", new int[]{20, 20});
        midpointFrame(new MidpointPanelEx5(), "EX5", new int[]{20, 350});
        midpointFrame(new MidpointPanelEx6(), "EX6", new int[]{460, 20});
    }

    public static void midpointFrame(JPanel panel, String title, int [] xy){
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocation(xy[0],xy[1]);
        frame.setVisible(true);
    }
}