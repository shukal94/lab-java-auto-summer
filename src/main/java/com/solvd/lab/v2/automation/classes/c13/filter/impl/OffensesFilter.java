package com.solvd.lab.v2.automation.classes.c13.filter.impl;

import com.solvd.lab.v2.automation.classes.c13.filter.MessageFilter;

import java.util.HashSet;


public class OffensesFilter implements MessageFilter {
    private static final HashSet<String> OFFENSES = null;

    public String apply(String message) {
        return message;
    }
}
