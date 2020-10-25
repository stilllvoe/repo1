package com.shannon.activiti3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cm.w
 * @Date: 2019/6/10 16:29
 * @Description:流程启动实例,动态设置执行人
 */
public class ActivitiAssigneeUEL {
    public static void main(String[] args){
        //1.
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3.
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("assignee0","zhangsan");
        map.put("assignee1","lisi");
        map.put("assignee2","wangwu");

        //4.
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday2", "00001",map);

        //
        System.out.println(processInstance.getName()+"==="+processInstance.getBusinessKey());

    }
}
