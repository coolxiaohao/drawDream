package com.drawdream.app.base.pojo;

/**
 * @desc: Json 返回类
 * @package: com.drawdream.app.base.pojo
 * @fileName: JsonResult
 * @author: tanhao
 * @date: 2020-03-31 13:46
 */
public class JsonResult<T> {
    /**
     * 定义成功的返回数值
     */
    private static final int CODE_SUCCESS = 200;
    /**
     * 定义失败的返回数值
     */
    private static final int CODE_FAIL = 400;
    /**
     * 定义成功的返回提示字符串
     */
    private static final String MSG_SUCCESS = "success";
    /**
     * 定义失败的返回提示字符串
     */
    private static final String MSG_FAIL = "error";
    /**
     * 状态
     */
    private int code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回提示信息
     */
    private String msg;

    /**
     * @desc: 构造方法
     * @author: tanhao
     * @date: 2020-03-31 14:05
     */
    public JsonResult() {

    }

    /**
     * @desc: 只返回状态
     * @author: tanhao
     * @date: 2020-03-31 14:01
     */
    public JsonResult(int code) {
        this.code = code;
    }

    /**
     * @desc: 返回状态和数据
     * @author: tanhao
     * @date: 2020-03-31 14:02
     */
    public JsonResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    /**
     * @desc: 返回状态和信息
     * @author: tanhao
     * @date: 2020-03-31 14:03
     */
    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @desc: 自定义返回信息
     * @author: tanhao
     * @date: 2020-03-31 14:11
     */
    public JsonResult(String msg){
        this.msg = msg;
    }

    /**
     * @desc: 返回状态，信息，数据
     * @author: tanhao
     * @date: 2020-03-31 14:03
     */
    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @desc: 成功默认返回状态和信息
     * @author: tanhao
     * @date: 2020-03-31 14:03
     */
    public static JsonResult success() {
        return new JsonResult(CODE_SUCCESS, MSG_SUCCESS);
    }

    /**
     * @desc: 自定义状态和值
     * @author: tanhao
     * @date: 2020-03-31 14:13
     */
    public static JsonResult success(int code,String msg){
        return new JsonResult(code, msg);
    }

    /**
     * @desc: 返回状态和返回数据
     * @author: tanhao
     * @date: 2020-03-31 14:19
     */
    public static JsonResult success(int code,Object data){
        return new JsonResult(code, data);
    }

    /**
     * @desc: 成功默认返回状态和信息以及数据
     * @author: tanhao
     * @date: 2020-03-31 14:04
     */
    public static JsonResult success(Object data) {
        return new JsonResult(CODE_SUCCESS, MSG_SUCCESS, data);
    }


    /**
     * @desc: 默认失败的回调
     * @author: tanhao
     * @date: 2020-03-31 14:05
     */
    public static JsonResult error() {
        return new JsonResult(CODE_FAIL, MSG_FAIL);
    }
    /**
     * @desc: 失败并返回失败提示
     * @author: tanhao
     * @date: 2020-03-31 14:05
     */
    public static JsonResult errorMsg(Integer cede,String msg) {
        return new JsonResult(cede, msg, null);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
