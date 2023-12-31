/*
 * Copyright 2019-2022 VMware, Inc.
 * SPDX-License-Identifier: EPL-2.0
 */
package com.vmware.vip.i18n.api.v1.locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import com.vmware.vip.BootApplication;
import com.vmware.vip.i18n.api.v1.common.CacheUtil;
import com.vmware.vip.i18n.api.v1.common.ConstantsForTest;
import com.vmware.vip.i18n.api.v1.common.RequestUtil;

/**
 * Test cases for LocaleAPI.
 * @author zhanghao
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class LocaleAPITest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void authentication() throws Exception{
        String authenticationResult=RequestUtil.sendRequest(webApplicationContext,ConstantsForTest.POST, ConstantsForTest.AuthenticationAPIURI);//+key
        CacheUtil.cacheSessionAndToken(webApplicationContext, authenticationResult);
    }

    @Test
    public void testBrowserLocaleAPI() throws Exception {
        RequestUtil.sendRequest(webApplicationContext, ConstantsForTest.GET,ConstantsForTest.BrowserLocaleAPIURI);
    }

    @Test
    public void testNormalizedBrowserLocaleAPI() throws Exception {
        RequestUtil.sendRequest(webApplicationContext,ConstantsForTest.GET, ConstantsForTest.NormalizedBrowserLocaleAPIURI);
    }     
}
