package ar.edu.uai.paradigms.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Federico on 24/03/2015.
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence( HttpServletRequest request, HttpServletResponse response,
                          AuthenticationException authException ) throws IOException {
        response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
    }
}
