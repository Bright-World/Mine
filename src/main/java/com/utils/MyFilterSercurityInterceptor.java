package com.utils;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;

/**
 * Created by ZhenXi on 2016/3/26.
 */
public class MyFilterSercurityInterceptor extends AbstractSecurityInterceptor {


    @Override
    public Class<?> getSecureObjectClass() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        return null;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return null;
    }
}
