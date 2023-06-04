import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart/cart.service';
import { Cart } from '../shared/models/Cart';
import { CartItem } from '../shared/models/CartItem';
import { PizzaOrderDTO } from '../shared/models/PizzaOrderDTO';
import { OrdersDTO } from '../shared/models/OrdersDTO';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {

  cart!: Cart;

  ordersDTO: OrdersDTO = new OrdersDTO();

  readonly ROOT_URL = 'http://localhost:8080';

  constructor(private cartService: CartService, private http: HttpClient) {
    this.setCart();
  }

  ngOnInit(): void {
  }

  setCart() {
    this.cart = this.cartService.getCart();
  }

  removeFromCart(cartItem: CartItem) {
    this.cartService.removeFromCart(cartItem.food.name);
    this.setCart();
  }

  changeQuantity(cartItem: CartItem, quantityInString: string) {
    const quantity = parseInt(quantityInString);

    this.cartService.changeQuantity(cartItem.food.name, quantity);
  }

  order() {
    for(let i = 0; i<this.cart.items.length; i++) {
      let requestPizza: PizzaOrderDTO = new PizzaOrderDTO();
      requestPizza.name = this.cart.items[i].food.name;
      requestPizza.quantity = this.cart.items[i].quantity;

      this.ordersDTO.pizzaOrderDTO.push(requestPizza);
    }

    this.ordersDTO.totalPrice = this.cart.totalPrice;

    console.log(this.ordersDTO);
    this.orderRequest();
    this.ordersDTO =  new OrdersDTO();
    this.cart = new Cart();

  }

  orderRequest() {
    return this.http.post(this.ROOT_URL + "/api/orders/order-food", this.ordersDTO).subscribe();
  }

}
