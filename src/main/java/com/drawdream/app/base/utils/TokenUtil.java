package com.drawdream.app.base.utils;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 获取TOKEN 工具类
 * @package: com.drawdream.app.base.utils
 * @fileName: TokenUtil
 * @author: tanhao
 * @date: 2020-04-05 21:55
 */
public class TokenUtil {
    /**
      * @desc: 获取admin_token中的用户信息
      * @author: tanhao
      * @date: 2020/4/5 21:58
      */
    public static String getTokenAdminId() {
        String token = getRequest().getHeader("admin_token");// 从 http 请求头中取出 token
        return JWT.decode(token).getAudience().get(0);
    }
    /**
      * @desc: 获取user_token中的用户信息
      * @author: tanhao
      * @date: 2020/4/5 21:59
      */
    public static String getTokenUserId() {
        String token = getRequest().getHeader("user_token");// 从 http 请求头中取出 token
        return JWT.decode(token).getAudience().get(0);
    }

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        System.out.println(requestAttributes);
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
