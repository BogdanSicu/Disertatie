import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
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

  // getAllFoodByTag(tag: string): Food[] {
  //   return tag=="All" ? 
  //     this.getAll() : 
  //       this.getAll().filter(food => food.tags?.includes(tag));
  // }

  // getAllFoodsBySearchTerm(searchTerm: string): Food[] {
  //   return this.getAll()
  //               .filter( food => food.name.toLowerCase().includes(searchTerm.toLowerCase()));
  // }

  // getFoodById(id: number): Food {
  //   return this.getAll().find(food => food.id == id)!;
  // }

  getAllFoodByTag(tag: string, foods: Food[]): Food[] {
    this.foods = foods;
    return tag=="All" ? 
      foods : 
        foods.filter(food => food.tags?.includes(tag));
  }

  getAllFoodsBySearchTerm(searchTerm: string, foods: Food[]): Food[] {
    this.foods = foods;
    return foods
                .filter( food => food.name.toLowerCase().includes(searchTerm.toLowerCase()));
  }

  getFoodById(id: number): Food {
    return this.foods.find(food => food.id == id)!;
  }

  testRequest(): Observable<Food[]> {
    return this.http.get(this.ROOT_URL + "/api/food/get-all-food-test")
    .pipe(
      map(response => {
        const responseArray = [];
        for(const key in response) {
          
          if(response.hasOwnProperty(key)){

            let responseIngredients = [];
            for(let i=0; i<response[key].ingredients.length; i++) {
              responseIngredients.push(response[key].ingredients[i].name);
            }

            let responseTags = [];
            for(let i=0; i<response[key].tags.length; i++) {
              responseTags.push(response[key].tags[i].name);
            }

            let myImage = this._sanitizer
            .bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + response[key].image)

            responseArray.push({
              id: key, 
              cookTime: response[key].cookTime, 
              name: response[key].name,
              ingredients: responseIngredients,
              tags: responseTags,
              price: response[key].price,
              imageUrl: myImage
            })
          
          }
        }
        return responseArray
      })
    )
  }

  getFoodByNameRequest(foodName: string) : Observable<Food> {
    return this.http.get(this.ROOT_URL + "/api/food/get-food-by-name", 
    {params: {
      name: foodName
    }})
    .pipe(
      map(response => {
        let food:Food = new Food();
        
        let responseIngredients = [];
        for(let i=0; i<response['ingredients'].length; i++) {
          responseIngredients.push(response['ingredients'][i].name);
        }

        let responseTags = [];
        for(let i=0; i<response['tags'].length; i++) {
          responseTags.push(response['tags'][i].name);
        }

        let myImage = this._sanitizer
            .bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + response['image'])
        
        food.imageUrl = myImage;
        food.cookTime = response['cookTime'];
        food.ingredients = responseIngredients;
        food.tags = responseTags;
        food.name = response['name'];
        food.price = response['price'];
        return food;

      })
    )
  }

}
