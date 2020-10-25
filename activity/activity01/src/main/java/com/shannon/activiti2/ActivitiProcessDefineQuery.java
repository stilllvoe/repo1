package com.shannon.activiti2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import java.util.List;

/**
 * @Auther: cm.w
 * @Date: 2019/6/8 16:52
 * @Description:流程定义查询
 */
public class ActivitiProcessDefineQuery {
    public static void main(String[] args){
        //1.
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RepositoryService service = engine.getRepositoryService();

        //3.
        ProcessDefinitionQuery definitionQuery = service.createProcessDefinitionQuery();

        //4.设置条件查询流程
        List<ProcessDefinition> list = definitionQuery.processDefinitionKey("holiday")
                .orderByProcessDefinitionVersion()
                .desc()
                .list();


        for(ProcessDefinition pro : list){
            System.out.println("流程ID:"+pro.getId());
            System.out.println("流程KEY:"+pro.getKey());
            System.out.println("流程名称:"+pro.getName());
            System.out.println("流程版本号:"+pro.getVersion());
        };

    }
}
