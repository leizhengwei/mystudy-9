package com.jarlink.web.jarslink;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;

public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {

    public ModuleRefreshSchedulerImpl(ModuleLoader moduleLoader, ModuleManager moduleManager){
        super.setModuleLoader(moduleLoader);
        super.setModuleManager(moduleManager);
    }

    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return ImmutableList.of(buildModuleConfig_1(), buildModuleConfig_2());
    }

    public static ModuleConfig buildModuleConfig_1() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("META-INF/module-demo-1-0.0.1.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("fund-module-1");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0");
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        moduleConfig.addScanPackage("com.jarlink.fund");
        // 如果子模块的类与其他子模块有冲突，需要引入覆盖机制，由当前子模块的类加载器来加载
        List<String> overridePackages = new ArrayList<String>();
        overridePackages.add("com.jarlink.fund.action");
        moduleConfig.setOverridePackages(overridePackages);

        return moduleConfig;
    }

    public static ModuleConfig buildModuleConfig_2() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("META-INF/module-demo-2-0.0.1.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("fund-module-2");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0");
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        moduleConfig.addScanPackage("com.jarlink.fund");
        List<String> overridePackages = new ArrayList<String>();
        overridePackages.add("com.jarlink.fund.action");
        moduleConfig.setOverridePackages(overridePackages);
        return moduleConfig;
    }

}
