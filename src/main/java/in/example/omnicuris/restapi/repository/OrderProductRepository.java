package in.example.omnicuris.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import in.example.omnicuris.restapi.model.OrderProduct;
import in.example.omnicuris.restapi.model.OrderProductDDO;



@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductDDO> {

}
