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
      return;
    }

    let newItem = new CartItem(food);
    newItem.setTotalPrice();

    this.cart.items.push(newItem);

    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  removeFromCart(foodName: string): void {
    this.cart.items = this.cart.items.filter(item => item.food.name != foodName);
    this.cart.totalPrice = 0;
    this.cart.items.forEach(element => {
      this.cart.totalPrice += element.price;
    });
    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  removeAllCartItems(): void {
    this.cart = new Cart();
    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  changeQuantity(foodName: string, quantity: number) {
    let cartItem = this.cart.items.find(item => item.food.name === foodName);

    if(!cartItem) {
      return;
    }

    cartItem.quantity = quantity;
    cartItem.price = cartItem.food.price * cartItem.quantity
    // cartItem.setTotalPrice(); -> because TS is JS with types and JS is stupid
    this.cart.totalPrice = 0;
    this.cart.items.forEach(element => {
      this.cart.totalPrice += element.price;
    });
    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  getCart(): Cart {
    this.cart = JSON.parse(localStorage.getItem("cart"));
    // this.cart.setTotalPrice(); -> because JS is stupid
    this.cart.totalPrice = 0;
    this.cart.items.forEach(element => {
      this.cart.totalPrice += element.price;
    });
    return this.cart;
  }
}
