package com.testfan.javastudy.Day0416.Demo03;

import java.io.File;
import java.io.FileFilter;

/**
 * @author 孙珑瑜
 * @version 20210416
 * 创建过滤器FileFilter的实现类，
 * 重写过滤方法accept，
 * 自定义过滤规则
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()){
            return true;//返回true会将文件夹也放到file的数组中，继续递归
        }
        return pathname.getName().toLowerCase().endsWith(".java");
//        return false;
    }
}
