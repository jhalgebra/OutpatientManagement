package com.horvat;

import com.horvat.Tests.DatabaseTest;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseTest.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
