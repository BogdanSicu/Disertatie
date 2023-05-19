import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart/cart.service';
import { Cart } from '../shared/models/Cart';
import { CartItem } from '../shared/models/CartItem';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {

  cart!: Cart;

  name: String;
  mail: String;
  phoneNumber: String;
  country: String;
  city: String;
  street: String;
  streetNumber: Number;
  building: String;
  room: Number;


  constructor(private cartService: CartService) {
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
    console.log(this.name);
    console.log(this.mail);
    console.log("0" + this.phoneNumber);
    console.log(this.country);
    console.log(this.city);
    console.log(this.street);
    console.log(this.streetNumber);
    console.log(this.building);
    console.log(this.room);
  }

}
