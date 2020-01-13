import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Account} from '../models/Account';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private currentUserSubject:BehaviorSubject<Account>;
  public currentUser: Observable<Account>;
 
constructor(private http: HttpClient) {
this.currentUserSubject = new BehaviorSubject<Account>(JSON.parse(localStorage.getItem('currentUser')));
this.currentUser = this.currentUserSubject.asObservable();
}
 
public get currentUserValue(): Account {
return this.currentUserSubject.value;
}
 
login(username: string, password: string) {
return this.http.get<any>(`http://localhost:3031/nam/login/`+username+'/'+password)
.pipe(map(user => {
if (user) {
// store user details in local storage to keep user logged in
localStorage.setItem('currentUser', JSON.stringify(user));
this.currentUserSubject.next(user);
}
 

return user;
}));
}
 
logout() {
// remove user data from local storage for log out
localStorage.removeItem('currentUser');
this.currentUserSubject.next(null);
}
}
