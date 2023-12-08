import {Component, Input} from '@angular/core';
import {RestaurantDTO} from "../../types/restaurant.types";
import {NgForOf, NgIf} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-restaurants-table',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    RouterLink
  ],
  templateUrl: './restaurants-table.component.html',
  styleUrl: './restaurants-table.component.css'
})
export class RestaurantsTableComponent {
  @Input() restaurants: RestaurantDTO[] = [];

  constructor(
  ) {
  }
}
