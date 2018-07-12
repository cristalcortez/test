/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Map;
import java.util.HashMap;

/**
 * This class implements a simple "global naming service".
 * It implements the Singleton interface to guarantee that only
 * one such naming service exists within the JVM and is accessible
 * to all parts of the application.
 *
 * This class could easily have been a Utility class with static
 * methods only.
 */
public final class NamingService {

    // ****************
    // Public interface
    // ****************

    public static NamingService getInstance() {
        return THE_OBJECT;
    }

    /**
    * This method stores an object by a specific name.
    * @param name  The unique name that holds some object.
    * @return Object  The object for that name, or null if name not found
    */
    public Object getAttribute(String name) {
        return nameValuePairs.get(name);
    }

    /**
    * This method stores an object by a specific name.
    * @param name  The unique name that holds some object.
    * @param object  The object to be stored.
    * @thrown  IllegalArgumentException  If the name is already in use
    */
    public void setAttribute(String name, Object object) {
        if ( nameValuePairs.get(name) == null ) {
            nameValuePairs.put(name, object);
        } else {
            throw new IllegalArgumentException("");
        }
    }

    /**
    * This method removes a listing by the specific name.
    * @param name  The unique name that holds some object.
    */
    public void removeAttribute(String name) {
        nameValuePairs.remove(name);
    }

    // **********************
    // Private implementation
    // **********************

    private static final NamingService THE_OBJECT = new NamingService();
    private final Map nameValuePairs;
    
    private NamingService() {
        nameValuePairs = new HashMap();
    }
    
}