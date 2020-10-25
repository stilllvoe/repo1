package com.shannon.activiti4;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * @Auther: cm.w
 * @Date: 2019/6/12 21:21
 * @Description:组任务归还
 */
public class GroupTaskBack {
    //1.部署流程
    /*public static void main(String[] args){

        //1.
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday4.bpmn")
                .addClasspathResource("diagram/holiday4.png")
                .name("请假流程-归还组任务")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }*/

    //2.启动流程
    /*public static void main(String[] args){
        //1.得到ProcesEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RuntimeService
        RuntimeService service = engine.getRuntimeService();

        //3.创建流程实例
        ProcessInstance processInstance = service.startProcessInstanceByKey("holiday4");

        //输出流程信息
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getBusinessKey());
        System.out.println(processInstance.getId());
    }*/

    //3.zhangsan 处理请假清单
    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskAssignee("zhangsan")
                .singleResult();

        if(task!=null){
            service.complete(task.getId());
        }
    }*/

    //4.查询组任务
    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        List<Task> taskList = service.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskCandidateUser("lisi")
                .list();

        for(Task task:taskList){
            System.out.println(task.getId());
            System.out.println(task.getAssignee());
            System.out.println(task.getName());
        }
    }*/

    //5.测试lisi拾取任务 /候选人变为任务人
    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = engine.getTaskService();

        String candidateUser = "lisi";

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskCandidateUser(candidateUser)
                .singleResult();

        if(null!=task){
           taskService.claim(task.getId(),candidateUser);
        }
    }*/

    //6.查询并归还任务
    public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = engine.getTaskService();

        String assignee = "lisi";

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskId("5002")
                .taskAssignee(assignee)
                .singleResult();

        if(null!=task){
            taskService.setAssignee(task.getId(),null);
        }
    }
}
