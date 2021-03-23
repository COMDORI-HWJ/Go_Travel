package com.comdori.Tab;

import javax.swing.*;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.*;



public class Tab2 extends JPanel {

    public Tab2() {
        setLayout(null);
        setBounds(0, 0, 1226, 662);

        JLabel lblMemo = new JLabel(" 여행 일정 메모");
        //lblMemo.setHorizontalAlignment(SwingConstants.LEFT);
        lblMemo.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lblMemo.setBounds(1060, 10, 840, 25);
        add(lblMemo);
        /* 				일정메모			 */
        JEditorPane editorPane = new JEditorPane();
        editorPane.setText("1일차 	이곳에 일정을 적으시오. 	 2일차 	이곳에 일정을 적으시오.  	 3일차        	이곳에 일정을 적으시오. 	");
        editorPane.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        editorPane.setBounds(1069, 44, 113, 611);
        add(editorPane);

        /* 				브라우저			 */
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        browserView.setLocation(0, 0);
        add(browserView, BorderLayout.CENTER);
        browserView.setSize(1062, 658);
        browser.loadURL("http://maps.google.com");  //구글지도 URL
    }
}
