package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 统一异常拦截处理器
 *
 * @author yangzhaoyunfei yangzhaoyunfei@qq.com
 * @date 2018/05/24
 */
//@ControllerAdvice 注解，用于拦截全局的Controller的异常
@ControllerAdvice
public class IMoocExceptionHandler {

    /**
     * 自定义的错误视图的名称
     */
    public static final String IMOOC_ERROR_VIEW = "error";

    /**
     * 页面跳转形式的异常处理器
     */
//	@ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest reqest, 
//    		HttpServletResponse response, Exception e) throws Exception {
//    	
//    	e.printStackTrace();
//    	
//		ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", reqest.getRequestURL());
//        mav.setViewName(IMOOC_ERROR_VIEW);
//        return mav;
//    }

    /**
     * 判断是否是ajax请求
     *
     * @param httpRequest
     * @return
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

    /**
     * 兼容-页面跳转形式-ajax形式-异常处理器
     *
     * @param reqest
     * @param response
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(reqest)) {
            return IMoocJSONResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }
    }
}
