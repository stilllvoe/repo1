package com.shannon.activiti2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Auther: cm.w
 * @Date: 2019/6/9 10:28
 * @Description:
 */
public class ActivitiBPMNFileQuery {
    public static void main(String[] args) throws Exception{
        //1.得到ProcessEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        //2.得到RepositoryService对象
        RepositoryService service = engine.getRepositoryService();

        //3.得到查询器
        ProcessDefinitionQuery holidayQuery = service.createProcessDefinitionQuery()
                .processDefinitionKey("holiday");

        //4.设置查询条件,查到想要的流程定义,得到流程部署id
        ProcessDefinition processDefinition = holidayQuery.singleResult();
        String deploymentId = processDefinition.getDeploymentId();

        //5.通过RepositoryService对象,得到图片和bpmn文件信息
        InputStream imgIs = service.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream fileIs = service.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        OutputStream imgOs = new FileOutputStream("E:/"+processDefinition.getDiagramResourceName());
        OutputStream fileOs = new FileOutputStream("E:/"+processDefinition.getResourceName());
        //6.输入流和输出流的转换
        IOUtils.copy(imgIs, imgOs);
        IOUtils.copy(fileIs,fileOs);

        imgOs.close();
        fileOs.close();
        imgIs.close();
        fileIs.close();

    }
}
