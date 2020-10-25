package com.shannon.activiti3;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * @Auther: cm.w
 * @Date: 2019/6/11 21:23
 * @Description:通过任务ID测试流程变量[通过任务ID设置:任务一定是未结束的任务]
 */
public class ProcessVariableTest4 {
    public static void main(String[] args){
        //部署
        //1.
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

       /* //2.
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday3.bpmn")
                .addClasspathResource("diagram/holiday3.png")
                .name("请假流程-流程变量")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());*/


        /*RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday3","000001");*/

        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday3")
                .taskAssignee("zhangsan")
                .singleResult();

        Holiday holiday = new Holiday();
        holiday.setNum(3F);

        taskService.setVariable(task.getId(),"holiday",holiday);

    }
}
