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

@RestController
@RequestMapping("/fund")
public class FundController {

    @Resource(name = "moduleManager")
    private ModuleManager moduleManager;

    /**
     * <pre>
     * 申请A贷款，走module-1模块
     * 
     * url：http://localhost:8091/fund/applyA?name=Tom&age=20
     * </pre>
     */
    @RequestMapping(value = "/applyA", method = RequestMethod.GET)
    @ResponseBody
    public Object applyA(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        // 查找服务
        Module findModule = moduleManager.find("fund-module-1");
        // 得到具体模块
        Action<FundRequest, String> action = findModule.getAction("fundAAction");
        FundRequest fundRequest = new FundRequest();
        fundRequest.setName(name);
        fundRequest.setAge(age);
        // 执行Action，数据交互
        String orderString = action.execute(fundRequest);
        return orderString;
    }

    /**
     * <pre>
     * 申请B贷款，走module-2模块
     * url：http://localhost:8091/fund/applyB?name=jon&age=40
     * </pre>
     */
    @RequestMapping(value = "/applyB", method = RequestMethod.GET)
    @ResponseBody
    public Object applyB(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        // 查找服务
        Module findModule = moduleManager.find("fund-module-2");
        // 得到具体模块
        Action<FundRequest, String> action = findModule.getAction("fundBAction");
        FundRequest fundRequest = new FundRequest();
        fundRequest.setName(name);
        fundRequest.setAge(age);
        // 执行Action，数据交互
        String orderString = action.execute(fundRequest);
        return orderString;
    }

}
