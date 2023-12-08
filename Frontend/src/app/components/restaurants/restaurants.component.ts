import {Component, OnInit} from '@angular/core';
import {RestaurantsFormComponent} from "../restaurants-form/restaurants-form.component";
import {RestaurantsTableComponent} from "../restaurants-table/restaurants-table.component";
import {RestaurantCreateDTO, RestaurantDTO} from "../../types/restaurant.types";
import {RestaurantService} from "../../services/restaurant.service";

@Component({
  selector: 'app-restaurants',
  standalone: true,
  imports: [
    RestaurantsFormComponent,
    RestaurantsTableComponent
  ],
  templateUrl: './restaurants.component.html',
  styleUrl: './restaurants.component.css'
})
export class RestaurantsComponent implements OnInit{
  public restaurants: RestaurantDTO[] = [];


  constructor(
    private readonly restaurantService: RestaurantService,
  ) {
  }

  ngOnInit(): void {
    this.getRestaurants();
  }

  private getRestaurants(): void {
    this.restaurantService.getRestaurants().subscribe(restaurants => {
      this.restaurants = restaurants;
      restaurants.forEach(restaurant => {
        this.getImage(restaurant)
        console.log(restaurant)
      })
    });
  }

  private getImage(restaurant: RestaurantDTO): void {
    this.restaurantService.getImageUrl(restaurant.id).subscribe(url => {
      restaurant.imageUrl = url;
    })
  }

  private postRestaurant(restaurant: RestaurantCreateDTO): void {
    this.restaurantService.createRestaurant(restaurant).subscribe(restaurant => {
      this.restaurants.push(restaurant);
        this.getImage(restaurant)
    });
  }

  createRestaurant(restaurant: RestaurantCreateDTO) {
    this.postRestaurant(restaurant)
  }
}
