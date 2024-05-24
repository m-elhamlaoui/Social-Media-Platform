import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';
import { Observable } from 'rxjs';
import { Post } from '../../models/Post/post';
import { PaginationParams } from '../../models/PaginationParams/pagination-params';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private apiService: ApiService) {}

  // Getting posts from the API
  getPosts = (
    url: string,
    params: PaginationParams
  ): Observable<Post> => {

    return this.apiService.get(url, {
      params,
      responseType: 'json',
    });
  };
}
