package com.testfan.javastudy;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20201224
 */
public class workoutstudy {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请在控制台输入字符：");
//        char c;
//        do {
//            c = (char) br.read();
//        }while (c != 'q');
//        Calendar cal = Calendar.getInstance();
//
//        int date = cal.get(Calendar.DATE);
//        int month = cal.get(Calendar.MONTH) + 1;
//        int year = cal.get(Calendar.YEAR);
//        cal.add(Calendar.MONTH, -3);
//        cal.add(Calendar.YEAR, -1);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String time = sdf.format(cal.getTime());
//        System.out.println(date);
//        System.out.println(month);
//        System.out.println(year);
//        System.out.println(time);


//        int dow = cal.get(Calendar.DAY_OF_WEEK);
//        int dom = cal.get(Calendar.DAY_OF_MONTH);////获取当前天数
//        int doy = cal.get(Calendar.DAY_OF_YEAR);
//
//        int first = cal.getActualMinimum(Calendar.DAY_OF_MONTH); //获取本月最小天数
//        int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //获取本月最大天数
//        System.out.println(first);
//        System.out.println(last);

//        System.out.println(dow);
//        System.out.println(dom);
//        System.out.println(doy);
        Map<String, String> currentday = currentday();
        String starttime = currentday.get("starttime");
        String lasttime = currentday.get("lasttime");
        System.out.println(starttime);
        System.out.println(lasttime);
    }

    public static Map<String, String> currentday() {
        Map<String,String> time = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        String year = Integer.toString(cal.get(Calendar.YEAR));//当前年
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);//当前月
        String firstday = Integer.toString(cal.getActualMinimum(Calendar.DAY_OF_MONTH)); //获取本月最小天数
        String lastday = Integer.toString(cal.getActualMaximum(Calendar.DAY_OF_MONTH)); //获取本月最大天数

        if (month.length() == 1) {
            String starttime = year +"-0"+ month +"-0"+ firstday;
            String lasttime = year +"-0"+ month +"-"+ lastday;
            time.put("starttime",starttime);
            time.put("lasttime",lasttime);

        } else {
            String starttime = year +"-"+ month +"-"+ firstday;
            String lasttime = year +"-"+ month +"-"+ lastday;
            System.out.println(starttime);
            System.out.println(lasttime);
        }
        return time;
    }
}
