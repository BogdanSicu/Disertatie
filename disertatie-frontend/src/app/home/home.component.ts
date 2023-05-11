import { Component, OnInit } from '@angular/core';
import { FoodService } from '../services/food/food.service';
import { Food } from '../shared/models/Food';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { Observable, finalize, tap } from 'rxjs';

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
      this.route.params.subscribe(
        params => {
          this.getAllFoods().subscribe(() => {
            if(params['searchTerm']) {
              this.foods = this.foodService.getAllFoodsBySearchTerm(params['searchTerm'], this.baseFoods);
            } else if(params['tag']) {
              this.foods = this.foodService.getAllFoodByTag(params['tag'], this.baseFoods);
            } else {
              this.foods = this.baseFoods;
            }
          });
        }
      );
    }
    
    getAllFoods(): Observable<any> {
      this.isLoaded = true;
      return this.foodService.getAllFoodRequest().pipe(
        tap(response => {
          if(this.baseFoods.length < 1) {
            this.baseFoods = response;
            this.foods = response;
          }
        }),
        finalize(() => {
          console.log(this.foods);
          this.isLoaded = false;
        })
      );
    }
       
}
