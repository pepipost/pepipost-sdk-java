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
public class UpdateCredisofsubaccount 
        implements java.io.Serializable {
    private static final long serialVersionUID = -8305979641297545771L;
    private String username;
    private ActionEnum action;
    private Integer amount;
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
 
    /** GETTER
     * Indicate the action (add or subtract) to be taken.Allowed values increase, decrease
     */
    @JsonGetter("action")
    public ActionEnum getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * Indicate the action (add or subtract) to be taken.Allowed values increase, decrease
     */
    @JsonSetter("action")
    public void setAction (ActionEnum value) { 
        this.action = value;
    }
 
    /** GETTER
     * Amount of credits
     */
    @JsonGetter("amount")
    public Integer getAmount ( ) { 
        return this.amount;
    }
    
    /** SETTER
     * Amount of credits
     */
    @JsonSetter("amount")
    public void setAmount (Integer value) { 
        this.amount = value;
    }
 
}
