package com.shannon.activiti2;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import java.util.List;

/**
 * @Auther: cm.w
 * @Date: 2019/6/9 17:12
 * @Description:
 */
public class ActivitiHistoryQuery {
    public static void main(String[] args){
        //1.
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.
        HistoryService service = engine.getHistoryService();

        //3.
        HistoricActivityInstanceQuery historicQuery = service.createHistoricActivityInstanceQuery();

        //4.
        List<HistoricActivityInstance> list = historicQuery.processInstanceId("2501")
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .list();

        //5.
        for(HistoricActivityInstance instance : list){
            System.out.println(instance.getActivityId());
            System.out.println(instance.getActivityName());
            System.out.println(instance.getAssignee());
            System.out.println(instance.getProcessDefinitionId());
            System.out.println(instance.getProcessInstanceId());
            System.out.println("========================");
        }

    }
}
