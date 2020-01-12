import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  constructor(private httpClient: HttpClient) { }

  getSomething(): Observable<any> {
    return this.httpClient.get("http://localhost:3031/nam/home", { responseType: "text" }) as Observable<any>;
  }
}
