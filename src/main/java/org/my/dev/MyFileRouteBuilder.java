package org.my.dev;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyFileRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        from("file:src/data?noop=true&delay=10s")
        .log("New file ${header.CamelFileName} picked up"+" from ${header.CamelFileHost}")
        .process(new ExchangePrinter())
        .process(new HeaderProcessor())
            .choice()
                .when(xpath("/order/customer/city = 'Atlanta'"))
                    .log("Atlanta message")
                    .to("file:target/messages/atlanta?fileName=${header.orderDate}/${header.CamelFileName}")    
                .otherwise()
                    .log("Other city message")
                    .to("file:target/messages/othercity?fileName=${header.orderDate}/${header.CamelFileName}");
    }

}
