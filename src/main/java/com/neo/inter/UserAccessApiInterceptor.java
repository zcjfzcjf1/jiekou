package com.neo.inter;

import com.neo.entity.User;
import com.neo.enums.ResultEnum;
import com.neo.repository.UserRepository;

import com.neo.util.RegexUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;


/**
 * 拦截url中的access_token
 * @author Hyz
 * 
 */
public class UserAccessApiInterceptor extends HandlerInterceptorAdapter {




    @Autowired
    private UserRepository UserRepository;

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod=null;
        response.setCharacterEncoding("utf-8");
        if (handler instanceof HandlerMethod) {//判断是不是启动时进入
            handlerMethod = (HandlerMethod) handler;
        } else {
            return true;
        }

        Method method = handlerMethod.getMethod();//获得方法
          AccessRequired annotation = method.getAnnotation(AccessRequired.class);//获得方法上注解AccessRequired的
        if (annotation != null) {
            //获得用户id
            String empNo= (String)request.getHeader("userName");
            String afferentToken= (String)request.getHeader("token");
            if(RegexUtils.isnull(afferentToken)){
                response.setContentType("text/html");

                PrintWriter out = response.getWriter();
                ResultEnum notLogin = ResultEnum.NOT_LOGIN;
                out.print("{\"retCode\":\""+notLogin.getRetCode()+"\",\"retInfo \":\""+notLogin.getRetInfo()+"\",\"data\":\""+"您已登录其他账号"+"\"}");
                return false;
            }

            if (UserRepository == null) {//解决service为null无法注入问题
                System.out.println("operatorLogService is null!!!");
                BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                UserRepository = (UserRepository) factory.getBean("UserRepository");
            }

            User user = UserRepository.findUserByUserName(empNo);
//
            if(user==null){
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                ResultEnum notLogin = ResultEnum.NOT_LOGIN;
                out.print("{\"retCode\":\""+notLogin.getRetCode()+"\",\"retInfo \":\""+notLogin.getRetInfo()+"\",\"data\":\""+notLogin.getRetInfo()+"\"}");
                return false;
            }

            String token = user.getToken();
            //token对比
            if( !afferentToken.equals(token)){
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                ResultEnum tokenError = ResultEnum.TOKEN_ERROR;
                out.print("{\"retCode\":\""+tokenError.getRetCode()+"\",\"retInfo \":\""+tokenError.getRetInfo()+"\",\"data\":\""+"账号在别处登录"+"\"}");
                return false;
            }

           }

        return true;
        // 没有注解通过拦截
    }
    
}
