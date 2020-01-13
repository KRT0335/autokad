import { Component, OnInit } from '@angular/core';
import { MusicService } from 'src/app/services/music.service';
import { Song } from 'src/app/models/Song';
import { AccountService } from 'src/app/services/account.service';
import { ToastrService } from 'ngx-toastr';
// import { Account } from '../../models/Account';
import { Playlist } from 'src/app/models/Playlist';

@Component({
  selector: 'app-bylyrics',
  templateUrl: './bylyrics.component.html',
  styleUrls: ['./bylyrics.component.css']
})
export class BylyricsComponent implements OnInit {

  public song:Song;
  public currentUser;
  acc:any;
  play:Playlist;
  // Account = {id:number, name:string, username:string, password:string, playlist:Playlist[]};
  // public acc: {id:number, name:string, username:string, password:string, playlist:Playlist[]} = {} as {id:number, name:string, username:string, password:string, playlist:Playlist[]};
  // private oneExists: boolean = false;

  constructor(
    private musicService:MusicService,
    private accountService:AccountService,
    private toastr:ToastrService
  ) {
    // type Account = {id:number, name:string, username:string, password:string, playlist:Playlist[]}
    // let acc:Account = {} as Account;
    // let acc: {id:number, name:string, username:string, password:string, playlist:Playlist[]} = {} as {id:number, name:string, username:string, password:string, playlist:Playlist[]};
    this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
    this.accountService.getAccount(this.currentUser.id).subscribe(acc => this.play = acc.playlist);
   }

  ngOnInit() {
  }

  exist(pla:number){
    return pla > 0;
  }
  
  byTheLyrics(lyrics:string){
    this.musicService.getByLyrics(lyrics).subscribe(song => this.song = song);
    // console.log(this.song);
    // console.log(this.musicService.getByLyrics());
  }

  addSong(playlistid:number){
    if(playlistid == 0){

    }else{
      // console.log(playlistid);
      this.musicService.getSong(this.song).subscribe(song => {
        this.musicService.addSong(playlistid, song.songid).subscribe(
          data => {

          },
          error => {

          }
        ); 
        // console.log(song.songid); 
        this.song = song;
      });
      // this.musicService.addSong(playlistid, this.song.songid);
      // console.log(this.song.songid);
      // console.log(this.song);
    }
    
  }

}
