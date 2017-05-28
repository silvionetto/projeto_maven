package com.cpqi;

/**
 * Hello world!
 */
public class App {

    /**
     * Public static void main.
     */
    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.hello("Silvio"));
    }

    public String hello(String name) {
        return "Hello " + name;
    }
}
