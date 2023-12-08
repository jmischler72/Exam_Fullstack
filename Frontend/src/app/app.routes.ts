import {Routes} from '@angular/router';
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {RestaurantsComponent} from "./components/restaurants/restaurants.component";
import {RestaurantDetailComponent} from "./components/restaurant-detail/restaurant-detail.component";

export const routes: Routes = [
  {path: "", component: RestaurantsComponent},
  {path: "restaurant/:id", component: RestaurantDetailComponent},
  {path: "404", component: NotFoundComponent},
  {path: "**", redirectTo: "/404"}
];
