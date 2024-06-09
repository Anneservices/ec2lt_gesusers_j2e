package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({"/", "/list", "/add", "/update", "/delete"})
public class AuthentificationFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) reponse;
		
		HttpSession session = servletRequest.getSession();
		
		if (session.getAttribute("loggedUser") != null) 
		{
			chain.doFilter(request, reponse);
		}
		else
		{
			servletResponse.sendRedirect("login");
		}
		
	}

}
