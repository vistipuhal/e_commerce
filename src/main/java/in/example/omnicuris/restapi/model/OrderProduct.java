package in.example.omnicuris.restapi.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderProduct {

    @EmbeddedId
    @JsonIgnore
    private OrderProductDDO orderProductDDO;


	@Column(nullable = false) 
    private Integer quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(Order order, Item product, Integer quantity) {
        orderProductDDO = new OrderProductDDO();
        orderProductDDO.setOrder(order);
        orderProductDDO.setProduct(product);
        this.quantity = quantity;
    }

    @Transient
    public Item getProduct() {
        return this.orderProductDDO.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }


    public OrderProductDDO getOrderProductDDO() {
		return orderProductDDO;
	}

	public void setOrderProductDDO(OrderProductDDO orderProductDDO) {
		this.orderProductDDO = orderProductDDO;
	}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	@Override
	public String toString() {
		return "OrderProduct [orderproductddo=" + orderProductDDO + ", quantity=" + quantity + "]";
	}

}
