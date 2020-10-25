package com.shannon.activiti2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @Auther: cm.w
 * @Date: 2019/6/8 16:52
 * @Description:流程实例激活或者挂起
 *
  act_ru_execution

 */
public class ActivitiProcessInstanceSuspendAndActive {
    public static void main(String[] args){
        //1.
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RepositoryService repositoryService = engine.getRepositoryService();

        //3.
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday")
                .singleResult();

        //4.是否挂起,挂起则激活,激活则挂起
        String processDefinitionId = processDefinition.getId();
        boolean flag = processDefinition.isSuspended();
        if(flag){
            repositoryService.activateProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义ID:"+processDefinitionId+"已经激活");
        }else {
            repositoryService.suspendProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义ID:"+processDefinitionId+"已经挂起");
        }

    }
}
