package com.drawdream.app.base.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.drawdream.app.base.service.ToKenService;
import org.springframework.stereotype.Service;

/**
 * @desc: token 业务层
 * @package: com.drawdream.app.base.service.impl
 * @fileName: ToKenServiceImpl
 * @author: tanhao
 * @date: 2020-04-02 18:03
 */
@Service("Token")
public class ToKenServiceImpl implements ToKenService {
    @Override
    public String getToken(int id, String pwd) {
        String token="";
        // 将 user id 保存到 token 里面 .以 password 作为 token 的密钥
        token= JWT.create().withAudience(String.valueOf(id))
                .sign(Algorithm.HMAC256(pwd));
        return token;
    }
}
