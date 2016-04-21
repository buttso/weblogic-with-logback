/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttso.demo.sessionswithcdilogback;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author sbutton
 */
@SessionScoped
public class Counter implements Serializable {
    
    private AtomicInteger counter = new AtomicInteger(0);
    static final Logger LOG = LoggerFactory.getLogger(Counter.class);    
    
    /**
     * Increment counter, return current (new) value
     * @return 
     */
    public Integer hit() {
        int old = counter.get();
        int update = counter.incrementAndGet();
        LOG.trace("{} {}", old, update);
        return update;
    }
    
    /**
     * Reset counter, return last value that was set
     * @return 
     */
    public Integer reset() {
        return counter.getAndSet(0);
    }
}
