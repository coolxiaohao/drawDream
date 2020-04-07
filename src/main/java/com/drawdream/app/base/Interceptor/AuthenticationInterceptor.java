package com.drawdream.app.base.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.pojo.Rule;
import com.drawdream.app.admin.service.AdminService;
import com.drawdream.app.admin.service.RuleService;
import com.drawdream.app.base.excption.WrongException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @desc: token 验证拦截
 * @package: com.drawdream.app.base.Interceptor
 * @fileName: AuthenticationInterceptor
 * @author: tanhao
 * @date: 2020-04-05 22:20
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RuleService ruleService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("admin_token");
        // 从 http 请求头中取出 token
        String module = httpServletRequest.getHeader("module");
        if (module.equals("home") || module.equals("api")) {
            token = httpServletRequest.getHeader("user_token");
        }
        //获取路由
        String path = httpServletRequest.getRequestURI();
        //是否跳过权限认证
        Rule rule = ruleService.getRule(path);
        if (rule == null){
            return  true;
        }
        if (rule.getPort().equals(module) && rule.getType() == 0) {
            return true;
        }
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查该权限组是否需要登录权限 是则跳过
        if (module.equals("admin")) {
            return basePreHandle(token, path,"admin");
        } else {
            return basePreHandle(token,path,"other");
        }
    }
    /**
      * @desc: 统一权限认证
      * @param token 登陆token
      * @param path 路由
      * @param type 模块 前后台
      * @author: tanhao
      * @date: 2020/4/5 23:54
      */
    private boolean basePreHandle(String token,String path, String type) {
        // 执行认证
        if (token == null) {
            throw new WrongException("无token，请重新登录");
        }
        // 获取 token 中的 admin id
        String id;
        try {
            id = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        String pwd = null;
        if (type.equals("admin")) {
            Admin admin = adminService.findAdminById(Integer.parseInt(id));
            if (admin == null) {
                throw new WrongException("用户不存在，请重新登录");
            }
            String[] ruleIds = admin.getRulegroup().getRuleGroup().split(",");
            boolean isRule = false;
            for (String ruleId: ruleIds) {
                String AccessPath = ruleService.getAccessPath(Integer.parseInt(ruleId));
                if (AccessPath.equals(path)){
                    isRule = true;
                    break;
                }
            }
            if (!isRule){
                throw new WrongException(304,"当前账号没有访问权限！");
            }
            pwd = admin.getAdminPwd();
        } else {
            //TODO 用户权限
        }
        // 验证 token
        assert pwd != null;
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(pwd)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new WrongException("验证TOKEN失败,请重新登录");
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
