import { AddressDTO } from "./AddressDTO";
import { PizzaOrderDTO } from "./PizzaOrderDTO";

export class OrdersDTO {
    userName: String;
    mail: String;
    phoneNumber: String;
    addressDTO: AddressDTO = new AddressDTO();
    pizzaOrderDTO: PizzaOrderDTO[] = [];
    totalPrice: Number;
}