package com.comdori.Tab;

import java.awt.*;
/*
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
*/

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        try {
            Signup dialog = new Signup();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public Signup() {
        setTitle("회원가입");
        setType(Type.UTILITY); //윈도우 타이틀바 프레임 종류
        setResizable(false);
        setBounds(100, 100, 359, 467);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        panel.setBounds(0, 0, 353, 438);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(152, 206, 26, 32);
        lblId.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        panel.add(lblId);

        JLabel label = new JLabel("Password:");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        label.setBounds(83, 242, 95, 19);
        panel.add(label);

        textField = new JTextField();
        textField.setBounds(179, 217, 123, 19);
        panel.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(179, 245, 123, 21);
        panel.add(passwordField);

        JLabel label_1 = new JLabel("Phone Number:");
        label_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        label_1.setBounds(66, 264, 112, 27);
        panel.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(179, 269, 123, 21);
        panel.add(textField_1);
        textField_1.setColumns(10);

        Choice choice = new Choice();
        choice.setBounds(31, 10, 87, 21);
        panel.add(choice);

        JButton btnNewButton = new JButton("\uC644\uB8CC");
        btnNewButton.setBounds(83, 345, 97, 45);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("취소");
        btnNewButton_1.setBounds(190, 345, 97, 45);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        panel.add(btnNewButton_1);
    }
}
