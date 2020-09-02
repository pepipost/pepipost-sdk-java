/*
 * PepipostLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.pepipost.api.models;

import java.util.*;

public class CreatesubaccountBuilder {
    //the instance to build
    private Createsubaccount createsubaccount;

    /**
     * Default constructor to initialize the instance
     */
    public CreatesubaccountBuilder() {
        createsubaccount = new Createsubaccount();
    }

    /**
     * provide a username for the subaccount
     */
    public CreatesubaccountBuilder username(String username) {
        createsubaccount.setUsername(username);
        return this;
    }

    /**
     * email address to be registered with the account.
     */
    public CreatesubaccountBuilder email(String email) {
        createsubaccount.setEmail(email);
        return this;
    }

    /**
     * You can opt to set the password for the subaccount.\nIf set as 1, please provide a value in password parameter.\nIf set as 0, the email confirmation link will act as a password reset link.
     */
    public CreatesubaccountBuilder setpassword(String setpassword) {
        createsubaccount.setSetpassword(setpassword);
        return this;
    }

    /**
     * It is required to pass this value, if setpassword is set as 1.\nThe password must comprise minimum of 8 characters and include one uppercase character, one lowercase character, one numeric character.
     */
    public CreatesubaccountBuilder password(String password) {
        createsubaccount.setPassword(password);
        return this;
    }

    /**
     * Allowed values one_time_credit or unlimited by default, all subaccounts are created with credit type as unlimited.
     */
    public CreatesubaccountBuilder creditType(String creditType) {
        createsubaccount.setCreditType(creditType);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Createsubaccount build() {
        return createsubaccount;
    }
}