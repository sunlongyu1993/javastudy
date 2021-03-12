package com.testfan.javastudy.Day0311;

import com.google.inject.internal.util.$SourceProvider;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 孙珑瑜
 * dateformat 方法
 */
public class Demo03dateformat {
    public static void main(String[] args) throws ParseException {
//        demo01();
        demo02();
    }
    public static void demo01(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);//2021年03月12日 12时29分56秒

    }
    public static void demo02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date parse = sdf.parse("2021年03月12日 12时29分56秒");
        System.out.println(parse);
    }
}
