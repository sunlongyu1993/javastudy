package com.testfan.javastudy.Day0422.Demo03;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 孙珑瑜
 * @version 20210422
 * 文本排序
 * 读入写出
 */
public class Demo03Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            HashMap<String, String> maps = new HashMap<>();
//        2、创建字符缓冲输入流
            br = new BufferedReader(new FileReader("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\出师表.txt"));
//        3、创建字符缓冲输入流
            bw = new BufferedWriter(new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\2.txt"));
//        4、使用字符缓冲输入流的readline方法，逐行读取文本
            String line;
            while ((line = br.readLine()) != null) {
                //5、对读取的文本进行切割，获取行中的序号和文本内容
                String[] arr = line.split("\\.");
//            System.out.println("key:"+arr[0]);
//            System.out.println("value:"+arr[1]);
                //6、把切割好的序号和文本存储到map集合中
                maps.put(arr[0], arr[1]);//map是有序的，key可以自动排序1,2,3
            }
            //7、遍历map集合，获取每一个键值对
            for (String key : maps.keySet()) {
                String value = maps.get(key);
                //8、把每一个键值对，拼接为一个文本行
                line = key + "." + value;
                bw.write(line);//9、把拼接好的文本，使用字符缓冲输入流的write，写入到文件中
                bw.newLine();
            }

//            List<String> list = new ArrayList<>();
//            List<String> newList = list.stream().map(s -> s.toLowerCase()).filter( s -> s.startsWith("l")).collect(Collectors.toList());
//            for (String s : list) {
//                String tmp = s.toLowerCase();
//                if(tmp.startsWith("l")){
//                    newList.add(tmp);
//                }
//            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (Objects.nonNull(bw)) {
                bw.close();
            }
            if (Objects.nonNull(br)) {
                br.close();
            }
        }

    }
}
