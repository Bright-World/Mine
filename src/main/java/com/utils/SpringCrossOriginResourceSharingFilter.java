package com.utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZhenXi on 2016/5/16.
 */
@Component
public class SpringCrossOriginResourceSharingFilter extends BaseCORSFilter implements Filter {

    private String allowedOriginsString;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req instanceof HttpServletRequest) {
            /*if (((HttpServletRequest) req).getHeader("origin") != null) {
                String origin = ((HttpServletRequest) req).getHeader("origin");
                if (getAllowedOrigins(allowedOriginsString).contains(origin)) {
                    HttpServletResponse response = (HttpServletResponse) res;
                    response.setHeader("Access-Control-Allow-Origin", origin);
                    response.setHeader("Access-Control-Allow-Methods",  "GET, POST, PUT, DELETE, OPTIONS");
                    response.setHeader("Access-Control-Max-Age", "3600");
                    response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Authorization, Content-Type");
                }
            }*/
            HttpServletResponse response = (HttpServletResponse) res;
            response.setHeader("Access-Control-Allow-Origin", ((HttpServletRequest) req).getHeader("origin"));
            response.setHeader("Access-Control-Allow-Methods",  "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Authorization, Content-Type");
        }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
        /*String springActive = filterConfig.getServletContext().getInitParameter("spring.profiles.active");
        if(!Strings.isNullOrEmpty(springActive)){
            Properties prop = new Properties();
            try {
                prop.load(this.getClass().getClassLoader().getResourceAsStream("properties/solo-"+ springActive +".properties"));
                allowedOriginsString = prop.getProperty("cors.allowed.origins");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }*/
    }

    public void destroy() {}

}
