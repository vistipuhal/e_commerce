package in.example.omnicuris.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import in.example.omnicuris.restapi.dto.ItemDTO;
import in.example.omnicuris.restapi.exceptions.NotFoundException;
import in.example.omnicuris.restapi.model.Item;
import in.example.omnicuris.restapi.model.Order;
import in.example.omnicuris.restapi.model.OrderProduct;
import in.example.omnicuris.restapi.model.OrderRequest;
import in.example.omnicuris.restapi.repository.ItemRepository;
import in.example.omnicuris.restapi.service.ItemService;
import in.example.omnicuris.restapi.service.OrderProductService;
import in.example.omnicuris.restapi.service.OrderService;



@RequestMapping("/api")
@Controller
public class RestEndpointController {


	@Autowired
	ItemRepository itemRepository;
	@Autowired
	ItemService productService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderProductService orderProductService;



	@GetMapping("order/find/all")
	public ResponseEntity<?> listOrders() {
	 Iterable<Order> orders = orderService.getAllOrders();
		long size = orders.spliterator().getExactSizeIfKnown();
		if (size == 0) {
			throw new NotFoundException("There are No Orders in the Database");
		}
		return new ResponseEntity<>(orders,HttpStatus.ACCEPTED);
	}

	@PostMapping("order/create")
	public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
		List<ItemDTO> itemList = orderRequest.getItemList();
		Order order = new Order();
		order.setStatus("Paid");
		orderService.create(order);

		List<OrderProduct> orderProducts = new ArrayList<>();
		for (ItemDTO dto : itemList) {
			orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
					.getItem()
					.getId()), dto.getQuantity())));
		}

		order.setOrderProducts(orderProducts);
		orderService.update(order);
		return new ResponseEntity<>("Order Created", HttpStatus.CREATED);
	}
 
	
/**
 * ===============================
 * 
 * Item Controller
 * 
 * ===============================
 * 
 */


	@GetMapping("/item/find/all")
	public ResponseEntity<?> findAllItems() {
		Iterable<Item> items = itemRepository.findAll();
		long size = items.spliterator().getExactSizeIfKnown();
		if (size == 0) {
			throw new NotFoundException("There are No items in the Database");
		}
		return new ResponseEntity<>(items,HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/item/find/{itemID}")
	public Item findItem(@PathVariable("itemID") Long itemID) {
		Optional<Item> optionalItem =  itemRepository.findById(itemID);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		}
		else{
			throw new NotFoundException("Item Code-" + itemID);
		}
	}

	@PostMapping("/item/create")
	public ResponseEntity<?> createItem(@RequestBody  Item item) {
		Item insert = itemRepository.save(item);
		if (insert.getId() != null) {
			return new ResponseEntity<>("Item creation Successful",HttpStatus.OK);
		} 
		return new ResponseEntity<>("Item creation UnSuccessful",HttpStatus.INTERNAL_SERVER_ERROR);
			
	}

	@DeleteMapping(path = "item/delete/{itemID}")
	public void deleteItem(@PathVariable("itemID") Long itemID) {
		itemRepository.deleteById(itemID);
	}

	@PutMapping(path = "item/update")
	public ResponseEntity<?> updateItem( @RequestBody Item item)  {
		if (itemRepository.existsById(item.getId())) {
			return new ResponseEntity<>( itemRepository.save(item),HttpStatus.OK);
		} else {
			throw new NotFoundException("item can't be found . since not updated");
		}
	}

}



