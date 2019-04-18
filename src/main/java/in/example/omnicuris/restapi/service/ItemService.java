package in.example.omnicuris.restapi.service;

import org.springframework.validation.annotation.Validated;

import in.example.omnicuris.restapi.model.Item;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ItemService {

    @NotNull Iterable<Item> getAllProducts();

    Item getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Item save(Item product);
}
