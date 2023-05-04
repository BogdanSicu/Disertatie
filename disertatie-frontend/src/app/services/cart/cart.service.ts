import { Injectable } from '@angular/core';
import { Cart } from 'src/app/shared/models/Cart';
import { CartItem } from 'src/app/shared/models/CartItem';
import { Food } from 'src/app/shared/models/Food';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private cart: Cart = new Cart();

  addToCart(food: Food): void {
    let cartItem = this.cart.items.find(item => item.food.name === food.name)

    if(cartItem) {
      this.changeQuantity(food.name, cartItem.quantity + 1);
      console.log(this.cart);
      return;
    }

    this.cart.items.push(new CartItem(food));
    console.log(this.cart);

    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  removeFromCart(foodName: string): void {
    this.cart.items = this.cart.items.filter(item => item.food.name != foodName);
    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  changeQuantity(foodName: string, quantity: number) {
    let cartItem = this.cart.items.find(item => item.food.name === foodName);

    if(!cartItem) {
      return;
    }

    cartItem.quantity = quantity;
    localStorage.setItem("cart", JSON.stringify(this.cart));
    console.log(this.cart);
  }

  getCart(): Cart {
    console.log(localStorage.getItem("cart"));
    this.cart = JSON.parse(localStorage.getItem("cart"));
    return this.cart;
  }
}
