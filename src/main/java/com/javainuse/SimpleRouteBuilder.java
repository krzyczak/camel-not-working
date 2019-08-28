package com.javainuse;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Processor;

import org.apache.camel.Exchange;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:experiments/?noop=true&fileName=in.txt")
            .setHeader(Exchange.HTTP_METHOD, simple("GET"))
            .log("Janus")
            .to("http://ip.jsontest.com").process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    //String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    // String data = " | " + exchange.getIn().getBody(String.class);
                    //data += " | " + exchange.getIn().getBody(String.class);
                    //data += "\n";
                    String data = exchange.getIn().getBody(String.class);

                    exchange.getIn().setBody(data.trim());
                }
            }).to("file:experiments/?fileName=out.txt")
            //}).to("file:experiments/?fileName=out.txt&fileExist=Overwrite")
            //}).to("file:experiments/?fileName=out.txt&fileExist=Append")
            .log("\n\n------------ DONE ----------------------\n\n");

        // from("file:input?noop=true")
        //     .log("\n\n------------------------------------\n\n")
        //     .log("Read from the input file")
        //     .to("file:output")
        //     .log("Written to output file")
        //     .log("\n\n------------------------------------\n\n")
        //     .end();

        // from("direct:start")
        //     // .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.POST))
        //     .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.HttpMethods.POST))
        //     // .setHeader(Exchange.HTTP_METHOD, constant("POST"))
        //     .to("http4://www.google.com")
        //     // .convertBodyTo(String.class);
        //     .to("mock:results");

        // from("file:C:/inboxREST?noop=true").setHeader(Exchange.HTTP_METHOD, simple("GET"))
        //     .to("http://dummy.restapiexample.com/api/v1/employees");//.process(new MyProcessor());
    }

}
