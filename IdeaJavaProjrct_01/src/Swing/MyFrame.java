package Swing_01;

import Swing_01.Student;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFrame extends JFrame {
    JTextField jtext = new JTextField(20);
    JLabel timeLabel = new JLabel("00:00:00");
    JCheckBox agreefiled = new JCheckBox("同意此协议！");
    JComboBox<Student> como_stu = new JComboBox<Student>();
    JButton jbuttle_check_info = new JButton("获取用户信息");

    public MyFrame(String title) {
        super(title);
        //添加容器
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.add(jtext);
        root.add(timeLabel);

        JButton jbuttle_time = new JButton("获取时间~");
        root.add(jbuttle_time);

        jbuttle_time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTime();
            }
        });


        JButton jbuttle_text = new JButton("获取文本");
        root.add(jbuttle_text);
        jbuttle_text.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showText();
            }
        });

        root.add(agreefiled);
        agreefiled.setSelected(false);
        JButton jbuttle_next = new JButton("下一步");
        root.add(jbuttle_next);
        jbuttle_next.setEnabled(false);
        agreefiled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(agreefiled.isSelected())
                    jbuttle_next.setEnabled(true);
                else
                    jbuttle_next.setEnabled(false);
            }
        });

        root.add(como_stu);
        como_stu.addItem(new Student("闫科龙",true,18,111111));
        como_stu.addItem(new Student("闫xx",true,18,111111));
        root.add(jbuttle_check_info);
        jbuttle_check_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                get_stu_info();
            }
        });
    }
    public void showTime(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        String timeStr = sdf.format(new Date());
        timeLabel.setText(timeStr);
    }
    public void showText(){
        String str_text = jtext.getText();
        System.out.println("文本输出："+str_text);
    }
    public void get_stu_info(){
        Student stu_info = (Student) como_stu.getSelectedItem();
        System.out.println("用户信息:"+stu_info);
    }
}
