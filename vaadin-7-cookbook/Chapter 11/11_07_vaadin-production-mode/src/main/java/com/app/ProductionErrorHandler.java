package com.app;

import com.vaadin.server.ErrorHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ondrej Kvasnovsky
 */
public class ProductionErrorHandler implements ErrorHandler {

    private static final Logger log = Logger.getLogger(ProductionErrorHandler.class.getName());

    @Override
    public void error(com.vaadin.server.ErrorEvent errorEvent) {
        Throwable throwable = errorEvent.getThrowable();
        log.log(Level.SEVERE, "UI error occurred.", throwable);
    }
}