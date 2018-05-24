package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: ajax形式-异常处理器
 *
 * @author yangzhaoyunfei yangzhaoyunfei@qq.com
 * @date
 */
//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

    //	@ExceptionHandler(value = Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest req,
                                               Exception e) throws Exception {

        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }
}
