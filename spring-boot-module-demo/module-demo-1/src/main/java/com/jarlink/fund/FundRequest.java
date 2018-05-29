package com.jarlink.fund;

/**
 * <pre>
 * 
 * <li> module-demo-1与module-demo-2 都有使用该类
 * <li> 虽然代码写了两份，但jvm 根据双亲委派模式只会加载其中一份，由子模块容器的父容器的类加载器加载
 * <li> module-demo-1与module-demo-2 以及module-demo-web 用的都是父容器加载的那份
 * <li> 所以不能放到这里面 moduleConfig.setOverridePackages(overridePackages);
 * 
 * </pre>
 * 
 * @author onlyone
 */
public class FundRequest {

    private String name;
    private int    age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
