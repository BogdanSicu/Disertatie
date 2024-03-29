import { Component, OnInit } from '@angular/core';
import { Food } from '../shared/models/Food';
import { FoodService } from '../services/food/food.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../services/cart/cart.service';

@Component({
  selector: 'app-food-page',
  templateUrl: './food-page.component.html',
  styleUrls: ['./food-page.component.css']
})
export class FoodPageComponent implements OnInit {

  food!: Food;
  isLoaded: Boolean = false;
  foodImage: string = "pizza_all_cheese.png";

  constructor(private foodService: FoodService,
              private activatedRoute: ActivatedRoute,
              private cartService: CartService,
              private router: Router) { 

      activatedRoute.params.subscribe(
        (params) => {
          if(params['name']) {
            this.isLoaded = true;
            this.foodService.getFoodByNameRequest(params['name']).subscribe( response => {
              this.food = response;
              this.isLoaded = false;
              console.log(this.food);
            })
          }
        }
      )
  }

  ngOnInit(): void {
  }

  addToCart() {
    this.cartService.addToCart(this.food);
  }

}
