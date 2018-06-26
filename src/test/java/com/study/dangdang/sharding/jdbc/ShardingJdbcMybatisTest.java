package com.study.dangdang.sharding.jdbc;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.dangdang.sharding.jdbc.entity.Student;
import com.study.dangdang.sharding.jdbc.entity.User;
import com.study.dangdang.sharding.jdbc.service.StudentService;
import com.study.dangdang.sharding.jdbc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/spring-database.xml",
        "classpath*:config/spring/spring-sharding.xml" })
public class ShardingJdbcMybatisTest {

    @Resource
    public UserService userService;
    
    @Resource
    public StudentService studentService;

    @Test
    public void testUserInsert() {
        User u = new User();
        u.setUserId(1);
        u.setAge(25);
        u.setName("啊啊啊啊啊");
        Assert.assertEquals(userService.insert(u), true);
    }
    
    @Test
    public void testStudentInsert() {
        for(int i=0;i<100;i++) {
            Student student = new Student();
            student.setStudentId(21);
            student.setAge(21);
            student.setName("aaa");
            Assert.assertEquals(studentService.insert(student), true);
        }
    }

    @Test
    public void testFindAll(){
        List<User> users = userService.findAll();
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println("输出结果，姓名是："+u.getName());
            }
        }
    }
    
    @Test
    public void testSQLIN(){
        List<User> users = userService.findByUserIds(Arrays.asList(12,14,17));
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }
    
    @Test
    public void testTransactionTestSucess(){
        userService.transactionTestSucess();
    }
    
    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException{
        userService.transactionTestFailure();
    }
    
    
}
