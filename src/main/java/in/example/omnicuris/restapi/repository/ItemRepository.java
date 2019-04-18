package in.example.omnicuris.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.example.omnicuris.restapi.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
