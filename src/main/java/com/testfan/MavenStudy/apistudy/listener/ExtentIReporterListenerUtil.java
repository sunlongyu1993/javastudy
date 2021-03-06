package com.testfan.MavenStudy.apistudy.listener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.TestAttribute;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Description:
 * Author: 沙陌
 * Date: 2019-01-15
 */
public class ExtentIReporterListenerUtil implements IReporter {
    //生成的路径以及文件名
    private static final String OUTPUT_FOLDER = "report/";//生成的报告的目录
    private static final String FILE_NAME = "index.html";//生成的报告的文件名称

    private ExtentReports extent;

    /**
     *生成报告
     * @param xmlSuites
     * @param suites
     * @param outputDirectory 生成报告的目录
     */
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)  {
        init();
        boolean createSuiteNode = false;
        if(suites.size()>1){
            // 获取测试结果信息
            createSuiteNode=true;
        }
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            //如果suite里面没有任何用例，直接跳过，不在报告里生成
            if(result.size()==0){
                continue;
            }
            //统计suite下的成功、失败、跳过的总用例数——将其转化成可以解析的结果
            int suiteFailSize=0;
            int suitePassSize=0;
            int suiteSkipSize=0;
            ExtentTest suiteTest=null;
            //存在多个suite的情况下，在报告中将同一个一个suite的测试结果归为一类，创建一级节点。
            if(createSuiteNode){
                suiteTest = extent.createTest(suite.getName()).assignCategory(suite.getName());
            }
            boolean createSuiteResultNode = false;
            if(result.size()>1){
                createSuiteResultNode=true;
            }
            for (ISuiteResult r : result.values()) {
                ExtentTest resultNode;
                ITestContext context = r.getTestContext();
                if(createSuiteResultNode){
                    //没有创建suite的情况下，将在SuiteResult的创建为一级节点，否则创建为suite的一个子节点。
                    if( null == suiteTest){
                        resultNode = extent.createTest(r.getTestContext().getName());
                    }else{
                        resultNode = suiteTest.createNode(r.getTestContext().getName());
                    }
                }else{
                    resultNode = suiteTest;
                }
                if(resultNode != null){
                    resultNode.getModel().setName(suite.getName()+" : "+r.getTestContext().getName());
                    if(resultNode.getModel().hasCategory()){
                        resultNode.assignCategory(r.getTestContext().getName());
                    }else{
                        resultNode.assignCategory(suite.getName(),r.getTestContext().getName());
                    }
                    resultNode.getModel().setStartTime(r.getTestContext().getStartDate());
                    resultNode.getModel().setEndTime(r.getTestContext().getEndDate());
                    //统计SuiteResult下的数据
                    int passSize = r.getTestContext().getPassedTests().size();
                    int failSize = r.getTestContext().getFailedTests().size();
                    int skipSize = r.getTestContext().getSkippedTests().size();
                    suitePassSize += passSize;
                    suiteFailSize += failSize;
                    suiteSkipSize += skipSize;
                    if(failSize>0){
                        resultNode.getModel().setStatus(Status.FAIL);
                    }
                    resultNode.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;",passSize,failSize,skipSize));
                }
                buildTestNodes(resultNode,context.getFailedTests(), Status.FAIL);
                buildTestNodes(resultNode,context.getSkippedTests(), Status.SKIP);
                buildTestNodes(resultNode,context.getPassedTests(), Status.PASS);
            }
            if(suiteTest!= null){
                suiteTest.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;",suitePassSize,suiteFailSize,suiteSkipSize));
                if(suiteFailSize>0){
                    suiteTest.getModel().setStatus(Status.FAIL);
                }
            }

        }
//        for (String s : Reporter.getOutput()) {
//            extent.setTestRunnerOutput(s);
//        }

        extent.flush();//刷新一下，生成报告

        String REPORT_PATH="report/index.html";//读取report目录下的index.html文件
        Document html;

        try {
            html = Jsoup.parse(new File(REPORT_PATH), "UTF-8");
            //获取css的连接替换成本地
            Element linkCss=html.select("link").get(2);
            linkCss.attr("href","extent.css");
            //获取js的连接替换成本地
            Element scriptJs=html.select("script").get(1);
            scriptJs.attr("src", "extent.js");
            FileOutputStream fos = new FileOutputStream(REPORT_PATH, false);
            fos.write(html.html().getBytes());
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void init() {
        //判断存在测试报告的文件夹是否存在，如果不存在的话进行创建
        File reportDir= new File(OUTPUT_FOLDER);
        if(!reportDir.exists()&& !reportDir .isDirectory()){
            reportDir.mkdir();
        }
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        // 设置静态文件的DNS
        //怎么样解决cdn.rawgit.com访问不了的情况
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        htmlReporter.config().setDocumentTitle("接口自动化测试报告");//报告title
        htmlReporter.config().setReportName("接口自动化测试报告");//报告名称
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    private void buildTestNodes(ExtentTest extenttest, IResultMap tests, Status status) {
        //存在父节点时，获取父节点的标签
        String[] categories=new String[0];
        if(extenttest != null ){
            List<TestAttribute> categoryList = extenttest.getModel().getCategoryContext().getAll();
            categories = new String[categoryList.size()];
            for(int index=0;index<categoryList.size();index++){
                categories[index] = categoryList.get(index).getName();
            }
        }

        ExtentTest test;

        if (tests.size() > 0) {
            //调整用例排序，按时间排序
            Set<ITestResult> treeSet = new TreeSet<ITestResult>(new Comparator<ITestResult>() {
                @Override
                public int compare(ITestResult o1, ITestResult o2) {
                    return o1.getStartMillis()<o2.getStartMillis()?-1:1;
                }
            });
            treeSet.addAll(tests.getAllResults());
            //测试用例名称的处理
            //ITestResult 当前某一个测试用例的结果
            //treeSet 是所有的测试结果
            for (ITestResult result : treeSet) {
                // 获取测试用例的参数
                //参数指的是：传入测试用例的 测试用例名称：String casename, 修改的路径：String path, 以及修改的值String value
                Object[] parameters = result.getParameters();
                String name="";
                //如果有参数，则使用参数的toString组合代替报告中的name
//                for(Object param:parameters){
//                    name+=param.toString();
//                }
                if (parameters.length>0) {//判断数组是否大于0，大于0则有参数
                    name=parameters[0].toString();//将第一个参数赋值给name,作为测试报告上显示的测试用例名称
                }
                if(name.length()>0){
//                	name=
////                    if(name.length()>50){
////                        name= name.substring(0,49)+"...";
////                    }

                }// 如果方法的描述不为空,说明测试用例中的描述不为空
                else if (result.getMethod().getDescription()!=null) {
                    // 将测试用例中的描述赋值给name,作为测试报告上显示的测试用例名称
                    name=result.getMethod().getDescription();
                }
                else {
                    // 如果上述都不满足，就获取测试用例中测试方法的名称，作为测试报告上显示的测试用例名称
                    name = result.getMethod().getMethodName();
                }

                if(extenttest==null){
                    test = extent.createTest(name);
                }else{
                    //作为子节点进行创建时，设置同父节点的标签一致，便于报告检索。
                    test = extenttest.createNode(name).assignCategory(categories);
                }
                //test.getModel().setDescription(description.toString());
                //test = extent.createTest(result.getMethod().getMethodName());
                for (String group : result.getMethod().getGroups()){
                    test.assignCategory(group);
                }

                List<String> outputList = Reporter.getOutput(result);
                for(String output:outputList){
                    //将用例的log输出报告中
                    test.debug(output);
                }
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}





