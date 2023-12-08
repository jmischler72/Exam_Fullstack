import {Component, EventEmitter, Input, Output} from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {RestaurantCreateDTO} from "../../types/restaurant.types";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-restaurants-form',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './restaurants-form.component.html',
  styleUrl: './restaurants-form.component.css'
})
export class RestaurantsFormComponent {

  @Input() restaurant: RestaurantCreateDTO = {
    nom: "Nouveau restaurant",
    adresse: "15 rue test",
    tags: []
  };

  @Output() public createRestaurant: EventEmitter<RestaurantCreateDTO> = new EventEmitter();

  tags: string[] = ["Bistronomique", "Gastronomique", "Bistrot", "Brasserie", "Fastfood"];

  //Object.keys ne fonctionne pas

  constructor() {
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      console.log(this.restaurant);
      this.createRestaurant.emit(this.restaurant)
      form.reset(this.restaurant)
    }
  }

  onCheckChange(event: Event) {
    const ischecked = (<HTMLInputElement>event.target).checked;
    const value: string = (<HTMLInputElement>event.target).value;

    if (ischecked) {
      this.restaurant.tags.push(value);
    } else {
      this.restaurant.tags.filter((item) => item != value);
    }
  }
}
