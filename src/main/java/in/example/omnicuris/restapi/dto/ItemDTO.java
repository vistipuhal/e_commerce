package in.example.omnicuris.restapi.dto;

import in.example.omnicuris.restapi.model.Item;

public class ItemDTO {

    private Item item;
    private Integer quantity;

   
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
