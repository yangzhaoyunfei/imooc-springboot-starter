package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理控制器
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    /**
     * 返回错误视图
     *
     * @return
     */
    @RequestMapping("/error")
    public String error() {

        //这里抛出异常
        int a = 1 / 0;

        return "thymeleaf/error";
    }

    /**
     * 返回ajax错误视图
     *
     * @return
     */
    @RequestMapping("/ajaxerror")
    public String ajaxerror() {

        return "thymeleaf/ajaxerror";
    }

    /**
     * 访问这里生成ajax异常
     *
     * @return
     */
    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public IMoocJSONResult getAjaxerror() {

        int a = 1 / 0;

        return IMoocJSONResult.ok();
    }
}