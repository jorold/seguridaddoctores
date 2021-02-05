package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Doctor;

public class FiltroDoctores implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest peticion = (HttpServletRequest) request;
        String uri = peticion.getRequestURI();
        Doctor doctor = (Doctor) peticion.getSession().getAttribute("DOCTOR");
        if (uri.contains("protegidas")) {
            if (doctor != null) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse respuesta = (HttpServletResponse) response;
                respuesta.sendRedirect("../login.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

}
