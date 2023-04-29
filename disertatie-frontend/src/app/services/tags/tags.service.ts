import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Tag } from 'src/app/shared/models/Tag';

@Injectable({
  providedIn: 'root'
})
export class TagsService {

  readonly ROOT_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

    getTagCountedRequest(): Observable<Tag[]>{
    return this.http.get(this.ROOT_URL + "/api/tags/get-counted-tags")
    .pipe(
      map(response => {
        const responseArray = [];
        for(const key in response) {
          if(response.hasOwnProperty(key)) {
            responseArray.push({
              id: key,
              name: response[key].name,
              count: response[key].count
            })
          }
        }
        return responseArray;
      })
    )
  }
}
