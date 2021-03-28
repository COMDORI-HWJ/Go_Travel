package com.comdori.Tab;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

//api 인증서 재발급 해야함.

public class Tab4 extends JPanel {
    public Tab4() {
        setLayout(null);
        setSize(1234, 662);

        try{
            //lon=경도  lat=위도

            /*			1번 도시 모스크바		*/
            String lon = "37.615555";
            String lat = "55.75222";   //위도

            //OpenAPI call하는 URL
            String urlstr = "http://api.openweathermap.org/data/2.5/weather?"+ "lat="+lat+"&lon="+lon+"&appid=aa7176f7935e032bfdc579de7c7c9e7d";

            URL url = new URL(urlstr);
            BufferedReader bf;
            String line;
            String result="";

            //날씨 정보를 받아온다.
            bf = new BufferedReader(new InputStreamReader(url.openStream()));

            //버퍼에 있는 정보를 문자열로 변환.
            while((line=bf.readLine())!=null){
                result=result.concat(line);
            }

            //문자열을 JSON으로 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

            //지역 출력
            System.out.println("지역 : "+ jsonObject.get("name"));
            JLabel City = new JLabel();

            City.setText(jsonObject.get("name").toString());
            City.setFont(new Font("맑은 고딕", Font.BOLD, 65));
            City.setHorizontalAlignment(SwingConstants.CENTER);
            City.setBounds(98, 82, 366, 66);
            add(City);

            //날씨 출력
            JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
            JSONObject  obj = (JSONObject) weatherArray.get(0);

            System.out.println("날씨 : "+obj.get("main"));

            System.out.println("id: "+obj.get("id"));


            JLabel Weather_condition = new JLabel("날씨 상태");
            JLabel Weather_Icon_Broken_Clouds = new JLabel();
            JLabel Weather_Icon_Clear = new JLabel();
            JLabel Weather_Icon_Clouds = new JLabel();
            JLabel Weather_Icon_Few_Clouds = new JLabel();
            JLabel Weather_Icon_Haze = new JLabel();
            JLabel Weather_Icon_Rain = new JLabel();
            JLabel Weather_Icon_Shower_Rain = new JLabel();
            JLabel Weather_Icon_Snow = new JLabel();
            JLabel Weather_Icon_Thunderstorm = new JLabel();
            JLabel Weather_Icon_N_A = new JLabel();

            {
                if(obj.get("icon").equals("04d"))	{
                    System.out.println("깨진 구름 낮");
                    add(Weather_Icon_Broken_Clouds);
                    Weather_condition.setText("어두운 구름");
                }

                else if(obj.get("icon").equals("04n"))	{
                    System.out.println("깨진 구름 저녁");
                    add(Weather_Icon_Broken_Clouds);
                    Weather_condition.setText("어둡 구름저녁");
                }

                else if(obj.get("icon").equals("01d")){
                    System.out.println("맑음 낮");
                    add(Weather_Icon_Clear);
                    Weather_condition.setText("맑아요~!");
                }

                else if(obj.get("icon").equals("01n")){
                    System.out.println("맑음 저녁");
                    add(Weather_Icon_Clear);
                    Weather_condition.setText("맑은 저녁");
                }

                else if(obj.get("icon").equals("03d")){
                    System.out.println("구름많음 낮");
                    add(Weather_Icon_Clouds);
                    Weather_condition.setText("구름이 많아요");
                }


                else if(obj.get("icon").equals("03n")){
                    System.out.println("구름많음 저녁");
                    add(Weather_Icon_Clouds);
                    Weather_condition.setText("구름이 많은 저녁");
                }

                else if(obj.get("icon").equals("02d")){
                    System.out.println("구름약간 낮");
                    add(Weather_Icon_Few_Clouds);
                    Weather_condition.setText("구름이 약간 있음");
                }

                else if(obj.get("icon").equals("02n")){
                    System.out.println("구름약간 저녁");
                    add(Weather_Icon_Few_Clouds);
                    Weather_condition.setText("구름 약간 있는 저녁");
                }

                else if(obj.get("icon").equals("50d")){
                    System.out.println("안개 낮");
                    add(Weather_Icon_Haze);
                    Weather_condition.setText("안개");
                }

                else if(obj.get("icon").equals("50n")){
                    System.out.println("안개 저녁");
                    add(Weather_Icon_Haze);
                    Weather_condition.setText("안개낀 저녁");
                }

                else if(obj.get("icon").equals("10d")){
                    System.out.println("비 낮");
                    add(Weather_Icon_Rain);
                    Weather_condition.setText("비");
                }

                else if(obj.get("icon").equals("10n")){
                    System.out.println("비 저녁");
                    add(Weather_Icon_Rain);
                    Weather_condition.setText("비 내리는 저녁");
                }

                else if(obj.get("icon").equals("09d")){
                    System.out.println("소나기 낮");
                    add(Weather_Icon_Shower_Rain);
                    Weather_condition.setText("소나기");
                }

                else if(obj.get("icon").equals("09n")){
                    System.out.println("소나기 저녁");
                    add(Weather_Icon_Shower_Rain);
                    Weather_condition.setText("소나기 내리는 저녁");
                }

                else if(obj.get("icon").equals("13d")){
                    System.out.println("눈 낮");
                    add(Weather_Icon_Snow);
                    Weather_condition.setText("눈이 내립니다");
                }

                else if(obj.get("icon").equals("13n")){
                    System.out.println("눈  저녁");
                    add(Weather_Icon_Snow);
                    Weather_condition.setText("눈 내리는 저녁");
                }

                else if(obj.get("icon").equals("11d")){
                    System.out.println("뇌우 낮");
                    add(Weather_Icon_Thunderstorm);
                    Weather_condition.setText("뇌우");
                }

                else if(obj.get("icon").equals("11n")){
                    System.out.println("뇌우 저녁");
                    add(Weather_Icon_Thunderstorm);
                    Weather_condition.setText("뇌우 치는 저녁");
                }

                else{
                    System.out.println("날씨 상태를 알수 없음");
                    add(Weather_Icon_N_A);
                    Weather_condition.setText("날씨 상태를 알 수 없습니다.");
                }

            }

            System.out.println("출력문: "+jsonObject.get("weather"));
            JSONObject mainArray = (JSONObject) jsonObject.get("main");
            double ktemp = Double.parseDouble(mainArray.get("temp").toString());
            double temp = ktemp-273.15;  //온도 출력(절대온도라서 변환 필요)

            JLabel Weather_Temperature = new JLabel("Temperature");
            Weather_Temperature.setForeground(Color.ORANGE);
            String WT = Weather_Temperature.getText();
            WT = String.format("%.2f℃", temp);
            bf.close();

            JLabel Line = new JLabel();
            Line.setHorizontalAlignment(SwingConstants.CENTER);
            Line.setBounds(595, 0, 43, 662);
            Line.setIcon(new ImageIcon("System/Images/Line.png"));
            add(Line);

            Weather_condition.setForeground(new Color(255, 255, 204));
            Weather_condition.setFont(new Font("맑은 고딕", Font.BOLD, 40));
            Weather_condition.setBounds(338, 301, 300, 52);
            add(Weather_condition);

            Weather_Temperature.setText(WT);
            Weather_Temperature.setFont(new Font("맑은 고딕", Font.BOLD, 80));
            Weather_Temperature.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Temperature.setBounds(134, 472, 382, 118);
            add(Weather_Temperature);

            /*	날씨 상태 이미지  분류	*/
            Weather_Icon_Broken_Clouds.setIcon(new ImageIcon("System/Images/Weather/Broken_Clouds.png"));
            Weather_Icon_Broken_Clouds.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Broken_Clouds.setBounds(24, 228, 291, 224);

            Weather_Icon_Clear.setIcon(new ImageIcon("System/Images/Weather/Clear.png"));
            Weather_Icon_Clear.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Clear.setBounds(24, 228, 291, 224);

            Weather_Icon_Clouds.setIcon(new ImageIcon("System/Images/Weather/Clouds.png"));
            Weather_Icon_Clouds.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Clouds.setBounds(24, 228, 291, 224);

            Weather_Icon_Few_Clouds.setIcon(new ImageIcon("System/Images/Weather/Few_Clouds.png"));
            Weather_Icon_Few_Clouds.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Few_Clouds.setBounds(24, 228, 291, 224);

            Weather_Icon_Haze.setIcon(new ImageIcon("System/Images/Weather/Haze.png"));
            Weather_Icon_Haze.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Haze.setBounds(24, 228, 291, 224);

            Weather_Icon_Rain.setIcon(new ImageIcon("System/Images/Weather/Rain.png"));
            Weather_Icon_Rain.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Rain.setBounds(24, 228, 291, 224);

            Weather_Icon_Shower_Rain.setIcon(new ImageIcon("System/Images/Weather/Shower_Rain.png"));
            Weather_Icon_Shower_Rain.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Shower_Rain.setBounds(24, 228, 291, 224);

            Weather_Icon_Snow.setIcon(new ImageIcon("System/Images/Weather/Snow.png"));
            Weather_Icon_Snow.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Snow.setBounds(24, 228, 291, 224);

            Weather_Icon_Thunderstorm.setIcon(new ImageIcon("System/Images/Weather/Thunderstorm.png"));
            Weather_Icon_Thunderstorm.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Thunderstorm.setBounds(24, 228, 291, 224);

            Weather_Icon_N_A.setIcon(new ImageIcon("System/Images/Weather/N_A.png"));
            Weather_Icon_N_A.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_N_A.setBounds(24, 228, 291, 224);

            /*			2번 도시 서울		*/

            String lat2 = "37.566386";   //위도
            String lon2 = "126.977948";  //경도

            String urlstr_2 = "http://api.openweathermap.org/data/2.5/weather?"+ "lat="+lat2+"&lon="+lon2
                    +"&appid=aa7176f7935e032bfdc579de7c7c9e7d";
            URL url_2 = new URL(urlstr_2);
            BufferedReader bf_2;
            String line_2;
            String result_2="";

            //날씨 정보를 받아온다.
            bf_2 = new BufferedReader(new InputStreamReader(url_2.openStream()));

            //버퍼에 있는 정보를 문자열로 변환.
            while((line_2=bf_2.readLine())!=null){
                result_2=result_2.concat(line_2);
            }

            //문자열을 JSON으로 파싱
            JSONParser jsonParser_2 = new JSONParser();
            JSONObject jsonObject_2 = (JSONObject) jsonParser_2.parse(result_2);

            System.out.println("지역 : "+ jsonObject_2.get("name"));

            /*			날씨 출력		*/
            JSONArray weatherArray_2 = (JSONArray) jsonObject_2.get("weather");
            JSONObject  obj_2 = (JSONObject) weatherArray_2.get(0);
            JSONObject mainArray_2 = (JSONObject) jsonObject_2.get("main");

            double ktemp_2 = Double.parseDouble(mainArray_2.get("temp").toString());
            double temp_2 = ktemp_2-273.15;  //온도 출력(절대온도라서 변환 필요)

            JLabel City2= new JLabel();
            City2.setText(jsonObject_2.get("name").toString());
            City2.setHorizontalAlignment(SwingConstants.CENTER);
            City2.setFont(new Font("맑은 고딕", Font.BOLD, 65));
            City2.setBounds(711, 82, 366, 66);
            add(City2);

            JLabel Weather_condition2 = new JLabel("날씨 상태");
            Weather_condition2.setForeground(new Color(255, 255, 204));
            Weather_condition2.setFont(new Font("맑은 고딕", Font.BOLD, 40));
            Weather_condition2.setBounds(911, 301, 300, 52);
            add(Weather_condition2);

            JLabel Weather_Icon_Broken_Clouds_2 = new JLabel();
            JLabel Weather_Icon_Clear_2 = new JLabel();
            JLabel Weather_Icon_Clouds_2 = new JLabel();
            JLabel Weather_Icon_Few_Clouds_2 = new JLabel();
            JLabel Weather_Icon_Haze_2 = new JLabel();
            JLabel Weather_Icon_Rain_2 = new JLabel();
            JLabel Weather_Icon_Shower_Rain_2 = new JLabel();
            JLabel Weather_Icon_Snow_2 = new JLabel();
            JLabel Weather_Icon_Thunderstorm_2 = new JLabel();
            JLabel Weather_Icon_N_A_2 = new JLabel();

            {
                if(obj_2.get("icon").equals("04d"))	{
                    System.out.println("깨진 구름 낮");
                    add(Weather_Icon_Broken_Clouds_2);
                    Weather_condition2.setText("어두운 구름");
                }

                else if(obj_2.get("icon").equals("04n"))	{
                    System.out.println("깨진 구름 저녁");
                    add(Weather_Icon_Broken_Clouds_2);
                    Weather_condition2.setText("어둡 구름저녁");
                }

                else if(obj_2.get("icon").equals("01d")){
                    System.out.println("맑음 낮");
                    add(Weather_Icon_Clear_2);
                    Weather_condition2.setText("맑아요~!");
                }

                else if(obj_2.get("icon").equals("01n")){
                    System.out.println("맑음 저녁");
                    add(Weather_Icon_Clear_2);
                    Weather_condition2.setText("맑은 저녁");
                }

                else if(obj_2.get("icon").equals("03d")){
                    System.out.println("구름많음 낮");
                    add(Weather_Icon_Clouds_2);
                    Weather_condition2.setText("구름이 많아요");
                }

                else if(obj_2.get("icon").equals("03n")){
                    System.out.println("구름많음 저녁");
                    add(Weather_Icon_Clouds_2);
                    Weather_condition2.setText("구름이 많은 저녁");
                }

                else if(obj_2.get("icon").equals("02d")){
                    System.out.println("구름약간 낮");
                    add(Weather_Icon_Few_Clouds_2);
                    Weather_condition2.setText("구름이 약간 있음");
                }

                else if(obj_2.get("icon").equals("02n")){
                    System.out.println("구름약간 저녁");
                    add(Weather_Icon_Few_Clouds_2);
                    Weather_condition2.setText("구름 약간 있는 저녁");
                }

                else if(obj_2.get("icon").equals("50d")){
                    System.out.println("안개 낮");
                    add(Weather_Icon_Haze_2);
                    Weather_condition2.setText("안개");
                }

                else if(obj_2.get("icon").equals("50n")){
                    System.out.println("안개 저녁");
                    add(Weather_Icon_Haze_2);
                    Weather_condition2.setText("안개낀 저녁");
                }

                else if(obj_2.get("icon").equals("10d")){
                    System.out.println("비 낮");
                    add(Weather_Icon_Rain_2);
                    Weather_condition2.setText("비");
                }

                else if(obj_2.get("icon").equals("10n")){
                    System.out.println("비 저녁");
                    add(Weather_Icon_Rain_2);
                    Weather_condition2.setText("비 내리는 저녁");
                }

                else if(obj_2.get("icon").equals("09d")){
                    System.out.println("소나기 낮");
                    add(Weather_Icon_Shower_Rain_2);
                    Weather_condition2.setText("소나기");
                }

                else if(obj_2.get("icon").equals("09n")){
                    System.out.println("소나기 저녁");
                    add(Weather_Icon_Shower_Rain_2);
                    Weather_condition2.setText("소나기 내리는 저녁");
                }

                else if(obj_2.get("icon").equals("13d")){
                    System.out.println("눈 낮");
                    add(Weather_Icon_Snow_2);
                    Weather_condition2.setText("눈이 내립니다");
                }

                else if(obj_2.get("icon").equals("13n")){
                    System.out.println("눈  저녁");
                    add(Weather_Icon_Snow_2);
                    Weather_condition2.setText("눈 내리는 저녁");
                }

                else if(obj_2.get("icon").equals("11d")){
                    System.out.println("뇌우 낮");
                    add(Weather_Icon_Thunderstorm_2);
                    Weather_condition2.setText("뇌우");
                }

                else if(obj_2.get("icon").equals("11n")){
                    System.out.println("뇌우 저녁");
                    add(Weather_Icon_Thunderstorm_2);
                    Weather_condition2.setText("뇌우 치는 저녁");
                }

                else{
                    System.out.println("날씨 상태를 알수 없음");
                    add(Weather_Icon_N_A_2);
                    Weather_condition.setText("날씨 상태를 알 수 없습니다.");
                }

            }
            /*	날씨 상태 이미지  분류2		*/
            Weather_Icon_Broken_Clouds_2.setIcon(new ImageIcon("System/Images/Weather/Broken_Clouds.png"));
            Weather_Icon_Broken_Clouds_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Broken_Clouds_2.setBounds(631, 245, 291, 224);

            Weather_Icon_Clear_2.setIcon(new ImageIcon("System/Images/Weather/Clear.png"));
            Weather_Icon_Clear_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Clear_2.setBounds(631, 245, 291, 224);

            Weather_Icon_Clouds_2.setIcon(new ImageIcon("System/Images/Weather/Clouds.png"));
            Weather_Icon_Clouds_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Clouds_2.setBounds(631, 245, 291, 224);

            Weather_Icon_Few_Clouds_2.setIcon(new ImageIcon("System/Images/Weather/Few_Clouds.png"));
            Weather_Icon_Few_Clouds_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Few_Clouds_2.setBounds(631, 245, 291, 224);

            Weather_Icon_Haze_2.setIcon(new ImageIcon("System/Images/Weather/Haze.png"));
            Weather_Icon_Haze_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Haze_2.setBounds(631, 245, 291, 224);

            Weather_Icon_Rain_2.setIcon(new ImageIcon("System/Images/Weather/Rain.png"));
            Weather_Icon_Rain_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Rain_2.setBounds(631, 245, 291, 224);


            Weather_Icon_Shower_Rain_2.setIcon(new ImageIcon("System/Images/Weather/Shower_Rain.png"));
            Weather_Icon_Shower_Rain_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Shower_Rain_2.setBounds(631, 245, 291, 224);

            Weather_Icon_Snow_2.setIcon(new ImageIcon("System/Images/Weather/Snow.png"));
            Weather_Icon_Snow_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Snow_2.setBounds(631, 245, 291, 224);

            Weather_Icon_Thunderstorm_2.setIcon(new ImageIcon("System/Images/Weather/Thunderstorm.png"));
            Weather_Icon_Thunderstorm_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_Thunderstorm_2.setBounds(631, 245, 291, 224);

            Weather_Icon_N_A_2.setIcon(new ImageIcon("System/Images/Weather/N_A.png"));
            Weather_Icon_N_A_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Icon_N_A_2.setBounds(631, 245, 291, 224);

            JLabel Weather_Temperature_2 = new JLabel();
            String WT_2 = Weather_Temperature_2.getText();
            WT_2 = String.format("%.2f℃", temp_2);
            bf_2.close();
            Weather_Temperature_2.setHorizontalAlignment(SwingConstants.CENTER);
            Weather_Temperature_2.setForeground(Color.ORANGE);
            Weather_Temperature_2.setFont(new Font("맑은 고딕", Font.BOLD, 80));
            Weather_Temperature_2.setBounds(745, 472, 382, 118);
            Weather_Temperature_2.setText(WT_2);
            add(Weather_Temperature_2);

            Weather panel = new Weather();
            panel.setBounds(0, 0, 1234, 662);
            add(panel, BorderLayout.CENTER);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    class Weather extends JPanel{

        ImageIcon imageIcon = new  ImageIcon("System/Images/Weather/Weather_BackGround.png");
        Image image = imageIcon.getImage();

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
