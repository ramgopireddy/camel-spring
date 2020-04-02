package org.my.dev;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

public class ExchangePrinter implements Processor {

    private static Logger log = LoggerFactory.getLogger(ExchangePrinter.class);
    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("Headers:");
        Map<String,Object> headers = exchange.getIn().getHeaders();
        for(String key: headers.keySet()){
            log.info("Key: " +  key + " | Value: " + headers.get(key));
        }
        String body =  exchange.getIn().getBody(String.class);
        log.info("Body: " + body);
    }
}