
export interface EvaluationCreateDTO {
  evaluateur: string,
  note: number,
  commentaire: string,
  restaurantId: number,
}

export interface EvaluationUpdateDTO {
  evaluateur?: string,
  note?: number,
  commentaire?: string,
}

export interface EvaluationDTO {
  id: number
  evaluateur: string,
  note: number,
  commentaire: string,
  dateCreation: Date,
  dateUpdate: Date,
  images: String[],
}
