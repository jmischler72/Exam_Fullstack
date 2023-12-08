import {Component, OnInit} from '@angular/core';
import {RestaurantService} from "../../services/restaurant.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {RestaurantDTO, RestaurantUpdateDTO} from "../../types/restaurant.types";
import {NgForOf, NgIf} from "@angular/common";
import {RestaurantsFormComponent} from "../restaurants-form/restaurants-form.component";
import {EvaluationDetailComponent} from "../evaluation-detail/evaluation-detail.component";
import {ImageDTO} from "../../types/image.types";

@Component({
  selector: 'app-restaurant-detail',
  standalone: true,
  imports: [
    NgIf,
    RestaurantsFormComponent,
    RouterLink,
    NgForOf,
    EvaluationDetailComponent
  ],
  templateUrl: './restaurant-detail.component.html',
  styleUrl: './restaurant-detail.component.css'
})
export class RestaurantDetailComponent implements OnInit{
  private id: string = this.activatedRoute.snapshot.params["id"]

  restaurant?: RestaurantDTO;
  imageUrl?: string;
  file?: File;


  constructor(
    private readonly restaurantService: RestaurantService,
    private readonly activatedRoute: ActivatedRoute,
    private readonly router: Router
  ) {
  }

  ngOnInit(): void {
    this.getRestaurant(this.id);
  }

  private getRestaurant(id: string): void {
    this.restaurantService.getRestaurant(id).subscribe((restaurant: RestaurantDTO) => {
      this.restaurant = restaurant;
      this.getImage()
    }, () => this.router.navigate([`404`]))
  }

  private getImage(): void {
    this.restaurantService.getImageUrl(Number(this.id)).subscribe((imageDTO: ImageDTO) => {
      this.imageUrl = imageDTO.url;
    })
  }

  public uploadImage(file: File): void {
    this.restaurantService.uploadImage(this.id, file).subscribe((response: string) => {
      this.getImage()
    })
  }

  onChange(event: Event) {
    const element = event.target as HTMLInputElement;
    if(element.files) {
      this.file = element.files[0]
    }
  }

  onUpload(input: HTMLInputElement) {
    if(this.file) {
      console.log("uploading")
      this.uploadImage(this.file)
      this.file = undefined;
      input.value = '';
    }
  }

  updateRestaurant(event: RestaurantUpdateDTO) {

  }
}
