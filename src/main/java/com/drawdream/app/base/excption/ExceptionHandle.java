package com.drawdream.app.base.excption;

import com.drawdream.app.base.pojo.JsonResult;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @desc: 异常捕捉
 * @package: com.drawdream.app.base.excption
 * @fileName: ExceptionHandle.java
 * @author: tanhao
 * @date: 2020-04-02 17:47
 */

@ControllerAdvice
public class ExceptionHandle {
//    private static final Logger log = logUtil.getLog();
//
    /**
     * @desc: 异常拦截器
     * @param e
     * @author: tanhao
     * @date: 2020-04-02 17:47
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handle(Exception e) {
        if (e instanceof WrongException) {
            WrongException wrongException = (WrongException) e;
            return JsonResult.errorMsg(wrongException.getCode(), wrongException.getMessage());
        } else {
            return JsonResult.error();
        }
    }
}
