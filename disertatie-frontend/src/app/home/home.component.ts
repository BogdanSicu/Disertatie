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
    this.route.params.subscribe(
      params => {
        if(params['searchTerm']) {
          this.foods = this.foodService.getAllFoodsBySearchTerm(params['searchTerm']);
          // console.log(this.foods) 
        } else if(params['tag']) {
          this.foods = this.foodService.getAllFoodByTag(params['tag']);
          // console.log(this.foods) 
        } else {
            this.foods = this.foodService.getAll();
            console.log(this.foods) 
        }
        
      }
    )
  }



}
