import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Food } from 'src/app/shared/models/Food';
import { Tag } from 'src/app/shared/models/Tag';
import { DomSanitizer } from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  readonly ROOT_URL = 'http://localhost:8080';
  private foods: Food[] = [];

  constructor(private http: HttpClient, private _sanitizer: DomSanitizer) { }

  getAll():Food[] {
    if(this.foods.length == 0)
    this.testRequest();
    return this.foods;
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

  private testRequest() {
    this.http.get(this.ROOT_URL + "/api/food/get-all-food-test")
    .pipe(
      map(response => {
        const responseArray = [];
        for(const key in response) {
          
          if(response.hasOwnProperty(key)){

            let ingredients = [];
            for(let i=0; i<response[key].ingredients.length; i++) {
              ingredients.push(response[key].ingredients[i].name);
            }

            let tags = [];
            for(let i=0; i<response[key].tags.length; i++) {
              tags.push(response[key].tags[i].name);
            }

            let myImage = this._sanitizer
            .bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + response[key].image)

            responseArray.push({
              id: key, 
              cookTime: response[key].cookTime, 
              name: response[key].name,
              ingredients: ingredients,
              tags: tags,
              price: response[key].price,
              imageUrl: myImage
            })
          
          }
        }
        return responseArray
      })
    )
    .subscribe(response => {
      this.foods = response;
    })
  }

}
