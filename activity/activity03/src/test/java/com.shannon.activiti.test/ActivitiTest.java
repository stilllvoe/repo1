package com.shannon.activiti.test;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.shannon.activiti.config.SecurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.model.payloads.ClaimTaskPayload;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: cm.w
 * @Date: 2019/6/15 11:00
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {
    @Autowired
    private ProcessRuntime processRuntime;//流程定义相关操作
    @Autowired
    private TaskRuntime taskRuntime;//任务相关操作


    @Autowired
    private SecurityUtil securityUtil;

    //查询流程定义
    @Test
    public void testDefinition(){
        securityUtil.logInAs("salaboy");

        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));

        System.out.println(processDefinitionPage.getTotalItems());
        for(ProcessDefinition pd:processDefinitionPage.getContent()){
            System.out.println(pd);
        }
    }

    //启动流程
    @Test
    public void testStart(){
        securityUtil.logInAs("salaboy");
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder.start().withProcessDefinitionKey("team01").build());
        System.out.println("流程ID:"+processInstance.getId());
    }

    //查询任务
    @Test
    public void testTask(){
        securityUtil.logInAs("ryandawsonuk");

        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));

        if(tasks.getTotalItems()>0){
            for(Task task:tasks.getContent()){
                System.out.println("任务:"+task);
            }
        }
    }

    //拾取任务
    @Test
    public void testClaimAndComplete(){
        securityUtil.logInAs("ryandawsonuk");

        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));

        if(tasks.getTotalItems()>0){
            for(Task task:tasks.getContent()){
                System.out.println("任务:"+task);
                //拾取任务
                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
                //执行任务
                taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());

            }
        }

        //再次查询
        Page<Task> tasks2 = taskRuntime.tasks(Pageable.of(0, 10));

        if(tasks2.getTotalItems()>0){
            for(Task task:tasks2.getContent()){
                System.out.println("任务:"+task);
            }
        }
    }

    @Test
    public void testClaimAndComplete2(){
        securityUtil.logInAs("erdemedeiros");

        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));

        if(tasks.getTotalItems()>0){
            for(Task task:tasks.getContent()){
                System.out.println("任务:"+task);
                //拾取任务
                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
                //执行任务
                taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());

            }
        }

        //再次查询
        Page<Task> tasks2 = taskRuntime.tasks(Pageable.of(0, 10));

        if(tasks2.getTotalItems()>0){
            for(Task task:tasks2.getContent()){
                System.out.println("任务:"+task);
            }
        }
    }

}
