import { NgModule } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { FoodPageComponent } from './food-page/food-page.component';
import { HomeComponent } from './home/home.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { LoginRegisterComponent } from './login-register/login-register.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'search/:searchTerm', component: HomeComponent
  },
  {
    path: 'tag/:tag', component: HomeComponent
  },
  {
    path: 'food/:name', component: FoodPageComponent
  },
  {
    path: 'cart-page', component: CartPageComponent
  },
  {
    path: 'login', component: LoginRegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  constructor(private router: Router) {
    this.router.errorHandler = (error: any) => {
        this.router.navigate(['']); // or redirect to default route
    }
  }
}
