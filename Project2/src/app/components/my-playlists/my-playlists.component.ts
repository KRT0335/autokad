import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { ToastrService } from 'ngx-toastr';
import { Playlist } from 'src/app/models/Playlist';

@Component({
  selector: 'app-my-playlists',
  templateUrl: './my-playlists.component.html',
  styleUrls: ['./my-playlists.component.css']
})
export class MyPlaylistsComponent implements OnInit {

  public currentUser;
  acc:any;
  play:Playlist;
  constructor(
    private accountService:AccountService,
    private toastr:ToastrService
  ) {
    this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
    this.accountService.getAccount(this.currentUser.id).subscribe(acc=>this.play=acc.playlist);
   }

  ngOnInit() {
  
  }

  get():void{
    this.accountService.getAccount(this.currentUser.id).subscribe(acc=>this.acc=acc);
  }

  printPlaylist(id:number){
    return this.accountService.getAccount(id).subscribe(
      data => {
        // console.log(data);
      },
      error => {
        this.toastr.error(error.error.message, "Error");
      }
    );
  }

  createPlaylist(playlistName:string) {
    this.accountService.addPlaylist(playlistName, this.currentUser.id).subscribe(
      data => {
        
      },
      error => {
        
      }
    )
  };
}
