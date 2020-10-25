package com.shannon.activity1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import java.util.List;

/**
 * @Auther: cm.w
 * @Date: 2019/6/8 11:53
 * @Description:
 *  act_hi_actinst     已完成的活动信息
    act_hi_identitylink   参与者信息
    act_hi_procinst   流程实例
    act_hi_taskinst   任务实例
    act_ru_identitylink   参与者信息
    act_ru_task  任务
 */
public class ActivitiTaskComplet {
    public static void main(String[] args){
        //1.创建ProcessEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.得到TaskService对象
        TaskService service = engine.getTaskService();

        //3.根据流程定义的key和负责人assigner来实现任务列表查询
        //张三的任务
        List<Task> taskList = service.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();

        //lisi的任务
        Task task1 = service.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("lisi")
                .singleResult();
        //wnagwu的任务
        Task task2 = service.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("wangwu")
                .singleResult();

        //4.完成任务
        //for(Task task:taskList){
            /*System.out.println("流程定义的ID:"+task.getProcessDefinitionId());
            System.out.println("任务ID:"+task.getId());
            System.out.println("任务名称:"+task.getName());
            System.out.println("任务任务负责人:"+task.getAssignee());*/
            //张三完成任务
            //service.complete(task.getId());
       // }

        //lisi完成任务
        //service.complete(task1.getId());

        //wangwu完成任务
        service.complete(task2.getId());


    }
}
