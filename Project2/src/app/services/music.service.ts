import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MouritsResult } from '../models/MouritsResult';
import { Song } from '../models/Song';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  constructor(private httpClient: HttpClient) { }

  getSomething(): Observable<any> {
    return this.httpClient.get("http://localhost:3031/nam/home", { responseType: "text" }) as Observable<any>;
  }

  getByLyrics(): Observable<Song>{
    return this.httpClient.get<Song>("http://localhost:3031/nam/lyrics/q/down with the sickness") as Observable<Song>;
  }
}
