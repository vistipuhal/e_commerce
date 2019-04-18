package in.example.omnicuris.restapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.example.omnicuris.restapi.exceptions.NotFoundException;
import in.example.omnicuris.restapi.model.Item;
import in.example.omnicuris.restapi.repository.ItemRepository;
import in.example.omnicuris.restapi.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {


    private ItemRepository productRepository;

    public ItemServiceImpl(ItemRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Item> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Item getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new NotFoundException("Item not found"));
    }

    @Override
    public Item save(Item product) {
        return productRepository.save(product);
    }
}
