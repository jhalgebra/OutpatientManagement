package com.horvat.console.app;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;

public class Utils {
    //region Readonly fields

    private static final String DATE_FORMAT = "dd.MM.yyyy.";
    private static final String DATE_WITH_TIME_FORMAT = "dd.MM.yyyy. HH:mm:ss";
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);

    public static final Scanner scanner = new Scanner(System.in);

    //endregion

    //region Reading data

    public static Boolean readBoolean(String message) {
        return read(Boolean::parseBoolean, input -> true, message + "? (1 or 0)");
    }

    public static Double readDouble(Function<Double, Boolean> predicate, String message) {
        return read(Double::parseDouble, predicate, message);
    }

    public static BigDecimal readDecimal(String message) {
        return read(
                item -> BigDecimal.valueOf(Double.parseDouble(item)),
                item -> item.doubleValue() > 0,
                message
        );
    }

    public static Date readDateInFuture(String message, boolean includeTime) {
        return readDate(input -> input != null && input.after(new Date()), message, includeTime);
    }

    public static Date readDateInPast(String message, boolean includeTime) {
        return readDate(input -> input != null && input.before(new Date()), message, includeTime);
    }

    public static Date readDate(Function<Date, Boolean> predicate, String message, boolean includeTime) {
        return read(
                input -> {
                    try {
                        return dateFormatter.parse(input + (includeTime
                                ? " 00:00:00"
                                : ""
                        ));
                    } catch (ParseException e) {
                        return null;
                    }
                },
                predicate,
                MessageFormat.format("{0} (format: {1})",
                        message,
                        includeTime
                                ? DATE_WITH_TIME_FORMAT
                                : DATE_FORMAT
                )
        );
    }

    public static String readString(Function<String, Boolean> predicate, String message) {
        return read(input -> input, predicate, message);
    }

    public static String readString(String message) {
        return readString(input -> input.length() > 0, message);
    }

    public static String enterString(String fieldName) {
        return readString("Enter " + fieldName);
    }

    public static <T> T read(Function<String, T> converter, Function<T, Boolean> predicate, String message) {
        while (true) {
            String error = "";
            System.out.print(message + ": ");

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

            if (error.length() > 0 && !confirm(error))
                return null;
        }
    }

    //endregion

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

        for (int i = 0; i < collection.size(); i++)
            array[i] = collection.get(i).toString();

        int choice = labelledChooseOption(inputMessage, array);

        if (choice < 1)
            return null;

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

    //region User interaction and printing

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

    public static boolean confirm(String message) {
        System.out.println();
        System.out.print(message + ". Continue? (enter y to continue): ");
        String input = scanner.nextLine();

        return input.equals("y") || input.equals("Y");
    }

    public static void waitForInput(int numLinesToPrintAfter) {
        System.out.println();
        System.out.print("Press Enter to continue... ");

        scanner.nextLine();

        for (int i = 0; i < numLinesToPrintAfter; i++)
            System.out.println();
    }

    //endregion
}
