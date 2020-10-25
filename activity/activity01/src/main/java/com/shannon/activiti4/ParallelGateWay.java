package com.shannon.activiti4;

import com.shannon.activiti3.Holiday;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * @Auther: cm.w
 * @Date: 2019/6/13 16:58
 * @Description:平行网关 :都要走
 */
public class ParallelGateWay {
    //1.部署流程
    /*public static void main(String[] args){
        //1.
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday7.bpmn")
                //.addClasspathResource("diagram/holiday4.png")
                .name("请假流程")
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
        ProcessInstance processInstance = service.startProcessInstanceByKey("holiday7");

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
                .processDefinitionKey("holiday7")
                .taskAssignee("zhangsan")
                .singleResult();

        if(task!=null){
            service.complete(task.getId());
        }
    }*/

    //4.lisi 处理请假清单
    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday7")
                .taskAssignee("lisi")
                .singleResult();

        service.complete(task.getId());

    }*/

    //wangwu 处理待办
    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday7")
                .taskAssignee("wangwu")
                .singleResult();

        service.complete(task.getId());

    }*/

    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday7")
                .taskAssignee("maliu")
                .singleResult();

        service.complete(task.getId());

    }*/

    public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday7")
                .taskAssignee("zhaojiu")
                .singleResult();

        service.complete(task.getId());

    }

}
