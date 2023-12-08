import { Component } from '@angular/core';
import {RestaurantService} from "../../services/restaurant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {RestaurantDTO} from "../../types/restaurant.types";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-restaurant-detail',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './restaurant-detail.component.html',
  styleUrl: './restaurant-detail.component.css'
})
export class RestaurantDetailComponent {
  private id : string = this.activatedRoute.snapshot.params["id"]

  restaurant?: RestaurantDTO;
  imageUrl?: string;


  constructor(
    private readonly restaurantService: RestaurantService,
    private readonly activatedRoute : ActivatedRoute,
    private readonly router : Router
  ) {}

  ngOnInit() : void {
    this.getRestaurant(this.id);
  }

  private getRestaurant(id : string) : void {
    this.restaurantService.getRestaurant(id).subscribe((restaurant : RestaurantDTO) => {
      this.restaurant = restaurant;
      this.getImage()
    }, () => this.router.navigate([`404`]))
  }

  private getImage() : void {
    this.restaurantService.getImageUrl(Number(this.id)).subscribe((url : string) => {
      this.imageUrl = url;
    })
  }

}
