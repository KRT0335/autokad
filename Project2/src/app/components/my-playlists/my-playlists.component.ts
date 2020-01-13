import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-my-playlists',
  templateUrl: './my-playlists.component.html',
  styleUrls: ['./my-playlists.component.css']
})
export class MyPlaylistsComponent implements OnInit {

  public currentUser;
  playlistForm: FormGroup;
  // public list;
  acc:Account;
  constructor(
    private accountService:AccountService,
    private toastr:ToastrService,
    private formBuilder:FormBuilder
  ) {
    this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
    // this.list = this.printPlaylist(this.currentUser.id);
    this.accountService.getAccount(this.currentUser.id).subscribe(acc=>this.acc=acc);
   }

  ngOnInit() {
  
  }

  get():void{
    this.accountService.getAccount(this.currentUser.id).subscribe(acc=>this.acc=acc);
  }

  get f() { return this.playlistForm.controls; }

  printPlaylist(id:number){
    return this.accountService.getAccount(id).subscribe(
      data => {
        console.log(data);
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
