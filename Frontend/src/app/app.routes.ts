import {Routes} from '@angular/router';
import {RestaurantsTableComponent} from "./components/restaurants-table/restaurants-table.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";

export const routes: Routes = [
  {path: "", component: RestaurantsTableComponent},
  {path: "404", component: NotFoundComponent},
  {path: "**", redirectTo: "/404"}
];
