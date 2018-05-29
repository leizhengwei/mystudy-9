package com.jarlink.fund.action;

import org.springframework.stereotype.Component;

import com.alipay.jarslink.api.Action;
import com.jarlink.fund.FundRequest;

/**
 * <pre>
 * 贷款A执行类
 * 
 * 注意：由于类加载机制为双亲委派模式，如果两个模块的“包名+类名”完全一致，则需要走覆盖机制，由当前模块的类加载器加载
 * </pre>
 * 
 * @author onlyone
 */
@Component
public class FundAction implements Action<FundRequest, String> {

    /**
     * 贷款A业务，要求年龄满足18
     */
    public String execute(FundRequest fundRequest) {
        if (fundRequest.getAge() > 18) {
            return "恭喜" + fundRequest.getName() + ",你已成年，可以申请贷款A！";
        }
        return "抱歉" + fundRequest.getName() + ",你还未成年，不可以申请贷款A！";
    }

    public String getActionName() {
        return "fundAAction";
    }

}
