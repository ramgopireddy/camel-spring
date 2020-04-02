package org.my.dev;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;
    @XmlElementWrapper(name = "orderItems")
    @XmlElement(name = "orderItem")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();





    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}