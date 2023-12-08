import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, mergeMap, Observable, of} from "rxjs";
import {RestaurantCreateDTO, RestaurantDTO, RestaurantUpdateDTO} from "../types/restaurant.types";

@Injectable({
  providedIn: 'root'
})
export class EvaluationService{
  constructor(private httpClient: HttpClient) {
  }

  private baseURL: string = "http://localhost:8080/evaluations"

  public deleteEvaluation(id: number): Observable<string> {
    return this.httpClient.delete<string>(`${this.baseURL}/${id}`);
  }

  public getRestaurant(id: string): Observable<RestaurantDTO> {
    return this.httpClient.get<RestaurantDTO>(`${this.baseURL}/${id}`);
  }

  public createRestaurant(restaurant: RestaurantCreateDTO): Observable<RestaurantDTO> {
    return this.httpClient.post<RestaurantDTO>(this.baseURL, restaurant);
  }

  public updateRestaurant(id: string, restaurant: RestaurantUpdateDTO): Observable<RestaurantDTO> {
    return this.httpClient.put<RestaurantDTO>(`${this.baseURL}/${id}`, restaurant);
  }

  public uploadImage(id: string, file: File): Observable<string> {
    return this.httpClient.get<string>(`${this.baseURL}/${id}/put_image_url`, {}).pipe(
      mergeMap((response: string) => {
        return this.httpClient.put<string>(response, file)
      }), catchError(error => of(error.error))
    );
  }

  public getImageUrl(id: number): Observable<string> {
    return this.httpClient.get<string>(`${this.baseURL}/${id}/get_image_url`).pipe(
      catchError(error => of(error.error))
    );
  }

}
