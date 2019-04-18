package in.example.omnicuris.restapi.service;


import org.springframework.validation.annotation.Validated;

import in.example.omnicuris.restapi.model.OrderProduct;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The items for order cannot be null.") @Valid OrderProduct orderProduct);
}
