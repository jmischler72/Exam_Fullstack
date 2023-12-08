import {TagsEnum} from "./tags.enum";
import {EvaluationDTO} from "./evaluation.types";

export interface RestaurantCreateDTO {
  nom: string,
  adresse: string,
  tags?: TagsEnum[],
}

export interface RestaurantUpdateDTO {
  nom?: string,
  adresse?: string,
  tags?: TagsEnum[],
}

export interface RestaurantDTO {
  id: number
  nom: string,
  adresse: string
  evaluation: EvaluationDTO[],
  tags: TagsEnum[],
  imageUrl?: string,
}
