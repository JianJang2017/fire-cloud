package cn.fire.gateway.filter.security.enums;

import cn.fire.common.web.util.SpringUtil;
import cn.fire.gateway.filter.security.AbstractProtect;
import cn.fire.gateway.filter.security.impl.GetProtect;
import cn.fire.gateway.filter.security.impl.OptionsProtect;
import cn.fire.gateway.filter.security.impl.PostProtect;
import lombok.Getter;
import org.springframework.http.HttpMethod;

/**
 * 充血枚举，处理不同的验证方式
 * @Author: wangzc
 * @Date: 2020/9/25 11:23
 */

@Getter
public enum MethodEnum {

    //POST验证逻辑
    POST(HttpMethod.POST, SpringUtil.getBean(PostProtect.class)),
    //GET验证逻辑
    GET(HttpMethod.GET,SpringUtil.getBean(GetProtect.class)),
    //OPTIONS验证逻辑
    OPTIONS(HttpMethod.OPTIONS,SpringUtil.getBean(OptionsProtect.class));
//    DELETE(HttpMethod.DELETE, SpringUtil.getBean(TVGoodsProducer.class)),
//    PUT(HttpMethod.PUT, SpringUtil.getBean(MeetingTimeFeignClient.class));

    private HttpMethod method;
    private AbstractProtect protect;

    MethodEnum(HttpMethod method, AbstractProtect protect) {
        this.method = method;
        this.protect = protect;
    }

    public static AbstractProtect getOrderBusiness(HttpMethod method) {
        for (MethodEnum value : MethodEnum.values()) {
            if (value.method == method) {
                return value.getProtect();
            }
        }

        return null;
    }
}
