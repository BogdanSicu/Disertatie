import { Component, OnInit } from '@angular/core';
import { FoodService } from '../services/food/food.service';
import { Food } from '../shared/models/Food';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  foods:Food[] = [];
  baseFoods: Food[] = [];
  isLoaded: Boolean = false;

  constructor(
    private foodService:FoodService, 
    private route: ActivatedRoute,
    private router: Router) {
      
    }

    private history: string[] = [];

    public startSaveHistory():void {
      this.router.events.subscribe((event) => {
        if(event instanceof NavigationEnd) {
          this.history.push(event.urlAfterRedirects)
        }
      })
    }

  ngOnInit(): void {
    this.foodService.getFoodByNameRequest('Pizza All Cheese')
    this.getAllFoods();
    this.route.params.subscribe(
      params => {
        if(params['searchTerm']) {
          this.foods = this.foodService.getAllFoodsBySearchTerm(params['searchTerm'], this.baseFoods);
        } else if(params['tag']) {
          this.foods = this.foodService.getAllFoodByTag(params['tag'], this.baseFoods);
        } else {
            this.foods = this.baseFoods;
        }
      }
    )
  }

  getAllFoods() {
    this.isLoaded = true;
    this.foodService.getAllFoodRequest().subscribe( response => {
      if(this.baseFoods.length < 1) {
        this.baseFoods = response;
        this.foods = response;
        this.isLoaded = false;
      }
    })
  }



}
