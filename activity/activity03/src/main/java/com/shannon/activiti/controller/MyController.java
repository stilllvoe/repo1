package com.shannon.activiti.controller;

import com.shannon.activiti.config.SecurityUtil;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.channels.Pipe;

/**
 * @Auther: cm.w
 * @Date: 2019/6/15 13:10
 * @Description:
 */
@RestController
public class MyController {
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private SecurityUtil securityUtil;

    @RequestMapping("/hello")
    public void testHello(){
        //securityUtil.logInAs("ryandawsonuk");

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
