import {Component} from '@angular/core';
import {RestaurantService} from "../../services/restaurant.service";
import {RestaurantDTO} from "../../types/restaurant.types";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-restaurants-table',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './restaurants-table.component.html',
  styleUrl: './restaurants-table.component.css'
})
export class RestaurantsTableComponent {
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
      })
    });
  }

  private getImage(restaurant : RestaurantDTO) : void {
    this.restaurantService.getImageUrl(restaurant.id).subscribe(url => {
      restaurant.imageUrl = url;
    })
  }

  // public createActeur(acteur: IActeurCreate) : void {
  //   this.acteurService.createActeur(acteur).subscribe(value => {
  //     this.acteurs.push(value);
  //     this.ntfService.success("Création de l'acteur avec succès")
  //   }, () => this.ntfService.error("Création de l'acteur avec erreur"))
  // }

}
