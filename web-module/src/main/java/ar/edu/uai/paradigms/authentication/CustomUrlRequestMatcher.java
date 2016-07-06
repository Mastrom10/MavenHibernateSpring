package ar.edu.uai.paradigms.authentication;

import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Federico on 24/03/2015.
 */
public class CustomUrlRequestMatcher implements RequestMatcher{
        private final String filterProcessesUrl;

        public CustomUrlRequestMatcher(String filterProcessesUrl) {
            Assert.hasLength(filterProcessesUrl, "filterProcessesUrl must be specified");
            Assert.isTrue(UrlUtils.isValidRedirectUrl(filterProcessesUrl), filterProcessesUrl + " isn't a valid redirect URL");
            this.filterProcessesUrl = filterProcessesUrl;
        }

        public boolean matches(HttpServletRequest request) {
            String uri = request.getRequestURI();
            int pathParamIndex = uri.indexOf(';');

            if (pathParamIndex > 0) {
                // strip everything after the first semi-colon
                uri = uri.substring(0, pathParamIndex);
            }

            if ("".equals(request.getContextPath())) {
                return uri.endsWith(filterProcessesUrl);
            }

            return uri.endsWith(request.getContextPath() + filterProcessesUrl);
        }
}
