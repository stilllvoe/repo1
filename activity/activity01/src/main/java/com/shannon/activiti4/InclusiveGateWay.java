package com.shannon.activiti4;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cm.w
 * @Date: 2019/6/13 16:58
 * @Description:包含网关:满足条件的都要走
 */
public class InclusiveGateWay {
    //1.部署流程
    /*public static void main(String[] args){
        //1.
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday8.bpmn")
                //.addClasspathResource("diagram/holiday4.png")
                .name("体检流程")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }
*/
    //2.启动流程
    /*public static void main(String[] args){
        //1.得到ProcesEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RuntimeService
        RuntimeService service = engine.getRuntimeService();

        Integer userType = 2;//1
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userType",userType);
        //3.创建流程实例
        ProcessInstance processInstance = service.startProcessInstanceByKey("holiday8",map);

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
                .processDefinitionKey("holiday8")
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
                .processDefinitionKey("holiday8")
                .taskAssignee("lisi")
                .singleResult();

        service.complete(task.getId());

    }*/

    //wangwu 处理待办
    public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday8")
                .taskAssignee("wangwu")
                .singleResult();

        service.complete(task.getId());

    }

    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday7")
                .taskAssignee("maliu")
                .singleResult();

        service.complete(task.getId());

    }*/

    /*public static void main(String[] args){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService service = engine.getTaskService();

        Task task = service.createTaskQuery()
                .processDefinitionKey("holiday7")
                .taskAssignee("zhaojiu")
                .singleResult();

        service.complete(task.getId());

    }*/

}
