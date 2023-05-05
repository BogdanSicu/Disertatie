import { Food } from "./Food";

export class CartItem {

    food: Food;
    quantity: number = 1;
    price: number = 0;

    constructor(food: Food) {
        this.food = food;
    }

    public setTotalPrice() {
        this.price = this.food.price * this.quantity;
    }
}