/*
 * PepipostLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.pepipost.api.models;

import java.util.*;

public class SettingsBuilder {
    //the instance to build
    private Settings settings;

    /**
     * Default constructor to initialize the instance
     */
    public SettingsBuilder() {
        settings = new Settings();
    }

    /**
     * enable or disable footer
     */
    public SettingsBuilder footer(Boolean footer) {
        settings.setFooter(footer);
        return this;
    }

    /**
     * enable or disable click tracking
     */
    public SettingsBuilder clickTrack(Boolean clickTrack) {
        settings.setClickTrack(clickTrack);
        return this;
    }

    /**
     * enable or disable open tracking
     */
    public SettingsBuilder openTrack(Boolean openTrack) {
        settings.setOpenTrack(openTrack);
        return this;
    }

    /**
     * enable or disable unsubscribe tracking
     */
    public SettingsBuilder unsubscribeTrack(Boolean unsubscribeTrack) {
        settings.setUnsubscribeTrack(unsubscribeTrack);
        return this;
    }

    public SettingsBuilder hepf(Boolean hepf) {
        settings.setHepf(hepf);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Settings build() {
        return settings;
    }
}