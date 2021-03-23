package com.comdori.Tab;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Calendar;
import javax.swing.*;


interface Timed {
    public void tick(Timer t);
}

class Timer extends Thread {
    private Timed target;
    private int interval;

    public Timer(Timed t, int i) {
        target = t;
        interval = i;
        setDaemon(true);
    }

    public void run() {
        while (true) {
            try {
                sleep(interval);
                target.tick(this);
            } catch (InterruptedException e) {
            } finally {

            }
        }
    }
}

public class Tab3 extends JPanel {

    public Tab3() {
        setBounds(0, 0, 1234, 662);
        setLayout(null);
        com.comdori.Tab.ClockCanvas clockCanvas_2 = new ClockCanvas("Seoul", 16);
        clockCanvas_2.baseX = 75;
        clockCanvas_2.baseY = 30;
        clockCanvas_2.center = 200;
        clockCanvas_2.clockW = 250;
        clockCanvas_2.clockH = 250;
        clockCanvas_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));

        clockCanvas_2.setBackground(new Color(238, 232, 170));
        clockCanvas_2.setBounds(0, 0, 411, 331);
        add(clockCanvas_2);
        com.comdori.Tab.ClockCanvas clockCanvas = new ClockCanvas("Chicago", 1);
        clockCanvas.setBounds(411, 0, 411, 331);
        clockCanvas.setBackground(Color.PINK);
        add(clockCanvas);
        com.comdori.Tab.ClockCanvas clockCanvas_1 = new ClockCanvas("London", 7);
        clockCanvas_1.setBackground(new Color(255, 69, 0));
        clockCanvas_1.setBounds(822, 0, 411, 331);
        add(clockCanvas_1);
        com.comdori.Tab.ClockCanvas clockCanvas_3 = new ClockCanvas("Moscow", 10);
        clockCanvas_3.setBackground(SystemColor.inactiveCaption);
        clockCanvas_3.setBounds(0, 331, 411, 331);
        add(clockCanvas_3);
        com.comdori.Tab.ClockCanvas clockCanvas_4 = new ClockCanvas("Paris", 8);
        clockCanvas_4.setBackground(new Color(72, 209, 204));
        clockCanvas_4.setBounds(411, 331, 411, 331);
        add(clockCanvas_4);
        com.comdori.Tab.ClockCanvas clockCanvas_5 = new ClockCanvas("Beijing", 15);
        clockCanvas_5.setBackground(new Color(34, 139, 34));
        clockCanvas_5.setBounds(822, 331, 411, 331);
        add(clockCanvas_5);
    }

    public static void main(String[] args) {
        JPanel f = new Tab3();

        WindowDestroyer listener = new WindowDestroyer();
        //f.addWindowListener(listener);
        //f.setVisible(true);
    }
}

class ClockCanvas extends Canvas implements Timed {

    public int baseX = 10;
    public int baseY = 10;
    public int clockW = 100;
    public int clockH = 100;
    public int center = baseX + clockH / 2;

    private int seconds = 0;
    private String city;
    private int offset;
    private final int LOCAL = 16;

    public ClockCanvas(String c, int off) {
        city = c;
        offset = off;

        new Timer(this, 1000).start();
        setSize(125, 125);
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(baseX, baseY, clockW, clockH);

        double hourAngle = 2 * Math.PI * (seconds - 3 * 60 * 60) / (12 * 60 * 60);
        double minuteAngle = 2 * Math.PI * (seconds - 15 * 60) / (60 * 60);
        double secondAngle = 2 * Math.PI * (seconds - 15) / 60;
        /*
        System.out.println("hourAngle : " + hourAngle);
        System.out.println("minuteAngel : " + minuteAngle);
        System.out.println("secondAngle : " + secondAngle);
        */

        g.setColor(Color.black);
        g.drawLine(center, center, center + (int) (30 * Math.cos(hourAngle)),
                center + (int) (30 * Math.sin(hourAngle)));
        g.drawLine(center, center, center + (int) (40 * Math.cos(minuteAngle)),
                center + (int) (40 * Math.sin(minuteAngle)));
        g.setColor(Color.blue);
        g.drawLine(center, center, center + (int) (45 * Math.cos(secondAngle)),
                center + (int) (45 * Math.sin(secondAngle)));
        g.setColor(Color.black);
        g.drawString(city, baseX, baseY + clockH + 10);
    }

    public void tick(Timer t) {


        Calendar cal = Calendar.getInstance();


        seconds = ((cal.get(Calendar.HOUR) - LOCAL + offset) * 60 * 60) + (cal.get(Calendar.MINUTE) * 60)+ cal.get(Calendar.SECOND);
        /*
        System.out.println("tick 메소드입니다.seconds : " + seconds);
        System.out.println("offset : " + offset);
        System.out.println("LOCAL : " + LOCAL);
        System.out.println("HOUR : " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Calendar.MINUTE * 60 : " + (cal.get(Calendar.MINUTE) * 60));
        System.out.println("Calendar.SECOND : " + cal.get(Calendar.SECOND));
        System.out.println("getTime : " + Calendar.getTime() );
        */
        repaint();
    }
}

class WindowDestroyer extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);

    }

}

