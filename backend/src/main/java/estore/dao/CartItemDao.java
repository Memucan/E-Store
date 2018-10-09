package estore.dao;

import estore.model.Cart;
import estore.model.CartItem;
import estore.model.CustomerOrder;

public interface CartItemDao {
	
	void saveOrUpdateCartItem(CartItem cartItem);
	
	void removeCartItem(int cartItemId);
	
	Cart getCart(int cartId);
	
	CustomerOrder createOrder(Cart cart);

}
