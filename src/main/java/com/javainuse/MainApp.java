package com.javainuse;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Hell1o");
        SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();
        try {
            // ctx.addComponent("http4", org.apache.camel.component.http4.HttpComponent);
            // HttpComponent http4 = ctx.getComponent("http4", HttpComponent.class);
            ctx.addRoutes(routeBuilder);
            ctx.start();
            // Thread.sleep(5 * 60 * 1000);
            Thread.sleep(2000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hell1o");

    }
}
