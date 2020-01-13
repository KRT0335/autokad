import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http:HttpClient) { }

  register(name:string, username:string, password:string){
    return this.http.get(`http://localhost:3031/nam/register/`+name+`/`+username+`/`+password);
  }
}
