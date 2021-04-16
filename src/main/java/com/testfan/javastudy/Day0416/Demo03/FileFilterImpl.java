package com.testfan.javastudy.Day0416.Demo03;

import java.io.File;
import java.io.FileFilter;

/**
 * @author 孙珑瑜
 * @version 20210416
 * 创建过滤器FileFilter的实现类，重写过滤方法accept，定义过滤规则
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return true;
    }
}
