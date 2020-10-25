package com.shannon.activiti3;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cm.w
 * @Date: 2019/6/11 21:23
 * @Description:通过流程实例id测试流程变量[通过当前流程实例设置]
 */
public class ProcessVariableTest3 {
    public static void main(String[] args){
        //部署
        //1.
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

      /*  //2.
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday3.bpmn")
                .addClasspathResource("diagram/holiday3.png")
                .name("请假流程-流程变量")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());*/


        RuntimeService runtimeService = processEngine.getRuntimeService();

       //ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday3","000001");
        String processInstanceId = "2501";
        Holiday holiday = new Holiday();
        holiday.setNum(3F);
        runtimeService.setVariable(processInstanceId,"holiday",holiday);



    }
}
