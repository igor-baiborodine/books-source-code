package com.app;

import javax.servlet.*;
import java.io.*;

/**
 * @author Ondrej Kvasnovsky
 */
public class SeoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Object searchEngineFlag = request.getParameter("_escaped_fragment_");
        if (searchEngineFlag != null) {
            InputStream in = getClass().getResourceAsStream("index_for_seo.html");
            ServletOutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
