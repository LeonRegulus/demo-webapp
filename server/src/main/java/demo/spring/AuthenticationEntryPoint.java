package demo.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description:拦截Security的验证和授权异常，如果请求是异步的，则返回401状态以及Json格式的异常堆栈信息。
 * <p/>
 * Date: 15-5-19
 *
 * @author LeonRegulus
 */
public class AuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    public AuthenticationEntryPoint (String loginFormUrl) {
        super(loginFormUrl);
    }

    private static final Log logger = LogFactory.getLog(AuthenticationEntryPoint.class);
    /**
     * 将登录异常的处理分为异步请求和同步请求两类。
     * <ol>
     *     <li>异步请求：将响应状态值设置为401，并将异常信息通过Json方式输出。
     *         <ul>
     *             <li>异步的请求可以不区分Json请求或者非Json请求。</li>
     *             <li>只要是异步的请求，前台都应该弹出提示会话过期信息，并通过js脚本方式将页面引导至登陆页面。</li>
     *         </ul>
     *     </li>
     *     <li>同步请求——将请求重定向至登录页面。</li>
     * </ol>
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        logger.error(authException.getMessage(), authException);

        if (request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").contains("XMLHttpRequest")
                ) {
            // 异步请求
            // 如果截取到未登陆的异常，则将异常信息通过Json方式输出
            response.setContentType("application/json");
            // 将响应状态值设置为401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");

            // 返回异常信息
            try {
                PrintWriter out = response.getWriter();
                out.write(-1);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.debug("将Json格式的会话异常信息输出到Http响应中");

        } else {
            // 非异步请求，还是按照原来的流程处理。重定向到登陆页面
            logger.debug("重定向到登陆页面");
            super.commence(request, response, authException);
        }
    }
}
