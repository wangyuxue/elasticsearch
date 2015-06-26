/**
 * 
 */
package com.baidu.regil.es.research.vo;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

/**
 * @author david.wang
 *
 */
public class User {
    
    /**
     * 
     */
    private static final String[] tmpName = new String[] {
        "zhangsan", "lisi", "wangwu", "zhaoliu", "renqi"
    };
    
    /**
     * id 无业务含义
     */
    private String id;

    /**
     * 用户名
     */
    private String name;
    
    /**
     * 年龄
     */
    private int age;
    
    /**
     * 工资
     */
    private double salary;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 地址
     */
    private String address;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        try {
            XContentBuilder doc = XContentFactory.jsonBuilder().startObject();
            doc.field("id", id);
            doc.field("name", this.name);
            doc.field("age", age);
            doc.field("salary", salary);
            doc.field("email", email);
            doc.field("address", address);
            doc.endObject();
            return doc.string();
        } catch (IOException e) {
            return id;
        }
    }
    
    public static User randomUser() {
        User user = new User();
        user.setId(String.valueOf(System.nanoTime()));
        user.setAddress("北京");
        user.setAge(new Random().nextInt(100));
        user.setEmail(UUID.randomUUID() + "@test.com");
        user.setName(tmpName[new Random().nextInt(4)]);
        user.setSalary(new Random().nextDouble());
        return user;
    }
    
    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        user.setAddress("北京");
        user.setAge(100);
        user.setEmail("test@test.com");
        user.setName("nihao");
        user.setSalary(1000.00);
        System.out.println(user);
        for (int i = 0; i < 100; ++i) {
            System.out.println(randomUser());
        }
    }
}
