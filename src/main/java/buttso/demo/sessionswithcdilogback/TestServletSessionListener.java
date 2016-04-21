/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttso.demo.sessionswithcdilogback;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web application lifecycle listener.
 *
 * @author sbutton
 */
public class TestServletSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    static final Logger LOG = LoggerFactory.getLogger(TestServletSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOG.info("SessionCreated {}", se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LOG.info("SessionDestroyed {}", se.getSession().getId());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        LOG.debug("{} {}",
                event.getName(),
                event.getValue().toString());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        LOG.debug("{} {}",
                event.getName(),
                event.getValue().toString());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        LOG.debug("{} {}",
                event.getName(),
                event.getValue().toString());
    }
}
