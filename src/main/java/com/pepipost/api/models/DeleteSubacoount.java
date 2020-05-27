/*
 * PepipostLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.pepipost.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class DeleteSubacoount 
        implements java.io.Serializable {
    private static final long serialVersionUID = -47531337170977265L;
    private String username;
    /** GETTER
     * The username of the subaccount
     */
    @JsonGetter("username")
    public String getUsername ( ) { 
        return this.username;
    }
    
    /** SETTER
     * The username of the subaccount
     */
    @JsonSetter("username")
    public void setUsername (String value) { 
        this.username = value;
    }
 
}
