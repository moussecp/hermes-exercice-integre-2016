package com.hermes_ecs.java_exercise.domain;

public abstract class BuyerMother {
    private BuyerMother() {}

    public static String BALON = "Balon";
    public static String GREYJOY = "Greyjoy";
    public static String PYK = "Pyk";

    public static Buyer lukeSkywalker() {
        return new Buyer("Luke", "Skywalker", "Tatouine");
    }

    public static Buyer balonGreyjoy() {
        return new Buyer(BALON, GREYJOY, PYK);
    }


}
