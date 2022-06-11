package com.capensis.spring.lifecycle;

/**
 * @author wxg
 * @date 2022/3/8-9:05
 * @quotes 小不忍则乱大谋
 */
public class MyBook {
    public MyBook() {
        System.out.println("第一步 执行无参数构造创建 bean 实例");
    }

    private String oname;
    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用 set 方法设置属性值");
    };
    /**
     *  创建执行的初始化的方法
     */
    public void initMethod() {
        System.out.println("第三步 执行初始化的方法");
    }
    /**
     * 创建执行的销毁的方法
     */
    public void destroyMethod() {
        System.out.println("第五步 执行销毁的方法");
    }
}
