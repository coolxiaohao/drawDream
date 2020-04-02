package com.drawdream.app.base.excption;

/**
 * @desc: 自定义异常类
 * @package: com.drawdream.app.base.excption
 * @fileName: WrongException.java
 * @author: tanhao
 * @date: 2020-04-02 17:46
 */


public class WrongException extends RuntimeException {
    private Integer code;

    public WrongException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public WrongException(String msg) {
        super(msg);
        this.code = 4000;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
