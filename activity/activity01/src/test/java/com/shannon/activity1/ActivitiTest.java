package com.shannon.activity1;

import static org.junit.Assert.assertTrue;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ActivitiTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){

        assertTrue( true );
    }

    /**
     * 建表方式1
     */
    @Test
    public void testCreateTable(){
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = configuration.buildProcessEngine();
    }

    /**
     * 建表方式2
     */
    @Test
    public void testCreateTable2(){
        //创建默认ProcessEngine条件：1.配置文件名必须是：activiti.cfg.xml；
        // 2.2.org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration的id名必须是processEngineConfiguration
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

    }
}
