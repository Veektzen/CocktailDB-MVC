package com.controller.factory;

import com.view.factory.Linux;
import com.view.factory.Mac;
import com.view.factory.Windows;

public class OsFactory {
    /**
     * This method returns what the user selected
     *
     * @param OsType
     * @return operating system
     */
    public OperatingSystem getOs(String OsType) {
        if (OsType.equalsIgnoreCase("Linux")) {
            return new Linux();
        } else if (OsType.equalsIgnoreCase("MacOS")) {
            return new Mac();
        } else if (OsType.equalsIgnoreCase("Windows")) {
            return new Windows();
        }

        return null;
    }
}