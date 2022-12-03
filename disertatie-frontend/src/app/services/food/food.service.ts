import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor() { }

  getAll():String[] {
    return [
      "./assets/pizza_all_cheese.png",
      "./assets/pizza_argentina.png",
      "./assets/pizza_carnivor.png",
      "./assets/pizza_clasic.png",
      "./assets/pizza_double_pepperoni.png",
      "./assets/pizza_rustic.png"
    ]
  }
}
