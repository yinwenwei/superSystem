package com.srqy.supersystem;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.srqy.supersystem.manager.user.mapper.UserMapper;
import com.srqy.supersystem.manager.user.pojo.User;
import com.srqy.supersystem.tools.Share;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        User user = userMapper.selectById("20");
        System.out.println(user);
    }

    //=======================================baseMapper方法测试
    @Test
    public void insert(){
        User user = new User();
        user.setId("ce123");
        user.setName("测试BaseMapper");
        int count = userMapper.insert(user);
        System.out.println(count);
    }

    //多个id查询
    @Test
    public void selectBatchIds(){
        List<String> ids = Arrays.asList("17834","17835");
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);
    }

    //mapper键值对属性条件  键为数据库列名 都是 =
    @Test
    public void selectByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


    ///======================================QueryWrapper条件构造器
    //条件构造器查询   queryWarpper中带有多种方法
    @Test
    public void selectList(){
        QueryWrapper<User> queryWarpper = new QueryWrapper<>();
//        queryWarpper.eq("name","张三");
        queryWarpper.like("name","三");
        List<User> users = userMapper.selectList(queryWarpper);
        users.forEach(System.out::println);
    }

    //函数或子查询
    @Test
    public void selectByWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //apply,函数查询
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')","2019-02-12");
        //inSql 子查询  sql打印: and fid in (select id from user where name like '王%')
        queryWrapper.inSql("fid","select id from user where name like '王%'");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


    //查询指定列
    @Test
    public void selectWrapper2(){
        QueryWrapper<User> queryWarpper = new QueryWrapper<>();
        queryWarpper.select("id","name").like("name","张");
        List<User> users = userMapper.selectList(queryWarpper);
        users.forEach(System.out::println);

    }

    //忽略指定列
    @Test
    public void selectWrapper3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(User.class,info->!info.getColumn().equals("orgid") && !info.getColumn().equals("name"));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //查询条件 判断 是否进入条件
    @Test
    public void selectWrapper4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper每个方法都有condititon,默认为true, true 带条件 ,false 不带条件
        String name = "张";
        queryWrapper.like(!Share.isEmpty(name),"name",name);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //使用实体传参,默认都是 = ,自动判断非空  ,转换操作符需要在属性上定义注解
    @Test
    public void selectWrapper5(){
        User user = new User();
        user.setName("张三");
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().setEntity(user);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 按照直属上级分组,查询每组的平均年龄,最大年龄,最小年龄
     * 并且只取年龄总和小于500的组
     *
     * selectMaps返回Map 键为属性,Object为值 当指定列时,其他属性不会显示
     */
    @Test
    public void selectMaps(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("avg(age) avgAge","max(age) maxAge","min(age) minAge")
                .groupBy("pid").having("sum(avg)<{0}",500);

        //该方法只返回查询的列名,不会出现用对象接收(查询指定列是null的情况)
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    /**
     * selectObjs方法只会返回第一列
     */
    @Test
    public void selectObjs(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name").like("name","张三");

        List<Object> objects = userMapper.selectObjs(queryWrapper);

        //输出情况:  只返回 id 的值
    }

    /**
     * selectCount方法查询总记录数
     */
    @Test
    public void selectCount(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","张三");

        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println("总记录数:"+count);
    }

    /**
     * selectOne方法只会查询一个对象或null,超出则报错
     */
    @Test
    public void selectOne(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","张三");

        User user = userMapper.selectOne(queryWrapper);
        System.out.println("selectOne方法: "+user);
    }

    //=================================lambdaWrapper条件构造器
    @Test
    public void selectLambda(){
//        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.like(User::getName,"三").lt(User::getId,"50");
        //where name like '%三%' and id < 50
        List<User> users = userMapper.selectList(lambda);
    }

    /**
     * 名字为张姓并且 (状态小于0或手机号不为空)
     */
    @Test
    public void selectLambda2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.likeRight(User::getName,"王")
           .and(lqw->lqw.lt(User::getStatus,0).or().isNotNull(User::getPhone));
        //sql打印: where name like '张%' and (status<0 or phone is not null)
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
    }

    /**
     * 3.0.7新增条件构造器
     */
   /* @Test
    public void selectLambda2(){
        LambdaQueryChainWrapper<User> queryChainWrapper = new LambdaQueryChainWrapper<User>(userMapper);
       List<User> list =  queryChainWrapper.likeRight(User::getName,"王")
                .and(lqw->lqw.lt(User::getStatus,0).or().isNotNull(User::getPhone)).list();
        //sql打印: where name like '张%' and (status<0 or phone is not null)
    }*/

}
