package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception{
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if(uri.endsWith("loginForm") || uri.endsWith("logar")){
			return true;
		}
		if(session.getAttribute("logado") != null){
			return true;
		}		
		response.sendRedirect("/ProjetoFinanceiro/loginForm");
		return false;
	}
}
