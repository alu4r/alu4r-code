package com.alu4r.system.modules.api.factory;

import com.alu4r.system.modules.api.SysBaseRemoteApi;
import com.alu4r.system.modules.api.fallback.SysBaseRemoteApiFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author taoyan
 * @date 2020/05/22
 */
@Component
public class SysBaseRemoteApiFallbackFactory implements FallbackFactory<SysBaseRemoteApi> {

    @Override
    public SysBaseRemoteApi create(Throwable throwable) {
        SysBaseRemoteApiFallback fallback = new SysBaseRemoteApiFallback();
        fallback.setCause(throwable);
        return fallback;
    }

}
