package com.shannon.activity1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * @Auther: cm.w
 * @Date: 2019/6/7 18:07
 * @Description:部署流程
 *  act_re_deployment  部署信息
    act_re_procdef     流程定义的一些信息
    act_ge_bytearray   流程定义的bpmn文件及png文件
 */
public class ActivitiDeployment {
    public static void main(String[] args){
        //1.创建ProcessEngine
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.得到RepositoryService实例
        RepositoryService service = engine.getRepositoryService();

        /*//3.进行部署
        Deployment deployment = service.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假流程")
                .deploy();

        //4.检验输出
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());*/

        /*InputStream inputStream = ActivitiDeployment.class.getClassLoader().getResourceAsStream("diagram/holidayBPMN2.zip");
        ZipInputStream stream = new ZipInputStream(inputStream);

        Deployment deploy = service.createDeployment()
                .addZipInputStream(stream)
                .name("请假流程2")
                .deploy();*/

        /*Deployment deployment = service.createDeployment()
                .addClasspathResource("diagram/userTask1.bpmn")
                .name("测试监听流程示例")
                .deploy();*/
    }
}
