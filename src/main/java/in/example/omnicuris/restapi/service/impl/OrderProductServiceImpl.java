package in.example.omnicuris.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.example.omnicuris.restapi.model.OrderProduct;
import in.example.omnicuris.restapi.repository.OrderProductRepository;
import in.example.omnicuris.restapi.service.OrderProductService;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {
	@Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
