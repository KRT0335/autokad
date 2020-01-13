import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MouritsResult } from '../models/MouritsResult';
import { Song } from '../models/Song';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  constructor(private httpClient: HttpClient) { }

  getSomething(): Observable<any> {
    return this.httpClient.get("http://3.19.223.241:8089/nam/home", { responseType: "text" }) as Observable<any>;
    // return this.httpClient.get("http://localhost:3031/nam/home", { responseType: "text" }) as Observable<any>;
  }

  getByLyrics(lyrics:string): Observable<Song>{
    return this.httpClient.get<Song>("http://3.19.223.241:8089/nam/lyrics/q/"+lyrics) as Observable<Song>;
    // return this.httpClient.get<Song>("http://localhost:3031/nam/lyrics/q/"+lyrics) as Observable<Song>;
  }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  
  addSong(playlistid:number, songid:number):Observable<any>{
    return this.httpClient.get("http://3.19.223.241:8089/nam/song/add/"+playlistid+"/"+songid);
    // return this.httpClient.get("http://localhost:3031/nam/song/add/"+playlistid+"/"+songid);
  }

  getSong(song:Song){
    return this.httpClient.get<Song>("http://3.19.223.241:8089/nam/song/new/"+song.songname+"/"+song.artist+"/"+song.lyrics);
    // return this.httpClient.get<Song>("http://localhost:3031/nam/song/new/"+song.songname+"/"+song.artist+"/"+song.lyrics);
  }
}
