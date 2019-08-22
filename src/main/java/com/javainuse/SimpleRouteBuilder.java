package com.javainuse;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.*;

// import org.apache.camel.component.http4;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // from("file:input?noop=true")
        //     .log("\n\n------------------------------------\n\n")
        //     .log("Read from the input file")
        //     .to("file:output")
        //     .log("Written to output file")
        //     .log("\n\n------------------------------------\n\n")
        //     .end();

        from("direct:start")
            .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.POST))
            // .setHeader(Exchange.HTTP_METHOD, constant("POST"))
            .to("http4://www.google.com")
            .to("mock:results");
    }

}
