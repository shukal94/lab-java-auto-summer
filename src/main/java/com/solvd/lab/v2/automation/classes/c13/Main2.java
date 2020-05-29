package com.solvd.lab.v2.automation.classes.c13;

import com.solvd.lab.v2.automation.classes.c13.filter.MessageFilter;
import com.solvd.lab.v2.automation.classes.c13.filter.impl.EmodjiFilter;
import com.solvd.lab.v2.automation.classes.c13.filter.impl.OffensesFilter;

import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        String message = "Java";
        MessageFilter offensesFilter = new OffensesFilter();
        MessageFilter emodjiFilter = new EmodjiFilter();

        Set<MessageFilter> filters = new HashSet<>();
        filters.add(offensesFilter);
        filters.add(emodjiFilter);

        for (MessageFilter filter : filters) {
            filter.apply(message);
        }
    }
}
