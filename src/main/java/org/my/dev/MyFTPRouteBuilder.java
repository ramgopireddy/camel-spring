package org.my.dev;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyFTPRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() throws Exception {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        from("ftp:localhost/data?noop=true&include=message.*xml&delay=5s")
            .log("New file ${header.CamelFileName} picked up"+" from ${header.CamelFileHost}")
            .process(new ExchangePrinter())
            .to("file:target/messages/outgoing?fileExist=Fail");
    }

}
