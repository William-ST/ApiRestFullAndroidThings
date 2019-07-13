package com.cursoandroid.apirestfullandroidthings;

public class LDRmodel {

    private final static String TAG = LDRmodel.class.getCanonicalName();
    private static LDRmodel instance = null;

    public static LDRmodel getInstance() {
        if (instance == null) {
            instance = new LDRmodel();
        }
        return instance;
    }

    private LDRmodel() {
    }

    public static double getValue() {
        return ((int) (Math.random() * 500 + 1) * 0.01);
    }

}
