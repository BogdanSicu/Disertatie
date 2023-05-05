import { CartItem } from "./CartItem";

export class Cart {
    items: CartItem[] = [];
    totalPrice: number = 0;

    public setTotalPrice() {

        let price = 0;
        this.items.forEach(item => {
            price += item.price;
        })
        this.totalPrice = price;
    }
}