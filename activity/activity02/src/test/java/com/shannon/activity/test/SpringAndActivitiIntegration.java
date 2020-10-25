package com.shannon.activity.test;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: cm.w
 * @Date: 2019/6/14 17:56
 * @Description:整合是否成功:1.数据库是否有表;2.是否能输出对象RepositoryService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:activiti-spring.xml")
public class SpringAndActivitiIntegration {
    @Autowired
    RepositoryService repositoryService;

    @Test
    public void testSpringAndActivitiIntegration(){
        System.out.println(repositoryService);
    }
}
