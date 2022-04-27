package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.ShoppingCartDto;
import com.ecommerce.project.laptop.entitty.ShoppingCart;
import com.ecommerce.project.laptop.services.ShoppingCartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CartController {

private final ShoppingCartServiceImpl shopCartService;
    /*

     */
    @GetMapping("/carts")
    public ResponseEntity<?> getAllCart() {
        List<ShoppingCart> shoppingCarts=shopCartService.getALlShoppingCart();
        if(!shoppingCarts.isEmpty()){
            List<ShoppingCartDto> shoppingCartDtos=new ArrayList<>();
            shoppingCarts.forEach(shoppingCart -> shoppingCartDtos.add(new ShoppingCartDto(shoppingCart)));
            return ResponseEntity.status(HttpStatus.OK).body(shoppingCarts);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data ");
        }

    }

    /*

     */
    @GetMapping("/cart/{id}")
    public ResponseEntity<?> getCartById(@PathVariable long id) {
        ShoppingCart shoppingCart = shopCartService.getShoppingCartById(id);
        if(shoppingCart!=null){
            return new ResponseEntity<>(shoppingCart,HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data");
    }

    /*

     */
    @DeleteMapping("/cart/{id}")
    public ResponseEntity<?> deleteCartById(@PathVariable long id) {
        if (shopCartService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("delete success data by request url");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found data");
        }
    }

    /*

     */
    @PostMapping(value = "/cart")
    public ResponseEntity<?> saveShoppingCart( @ModelAttribute("shopcartdto") ShoppingCartDto shoppingCartDto) {
        if(shoppingCartDto!=null){
            ShoppingCart shoppingCart=ShoppingCart.builder()
                    .quantity(1)
                    .build();
            shopCartService.saveShoppingCart(shoppingCart);
            return ResponseEntity.status(HttpStatus.CREATED).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request url invalid data ");

    }

    /*

     */
    @PutMapping(value = "/cart")
    public ResponseEntity<?> updateShoppingCart( @ModelAttribute("shopcartdto") ShoppingCartDto shoppingCartDto){
        if(shoppingCartDto!=null){
            ShoppingCart shoppingCart=ShoppingCart.builder()
                    .quantity(1)
                    .build();
            shopCartService.saveShoppingCart(shoppingCart);
            return ResponseEntity.status(HttpStatus.CREATED).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request url invalid data ");

    }

}
