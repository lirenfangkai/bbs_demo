package cn.bx.bbsdemo.handler;

import cn.bx.bbsdemo.config.JSONAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出Handler
 */
@Component
public class MyLogoutHandler extends JSONAuthentication implements LogoutHandler {
    private String header = "Authorization";
    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {

        String headerToken = request.getHeader(header);

        //
        if (!StringUtils.isEmpty(headerToken)) {
            //postMan测试时，自动假如的前缀，要去掉。
            String token = headerToken.replace("Bearer", "").trim();
            SecurityContextHolder.clearContext();
        }
    }
}
