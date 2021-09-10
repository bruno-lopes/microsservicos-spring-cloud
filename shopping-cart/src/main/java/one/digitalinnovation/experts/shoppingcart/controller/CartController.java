package one.digitalinnovation.experts.shoppingcart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import one.digitalinnovation.experts.shoppingcart.model.Cart;
import one.digitalinnovation.experts.shoppingcart.model.Item;
import one.digitalinnovation.experts.shoppingcart.repository.CartRepository;

@RestController
@RequestMapping(value = "/cart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {
    
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        cart = savedCart.orElse(Cart.builder().id(id).build());
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }


}
