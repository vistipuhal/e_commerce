package in.example.omnicuris.restapi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

@Table(name = "orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreated;

	private String status;
	private String email;

	@OneToMany(mappedBy = "orderProductDDO.order")
	@Valid
	private List<OrderProduct> orderProducts = new ArrayList<>();

	@Transient
	public Double getTotalOrderPrice() {
		double sum = 0;
		sum=getOrderProducts().stream().mapToDouble(op->op.getTotalPrice()).sum();
		return sum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@Transient
	public int getNumberOfProducts() {
		return this.orderProducts.size();
	}
	

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateCreated=" + dateCreated + ", status=" + status + ", orderProducts="
				+ orderProducts + "]";
	}

}
