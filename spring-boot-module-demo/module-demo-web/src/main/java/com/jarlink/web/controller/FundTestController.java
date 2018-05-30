package com.jarlink.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleManager;
import com.jarlink.fund.FundRequest;

/**
 * <pre>
 * 主要是为了测试jarslink com.alipay.jarslink.api.impl.SpringModule#doActionWithinModuleClassLoader，不指定上下文的类加载器会不会有问题
 * @author onlyone
 * </pre>
 */
@RestController
@RequestMapping("/fundtest")
public class FundTestController {

    @Resource(name = "moduleManager")
    private ModuleManager moduleManager;

    /**
     * <pre>
     * 申请A贷款，走module-1模块
     * 
     * url：http://localhost:8091/fundtest/applyA?name=Tom&age=20
     * </pre>
     */
    @RequestMapping(value = "/applyA", method = RequestMethod.GET)
    @ResponseBody
    public Object applyA(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        // 查找服务
        Module findModule = moduleManager.find("fund-module-1");

        FundRequest fundRequest = new FundRequest();
        fundRequest.setName(name);
        fundRequest.setAge(age);
        // 执行Action，数据交互
        String orderString = findModule.doAction("fundAAction", fundRequest);
        return orderString;
    }

    /**
     * <pre>
     * 申请B贷款，走module-2模块
     * url：http://localhost:8091/fundtest/applyB?name=jon&age=40
     * </pre>
     */
    @RequestMapping(value = "/applyB", method = RequestMethod.GET)
    @ResponseBody
    public Object applyB(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        // 查找服务
        Module findModule = moduleManager.find("fund-module-2");
        FundRequest fundRequest = new FundRequest();
        fundRequest.setName(name);
        fundRequest.setAge(age);
        // 执行Action，数据交互
        String orderString = findModule.doAction("fundBAction", fundRequest);
        return orderString;
    }

}
