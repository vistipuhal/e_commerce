package in.example.omnicuris.restapi.model;

import java.util.List;

import in.example.omnicuris.restapi.dto.ItemDTO;

public class OrderRequest {
	
		
        private List<ItemDTO> itemList;
        
	
		public List<ItemDTO> getItemList() {
			return itemList;
		}
		public void setItemList(List<ItemDTO> itemList) {
			this.itemList = itemList;
		}

       
    }

