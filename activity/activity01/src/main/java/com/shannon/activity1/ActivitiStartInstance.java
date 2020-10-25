package com.shannon.activity1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @Auther: cm.w
 * @Date: 2019/6/7 22:57
 * @Description:启动流程实例
 * 背后影响的表：
 *      act_hi_actinst     已完成的活动信息
        act_hi_identitylink   参与者信息
        act_hi_procinst   流程实例
        act_hi_taskinst   任务实例
        act_ru_execution   执行表
        act_ru_identitylink   参与者信息
        act_ru_task  任务
 */
public class ActivitiStartInstance {
    public static void main(String[] args){
        //1.得到ProcesEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RuntimeService
        RuntimeService service = engine.getRuntimeService();

        //3.创建流程实例
        ProcessInstance processInstance = service.startProcessInstanceByKey("holiday");

        //输出流程信息
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getBusinessKey());
        System.out.println(processInstance.getId());
    }

}
