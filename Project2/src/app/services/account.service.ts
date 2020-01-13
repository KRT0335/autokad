import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http:HttpClient) { }

  register(name:string, username:string, password:string){
    return this.http.get<any>(`http://3.19.223.241:8089/nam/register/`+name+`/`+username+`/`+password);
    // return this.http.get(`http://localhost:3031/nam/register/`+name+`/`+username+`/`+password);
  }

  getAccount(id:number){
    return this.http.get<any>('http://3.19.223.241:8089/nam/'+id);
    // return this.http.get<any>('http://localhost:3031/nam/'+id);
  }

  addPlaylist(playlistName:string, id:number){
    return this.http.get<Account>('http://3.19.223.241:8089/nam/playlist/new/'+playlistName+'/'+id);
    // return this.http.get<Account>('http://localhost:3031/nam/playlist/new/'+playlistName+'/'+id);
  }
  
  getAllAccount(){
    return this.http.get<Account[]>('http://3.19.223.241:8089/nam/all');
    // return this.http.get<Account[]>('http://localhost:3031/nam/all');
  }
}
