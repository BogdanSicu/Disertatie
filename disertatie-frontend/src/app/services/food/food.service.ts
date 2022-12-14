import { Injectable } from '@angular/core';
import { Food } from 'src/app/shared/models/Food';
import { Tag } from 'src/app/shared/models/Tag';

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
      {
        id: 7,
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
        id: 8,
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
        id: 9,
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
        id: 10,
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
        id: 11,
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
        id: 12,
        name: 'Pizza Rustic',
        price: 9,
        cookTime: '40-50',
        favorite: false,
        ingredients: ['ingredient1'],
        stars: 4.0,
        imageUrl: './assets/pizza_rustic.png',
        tags: ['FastFood', 'Pizza', 'Lunch'],
      },
      {
        id: 13,
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
        id: 14,
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
        id: 15,
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
        id: 16,
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
        id: 17,
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
        id: 18,
        name: 'Pizza Rustic',
        price: 9,
        cookTime: '40-50',
        favorite: false,
        ingredients: ['ingredient1'],
        stars: 4.0,
        imageUrl: './assets/pizza_rustic.png',
        tags: ['FastFood', 'Pizza', 'Lunch'],
      },
      {
        id: 19,
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
        id: 20,
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
        id: 21,
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
        id: 22,
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
        id: 23,
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
        id: 24,
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
  
  getAllTag():Tag[] {
    // numarul trebuie calculat pe server - cate mancaruri au tagurile respective
    return [
      {name: 'All', count: 14},
      {name: 'FastFood', count: 4},
      {name: 'Pizza', count: 2},
      {name: 'Lunch', count: 3},
      {name: 'SlowFood', count: 2},
      {name: 'Hamburger', count: 1},
      {name: 'Fry', count: 1},
      {name: 'Soup', count: 1},
    ];
  }

  getAllFoodByTag(tag: string): Food[] {
    return tag=="All" ? 
      this.getAll() : 
        this.getAll().filter(food => food.tags?.includes(tag));
  }

  getAllFoodsBySearchTerm(searchTerm: string): Food[] {
    return this.getAll()
                .filter( food => food.name.toLowerCase().includes(searchTerm.toLowerCase()));
  }

  getFoodById(id: number): Food {
    return this.getAll().find(food => food.id == id)!;
  }

}
