package com.shannon.activiti2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import java.util.List;

/**
 * @Auther: cm.w
 * @Date: 2019/6/8 16:52
 * @Description:启动流程实例,添加业务主键
 *
  act_ru_execution

 */
public class ActivitiBusinessKeyAdd {
    public static void main(String[] args){
        //1.
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RuntimeService runtimeService = engine.getRuntimeService();

        //3.启动流程实例,标识业务主键
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", "0001");

        //4.输出
        System.out.println("业务主键:"+processInstance.getBusinessKey());

    }
}
