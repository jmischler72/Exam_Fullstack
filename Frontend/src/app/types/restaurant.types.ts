import {EvaluationDTO} from "./evaluation.types";

export interface RestaurantCreateDTO {
  nom: string,
  adresse: string,
  tags: string[],
}

export interface RestaurantUpdateDTO {
  nom?: string,
  adresse?: string,
  tags?: string[],
}

export interface RestaurantDTO {
  id: number
  nom: string,
  adresse: string,
  moyenne_evaluation: number,
  evaluations: EvaluationDTO[],
  tags: string[],
  imageUrl?: string,
}
