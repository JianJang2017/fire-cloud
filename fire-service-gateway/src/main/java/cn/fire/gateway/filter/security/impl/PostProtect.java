package cn.fire.gateway.filter.security.impl;

import cn.fire.gateway.filter.security.AbstractProtect;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.util.List;

/**
 * @Author: wangzc
 * @Date: 2020/9/25 11:09
 */

public class PostProtect extends AbstractProtect {


    public PostProtect(HttpRequest httpRequest, HttpMethod httpMethod, String timestamp, String nonce, String sign) {
        super(httpRequest, httpMethod, timestamp, nonce, sign);
    }

    @Override
    protected List<HttpMethod> supportMethods() {
        return null;
    }

    @Override
    protected Boolean verify() {
        return null;
    }
}
