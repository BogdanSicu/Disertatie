import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Food } from 'src/app/shared/models/Food';
import { DomSanitizer } from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  readonly ROOT_URL = 'http://localhost:8080';

  constructor(private http: HttpClient, private _sanitizer: DomSanitizer) { }

  getAllFoodByTag(tag: string, foods: Food[]): Food[] {
    return tag=="All" ? 
      foods : 
        foods.filter(food => food.tags?.includes(tag));
  }

  getAllFoodsBySearchTerm(searchTerm: string, foods: Food[]): Food[] {
    return searchTerm.length < 1 ? foods : foods
                .filter( food => food.name.toLowerCase().includes(searchTerm.toLowerCase()));
  }

  getAllFoodRequest(): Observable<Food[]> {
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

            responseArray.push({
              id: key, 
              cookTime: response[key].cookTime, 
              name: response[key].name,
              ingredients: responseIngredients,
              tags: responseTags,
              price: response[key].price,
              imageUrl: response[key].image
            })
          
          }
        }
        console.log("Request observable");
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
        
        food.imageUrl = response['image'];
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
