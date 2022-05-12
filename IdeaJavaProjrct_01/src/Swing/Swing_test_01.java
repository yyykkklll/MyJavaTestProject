package Swing;

import Swing_01.MyFrame;
import javax.swing.*;

/**
 * @author ilc_yan
 */
public class Swing_test_01 {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame("this is my fiest java_swing!");
        // JFrame frame = new JFrame("我的第一个java swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
    }
}
