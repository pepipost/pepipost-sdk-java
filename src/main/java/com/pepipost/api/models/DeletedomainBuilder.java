/*
 * PepipostLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.pepipost.api.models;

import java.util.*;

public class DeletedomainBuilder {
    //the instance to build
    private Deletedomain deletedomain;

    /**
     * Default constructor to initialize the instance
     */
    public DeletedomainBuilder() {
        deletedomain = new Deletedomain();
    }

    /**
     * Name of the domain
     */
    public DeletedomainBuilder domain(String domain) {
        deletedomain.setDomain(domain);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Deletedomain build() {
        return deletedomain;
    }
}