import { Injectable } from '@angular/core';
import { Food } from 'src/app/shared/models/Food';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor() { }

  getAll():Food[] {
    return [
      {
        id: 1,
        name: 'Pizza All Cheese',
        cookTime: '10-20',
        price: 10,
        favorite: false,
        ingredients: ['ingredient1'],
        stars: 4.5,
        imageUrl: "./assets/pizza_all_cheese.png",
        tags: ['FastFood', 'Pizza', 'Lunch'],
      },
      {
        id: 2,
        name: 'Pizza Argentina',
        price: 20,
        cookTime: '20-30',
        favorite: true,
        ingredients: ['ingredient1', 'ingredient2', 'ingredient3', 'ingredient4', 'ingredient5'],
        stars: 4.7,
        imageUrl: './assets/pizza_argentina.png',
        tags: ['SlowFood', 'Lunch'],
      },
      {
        id: 3,
        name: 'Pizza Carnivor',
        price: 5,
        cookTime: '10-15',
        favorite: false,
        ingredients: ['ingredient1', 'ingredient2'],
        stars: 3.5,
        imageUrl: './assets/pizza_carnivor.png',
        tags: ['FastFood', 'Hamburger'],
      },
      {
        id: 4,
        name: 'Pizza Clasic',
        price: 2,
        cookTime: '15-20',
        favorite: true,
        ingredients: ['ingredient1', 'ingredient2'],
        stars: 3.3,
        imageUrl: './assets/pizza_clasic.png',
        tags: ['FastFood', 'Fry'],
      },
      {
        id: 5,
        name: 'Pizza Double Pepperoni',
        price: 11,
        cookTime: '40-50',
        favorite: false,
        ingredients: ['ingredient1', 'ingredient2'],
        stars: 3.0,
        imageUrl: './assets/pizza_double_pepperoni.png',
        tags: ['SlowFood', 'Soup'],
      },
      {
        id: 6,
        name: 'Pizza Rustic',
        price: 9,
        cookTime: '40-50',
        favorite: false,
        ingredients: ['ingredient1'],
        stars: 4.0,
        imageUrl: './assets/pizza_rustic.png',
        tags: ['FastFood', 'Pizza', 'Lunch'],
      },
    ];
  }
}
