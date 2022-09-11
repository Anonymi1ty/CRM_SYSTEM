package interceptor;

import commons.constants.Constants;
import org.springframework.web.servlet.HandlerInterceptor;

public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        //获取session
        javax.servlet.http.HttpSession session = request.getSession();
        //获取session中的user
        Object user = session.getAttribute(Constants.SESSION_USER);
        //判断user是否为空
        if (user == null){
            //重定向到登录页面
            response.sendRedirect(request.getContextPath());//重定向时必须加上项目名
            return false;
        }
        return true;
    }
}

