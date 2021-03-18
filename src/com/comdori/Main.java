package com.comdori;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.comdori.Tab.*;

public class Main extends JFrame {

    private JPanel contentPane;


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();

                    frame.setVisible(true);
                    /*			프레임 중앙 배치			*/
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = (int) ((dim.getWidth() - frame.getWidth()) / 2);
                    int y = (int) ((dim.getHeight() - frame.getHeight()) / 2);
                    frame.setLocation(x , y);
                    frame.setDefaultCloseOperation(3);		//1=HIDE_ON_CLOSE 2=DISPOSE_ON_CLOSE 3=EXIT_ON_CLOSE
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Main() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("System/Images/airplane.gif");		//프로그램 아이콘
        this.setIconImage(img);


        setTitle("Go Travel");			//프로그램 제목
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /*				메모장-내장 프레임				*/
        JInternalFrame Memo = new JInternalFrame("", true, true, true);
        Memo.setTitle("간단메모장");
        Memo.setResizable(true);	//프레임 크기 조절(false 할시 고정값)
        Memo.setBounds(1058, 533, 229, 148);		//프레임 기본 크기
        contentPane.add(Memo);
        JEditorPane Memoeditor = new JEditorPane();
        Memoeditor.setForeground(new Color(255, 255, 255));
        Memoeditor.setText("이곳에 메모를 하세요.          이 메모장은 움직일 수 있습니다.");
        Memoeditor.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        Memoeditor.setBackground(Color.DARK_GRAY);
        Memo.getContentPane().add(Memoeditor);
        Memo.setVisible(true);

        /*				탭팬 				*/
        JTabbedPane pane = TabPane();
        contentPane.add(pane);
        setResizable(false);		//프레임 크기 조절
        setSize(1293, 728);
        setVisible(true);

        /*			프레임 배경화면				*/
        JLabel label_1 = new JLabel("");
        label_1.setBounds(0, 0, 1280, 725);
        label_1.setVerticalAlignment(SwingConstants.TOP);
        label_1.setIcon(new ImageIcon("System/Images/Main_BackGround.png"));
        getContentPane().add(label_1);

    }
    JTabbedPane TabPane(){
        JTabbedPane pane = new JTabbedPane(JTabbedPane.RIGHT);		//오른쪽에 탭메뉴가 있음.
        pane.setBounds(12, 24, 1268, 662);
        //label.setBackground(new Color(255, 0, 0, 255));

        pane.setFont(new Font("맑은 고딕", Font.BOLD, 13));

        Tab1 tab1 = new Tab1();
        pane.addTab("홈", tab1);
        tab1.setLayout(null);

        /*Tab2 tab2 = new Tab2();
        pane.addTab("지도", tab2);
        tab2.setLayout(null);

        Tab3 tab3 = new Tab3();
        pane.addTab("세계 시간", tab3);
        tab3.setLayout(null);

        Tab4 tab4 = new Tab4();
        pane.addTab("날씨", tab4);
        tab4.setLayout(null);

        Tab5 tab5 = new Tab5();
        pane.addTab("번역기", tab5);
        tab5.setLayout(null);
*/


        return pane;
    }
}