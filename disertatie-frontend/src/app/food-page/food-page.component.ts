import { Component, OnInit } from '@angular/core';
import { Food } from '../shared/models/Food';
import { FoodService } from '../services/food/food.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-food-page',
  templateUrl: './food-page.component.html',
  styleUrls: ['./food-page.component.css']
})
export class FoodPageComponent implements OnInit {

  food!: Food;
  isLoaded: Boolean = false;

  constructor(private foodService: FoodService,
              private activatedRoute: ActivatedRoute) { 

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

}
