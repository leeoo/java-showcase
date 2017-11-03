package com.lex.showcase.concurrency.temp;

/**
 * @author Lex Li
 */
public class Main {

    public static void main(String[] args) {
        Gate gate = new Gate();

        UserThread ada = new UserThread("Ada", "America", gate);
        UserThread bob = new UserThread("Bob", "Baricy", gate);
        UserThread cindy = new UserThread("Cindy", "Canada", gate);

        ada.start();
        bob.start();
        cindy.start();
    }
}
