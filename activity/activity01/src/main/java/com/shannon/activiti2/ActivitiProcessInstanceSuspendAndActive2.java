package com.shannon.activiti2;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import java.util.List;

/**
 * @Auther: cm.w
 * @Date: 2019/6/8 16:52
 * @Description:单个流程实例激活或者挂起
 *
  act_ru_execution

 */
public class ActivitiProcessInstanceSuspendAndActive2 {
    public static void main(String[] args){
        //1.
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RuntimeService runtimeService = engine.getRuntimeService();

        //3.
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("holiday")
                .singleResult();

        //4.是否挂起,挂起则激活,激活则挂起
        String processInstanceId = processInstance.getId();
        boolean flag = processInstance.isSuspended();
        if(flag){
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例ID:"+processInstanceId+"已经激活");
        }else {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例ID:"+processInstanceId+"已经挂起");
        }

        //测试一个任务处于挂起状态是否能执行(目前张三有任务,状态处于挂起)

        //得到TaskService对象
        TaskService taskService = engine.getTaskService();

        //根据流程定义的key和负责人assigner来实现任务列表查询
        //张三的任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .singleResult();


        taskService.complete(task.getId());//结果为:Cannot complete a suspended task

    }
}
