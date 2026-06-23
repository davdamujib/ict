import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private api = 'http://localhost:8081/api/v1/user';

  constructor(private http: HttpClient) { }

  create(user: User) {
    return this.http.post(
      `${this.api}/create`,
      user
    );
  }

  getAll() {
    return this.http.get(
      `${this.api}/all`
    );
  }

  getById(id: number) {
    return this.http.get(
      `${this.api}/${id}`
    );
  }

  update(id:number, user: User){
    return this.http.put(
      `${this.api}/update/${id}`,
      user
    );
  }

  delete(id:number){
    return this.http.delete(
      `${this.api}/delete/${id}`
    );
  }
}
