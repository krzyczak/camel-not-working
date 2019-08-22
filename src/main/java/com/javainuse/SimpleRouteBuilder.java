package com.javainuse;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // from("file:C:/inputFolder?noop=true").to("file:C:/outputFolder");
        // from("file:/Users/krzyczak/Desktop/camel/camel-java-dsl/in.txt?noop=true").process(new MyProcessor()).to("file:/Users/krzyczak/Desktop/camel/camel-java-dsl/out.txt");
        // from("file:/Users/krzyczak/Desktop/camel/camel-java-dsl/in.txt?noop=true")
        //     .to("file:/Users/krzyczak/Desktop/camel/camel-java-dsl/out.txt");

        // from("direct:start")
        from("file:input?noop=true")
            .log("Read from the input file")
            .to("file:destination")
            .log("Written to output file");
    }

}
