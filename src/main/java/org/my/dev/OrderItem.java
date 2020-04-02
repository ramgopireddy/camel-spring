package org.my.dev;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer orderItemId;
    private Integer orderItemQuantity;
    private String orderItemPublisherName;
	private BigDecimal orderItemPrice;

	public Integer getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(Integer quantity) {
		this.orderItemQuantity = quantity;
	}

	public BigDecimal getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(BigDecimal extPrice) {
		this.orderItemPrice = extPrice;
	}


	public Integer getorderItemId() {
		return orderItemId;
	}


    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getOrderItemPublisherName() {
        return orderItemPublisherName;
    }

    public void setOrderItemPublisherName(String orderItemPublisherName) {
        this.orderItemPublisherName = orderItemPublisherName;
    }



	
}