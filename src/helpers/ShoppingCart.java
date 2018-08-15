package helpers;

import java.util.ArrayList;
import java.util.List;

import db.Item;

public class ShoppingCart {
//	Attributes:
	private List<Item> _items = new ArrayList<>();

// 	Constructors:
	public ShoppingCart() {
	}// c-tor

//	Methods:
	public void addItem(Item item) {
		_items.add(item);
	}

	public void removeItem(Item item) {
		_items.remove(item);
	}

	public Item[] getItems() {
		return (Item[]) _items.toArray();
	}

	public void clear() {
		_items.clear();
	}
}// ShoppingCart
