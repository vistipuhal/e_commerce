# e_commerce : Spring boot Rest API for e commerce website with CRUD operations on Orders and Items 


### README file describing the controller endpoints for the e-commerce API


#### Controller Endpoints:


#### For inserting item in db:http://localhost:8082/omnicuris/api/items/create (POST)

**Request**

```
	{
        	"id": 1,
        	"name": "Samsung Galaxy",
        	"price": 20000,
        	"imageURL": "http://samsung.com/picture/galaxy"
	}
```
	
#### For fetching item with id : http://localhost:8082/omnicuris/api/item/find/{itemID} (GET)

#### For getting all items: http://localhost:8082/omnicuris/api/item/find/all (GET)

#### For deleting item by id: http://localhost:8082/omnicuris/api/item/delete/{itemID}(DELETE)


#### For creating order : http://localhost:8082/omnicuris/api/order/create (POST)
**Request**
```
{
	"itemList":[
	{
		"item":
		{
        	"id": 1,
        	"name": "Samsung Galaxy",
        	"price": 20000,
        	"imageURL": "http://samsung.com/picture/galaxy"
		},
		"quantity": 1
		
	}
	]
	
}
```
#### For fetching all orders : http://localhost:8082/omnicuris/api/order/find/all (GET)
