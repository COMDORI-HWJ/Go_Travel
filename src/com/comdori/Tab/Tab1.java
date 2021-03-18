package com.comdori.Tab;

import com.comdori.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tab1 extends JPanel {

    public Tab1() {
        setLayout(null);
        setBounds(0, 0, 1234, 662);

        JLabel lblWelcome = new JLabel("Welcome!");
        lblWelcome.setForeground(new Color(248, 248, 255));
        lblWelcome.setFont(new Font("굴림", Font.BOLD, 99));
        lblWelcome.setBounds(40, 33, 538, 195);
        add(lblWelcome);

        JLabel lblS = new JLabel("admin님 오늘도 즐거운 여행되세요!");
        lblS.setForeground(Color.WHITE);
        lblS.setFont(new Font("맑은 고딕", Font.PLAIN, 70));
        lblS.setBounds(24, 238, 1172, 125);
        add(lblS);

        JButton btnLogout = new JButton("LogOut");
        btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 65));
        btnLogout.setBounds(40, 421, 427, 143);
        add(btnLogout);

        JLabel background = new JLabel("");
        background.setBounds(0, 0, 1234, 662);
        add(background);
        background.setIcon(new ImageIcon("System/Images/Tab1_BackGround.jpg"));
        btnLogout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그인", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {

                    new Login().setVisible(true);
                    System.exit(0);

                } else {

                }
            }
        });
    }
}
