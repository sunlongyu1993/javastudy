package com.testfan.MavenStudy.apistudy.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AesEncryption extends AbstractFunction {
    //自定义function描述
    private static final List desc =new LinkedList();
    static {
        desc.add("待加密的字符串");
        desc.add("私钥");
        desc.add("加解密方式：加密encode，解密decode");
    }
    //function名称
    private static final String KEY="__AesEncryption";//2个下划线加类的名称
    private static final int MAX_PARA_COUNT=3;//参数的个数最大是3个
    private static final int MIN_PARA_COUNT=3;//参数的个数最小是3个，3个参数都是必填项
    //传入参数的值
    private Object[] values;

    @Override//返回参数的各项描述
    public List<String> getArgumentDesc() {
        return desc;
    }
    @Override//获取函数的名称
    public String getReferenceKey() {
        return KEY;
    }
    @Override
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        checkMinParameterCount(collection,MIN_PARA_COUNT);//检查参数的个数
        values= collection.toArray();//将值存入类变量中
    }
    @Override//函数真正要实现的代码
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        String encodeOrDecodeParam = ((CompoundVariable) values[2]).execute().trim();//加解密方式
        String StrParam =((CompoundVariable) values[0]).execute().trim();//待加密的字符串
        String KeyParam = ((CompoundVariable) values[1]).execute().trim();//私钥
        String result ="";

        if(encodeOrDecodeParam.equalsIgnoreCase("encode")){//加密
            byte[] crypted = null;
            try {
                SecretKeySpec skey = new SecretKeySpec(KeyParam.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, skey);
                crypted = cipher.doFinal(StrParam.getBytes());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            result= new String(Base64.encodeBase64(crypted));
        }
        else if(encodeOrDecodeParam.equalsIgnoreCase("decode")){//解密
            byte[] output = null;
            try {
                SecretKeySpec skey = new SecretKeySpec(KeyParam.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, skey);
                output = cipher.doFinal(Base64.decodeBase64(StrParam));//待加密字符串
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            result= new String(output);
        }
        else {
            result="加解密方式不对";
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
