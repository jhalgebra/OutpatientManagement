package com.horvat.console.app;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Helpers {
    private static final Scanner scanner = new Scanner(System.in);

    public static <T> T read(Function<String, T> converter, Function<T, Boolean> predicate, String message) {
        while (true) {
            String error = "";
            System.out.print(message);

            String input = scanner.nextLine();

            try {
                T item = converter.apply(input);

                try {
                    if (predicate.apply(item))
                        return item;
                } catch (Exception ex) {
                    error = "Predicate test failed";
                }
            } catch (Exception ex) {
                error = "Conversion failed";
            }

            if (error.length() > 0) {
                System.out.print(error + ". Continue? (enter y to continue): ");
                input = scanner.nextLine();

                if (!(input.equals("y") || input.equals("Y")))
                    return null;
            }
        }
    }

    //region Choose Option

    public static int labelledChooseOption(String inputMessage, String... options) {
        if (options.length == 0)
            return -1;

        String message = MessageFormat.format("{0} ({1} - {2})", inputMessage, 1, options.length);

        Integer result = read(
                Integer::parseInt,
                num -> num > 0 && num <= options.length,
                constructInputOptions(message, options)
        );

        return result == null
                ? -1
                : result;
    }

    public static int chooseOption(String... options) {
        return labelledChooseOption("Choose option", options);
    }

    public static <T> T labelledChooseOption(String inputMessage, List<T> collection, Function<T, String> toString) {
        String[] array = new String[collection.size()];

        for(int i = 0; i < collection.size(); i++)
            array[i] = collection.get(i).toString();

        int choice = labelledChooseOption(inputMessage, array);

        return collection.get(choice - 1);
    }

    public static <T> T chooseOption(List<T> collection, Function<T, String> toString) {
        return labelledChooseOption("Choose option", collection, toString);
    }

    public static <T> T labelledChooseOption(String inputMessage, List<T> collection) {
        return labelledChooseOption(inputMessage, collection, Object::toString);
    }

    public static <T> T chooseOption(List<T> collection) {
        return labelledChooseOption("Choose option", collection);
    }

    //endregion

    public static StringBuilder getUnderlined(String text, char underlineChar) {
        StringBuilder builder = new StringBuilder(text);

        builder.append(System.lineSeparator());
        builder.append(new String(new char[text.length()]).replace('\0', underlineChar));
        builder.append(System.lineSeparator());

        return builder;
    }

    public static String constructInputOptions(String inputMessage, String... options) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < options.length; i++) {
            builder
                    .append(i + 1)
                    .append(". ")
                    .append(options[i])
                    .append(System.lineSeparator());
        }

        builder.append(inputMessage).append(": ");

        return builder.toString();
    }
}
