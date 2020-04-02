
package org.my.dev;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.xml.XPathBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class HeaderProcessor implements Processor{
	final private static Logger log = LoggerFactory.getLogger(HeaderProcessor.class);

	final private static String XPATH_DATE = "/order/date/text()";
    final private static DateFormat df = new SimpleDateFormat("yyyyMMdd");
        
    @Override
    public void process(Exchange exchange) throws Exception{
        String orderXML = exchange.getIn().getBody(String.class);
        String orderDateTime = XPathBuilder.xpath(XPATH_DATE).evaluate(exchange.getContext(), orderXML);
        log.info("orderDateTime: " + orderDateTime);
		Calendar orderCal = DatatypeConverter.parseDateTime(orderDateTime);
		String orderDate = df.format (orderCal.getTime());
		exchange.getIn().setHeader("orderDate", "order-" + orderDate + ".txt");        

    }
}