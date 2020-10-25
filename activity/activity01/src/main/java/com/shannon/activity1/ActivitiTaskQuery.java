package com.shannon.activity1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import java.util.List;

/**
 * @Auther: cm.w
 * @Date: 2019/6/7 23:36
 * @Description:任务查询
 */
public class ActivitiTaskQuery {
    public static void main(String[] args){
        //1.创建ProcessEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.得到TaskService对象
        TaskService service = engine.getTaskService();

        //3.根据流程定义的key和负责人assigner来实现任务列表查询
        List<Task> taskList = service.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();

        for(Task task:taskList){
            System.out.println("流程定义的ID:"+task.getProcessDefinitionId());
            System.out.println("任务ID:"+task.getId());
            System.out.println("任务名称:"+task.getName());
            System.out.println("任务任务负责人:"+task.getAssignee());
        }
        //4.遍历输入任务信息
    }

}
