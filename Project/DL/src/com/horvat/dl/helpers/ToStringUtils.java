package com.horvat.dl.helpers;

import javafx.util.Pair;

import java.util.List;

public class ToStringUtils {
    public static <T> StringBuilder appendCollection(StringBuilder builder, String label, List<T> collection) {
        builder.append(label);

        if (collection.size() == 0) {
            builder.append(" empty").append(System.lineSeparator());
            return builder;
        }

        for (T item : collection) {
            builder.append(System.lineSeparator()).append(System.lineSeparator());
            builder.append(item.toString());
        }

        return builder;
    }

    public static StringBuilder appendSeparator(StringBuilder builder) {
        return appendSeparator(builder, '=');
    }

    public static StringBuilder appendSeparator(StringBuilder builder, char lineChar) {
        builder
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        for(int i = 0; i < 30; i++)
            builder.append(lineChar);

        builder.append(System.lineSeparator())
                .append(System.lineSeparator());

        return builder;
    }

    public static String construct(char lineChar, Pair<String, List<Object>>... dataWithLabel){
        StringBuilder builder = new StringBuilder();

        appendSeparator(builder, lineChar);

        for(Pair<String, List<Object>> collection : dataWithLabel)
            appendCollection(builder, collection.getKey(), collection.getValue());

        appendSeparator(builder, lineChar);

        return builder.toString();
    }
}
