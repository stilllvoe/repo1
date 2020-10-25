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
 * @Description:启动流程,测试流程变量(全局)[启动的时候设置]
 */
public class ProcessVariableTest {
    public static void main(String[] args){
        //部署
        /*//1.
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday3.bpmn")
                .addClasspathResource("diagram/holiday3.png")
                .name("请假流程-流程变量")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());*/

        //启动
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        Holiday holiday = new Holiday();//如果不实现serializable;报错:couldn't find a variable type that is able to serialize com.shannon.activiti3.Holiday@2bac9ba
        holiday.setNum(5F);//1F
        Map<String,Object>  map = new HashMap<String,Object>();
        map.put("holiday",holiday);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday3","000002",map);

        System.out.println(processInstance.getName());
        System.out.println(processInstance.getId());

        //zhangsan流程
        /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday3")
                .taskAssignee("zhangsan")
                .singleResult();

        taskService.complete(task.getId());*/

        //lisi流程
        /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday3")
                .taskAssignee("lisi")
                .singleResult();

        taskService.complete(task.getId());//当请假天数>=3时,流程直接到了人事存档*/

        //maliu
        /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday3")
                .taskAssignee("maliu")
                .singleResult();

        taskService.complete(task.getId());*/

        /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday3")
                .taskAssignee("wangwu")
                .singleResult();

        taskService.complete(task.getId());*/
    }
}
