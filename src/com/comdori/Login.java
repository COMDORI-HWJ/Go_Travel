package com.comdori;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Login extends JFrame {
    public JTextField IDField;
    public TextField PasswordField;
    public static String ID1; //스태틱을 사용하면 메모리에 변수가 공유된다. - 스태틱 덕분에 사용자 이름 모든 탭에서 불러오기 가능!

    //private JPasswordField PasswordField;
    private boolean Logincheck;
    static Toolkit toolkit = Toolkit.getDefaultToolkit();	//프레임 가운데 고정
    MyPanel panel = new MyPanel();

    public static void main(String[] args) {
        System.out.println("======================\n학번: 201504034\n이름: 하원지\n======================");
        System.out.println("\n=====Version 1.2======");

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {

                    Login frame = new Login();
                    /*			프레임 중앙 배치			*/
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = (int) ((dim.getWidth() - frame.getWidth()) / 2);
                    int y = (int) ((dim.getHeight() - frame.getHeight()) / 2);
                    frame.setLocation(x , y);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {

        getContentPane().setBackground(new Color(153, 204, 51));

        Image img = toolkit.getImage("System/Images/airplane.gif");		//프로그램 아이콘
        this.setIconImage(img);
        setTitle("Go Travel");			//프로그램 제목
        setFont(new Font("맑은 고딕", Font.BOLD, 15));

        setSize(408, 337);
        setResizable(false);		//프레임 크기 고정
        setDefaultCloseOperation(3);
        getContentPane().setLayout(null);

        JLabel ID = new JLabel("           ID:");
        ID.setBounds(21, 132, 78, 24);
        ID.setForeground(Color.WHITE);
        ID.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        getContentPane().add(ID);
        IDField = new JTextField();
        IDField.setBounds(95, 132, 270, 21);
        getContentPane().add(IDField);
        IDField.setColumns(10);

        JLabel Password = new JLabel(" Password:");
        Password.setBounds(21, 158, 78, 24);
        Password.setForeground(Color.WHITE);
        Password.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        getContentPane().add(Password);
        //PasswordField = new JPasswordField();
        PasswordField = new TextField();
        PasswordField.setEchoChar('*'); //암호화 안함, 입력시만 *로 표시돰.
        PasswordField.setBounds(95, 161, 270, 21);
        getContentPane().add(PasswordField);

        /* 나의 계정 찾기
        JButton btnLogin = new JButton("Find My Account");
        btnLogin.setBounds(212, 233, 153, 33);
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        getContentPane().add(btnLogin);
         */

        JLabel label = new JLabel("");
        label.setBounds(21, 11, 362, 102);
        label.setIcon(new ImageIcon("System/Images/GoTravel.png"));
        getContentPane().add(label);

        /*	 				로그인	 				 */
        JButton button = new JButton("LOGIN");
        button.setBounds(179, 191, 92, 33);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LoginCheck();
            }
        }
        );

        /* 			회원가입 			*/

        JButton button_1 = new JButton("SIGN UP");
        button_1.setBounds(95, 233, 114, 33);
        button_1.setIcon(null);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Signup().setVisible(true);			//회원가입 창으로 이동
            }
        });
        button_1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        getContentPane().add(button_1);

        /*			프로그램 버전 정보				*/
        JLabel lblVer = new JLabel("Version 1.1.1");
        lblVer.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        lblVer.setForeground(Color.YELLOW);
        lblVer.setBounds(300, 280, 150, 21);
        getContentPane().add(lblVer);

        /*			프레임 배경화면				*/
        JLabel label_1 = new JLabel("");
        label_1.setBounds(0, 0, 500, 400);
        label_1.setVerticalAlignment(SwingConstants.TOP);
        label_1.setIcon(new ImageIcon("System/Images/BG.png"));
        getContentPane().add(label_1);

    }
    public void LoginCheck(){
        int wj =JOptionPane.showConfirmDialog(null, "로그인 하시겠습니까?", "로그인", JOptionPane.YES_NO_OPTION);
        /* 임시 로그인 하드 코딩 */
        //   if(IDField.getText().equals("admin1") && new String(PasswordField.getPassword()).equals("1234")){
        if(IDField.getText().equals("hwj") && (PasswordField.getText().equals("1234"))){
            if(wj == JOptionPane.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "로그인이 취소되었습니다.", "로그인", JOptionPane.WARNING_MESSAGE);
            }
            else if(wj == JOptionPane.YES_OPTION){
                Logincheck = true;
            }

            if(Login_Check()){
                JOptionPane.showMessageDialog(null, IDField.getText()+"님 환영합니다!", "로그인", JOptionPane.PLAIN_MESSAGE);
                ID1 = IDField.getText(); //사용자 이름 저장
                /* 사용자 로그인 정보 출력 */
                System.out.println("User ID: "+IDField.getText());
                System.out.println("User Password: "+PasswordField.getText());
                System.out.println("String ID값 출력: "+ID1);
                new Main().setLocationRelativeTo(null);	//메인프레임이 가운데시작점으로 열린다.
                dispose();			//뒤에 있는 프레임이 꺼진다.
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "로그인 실패 다시시도 하십시오.", "로그인", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean Login_Check(){
        return Logincheck;
    }
    class MyPanel extends JPanel {
    }
}