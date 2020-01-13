import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-my-playlists',
  templateUrl: './my-playlists.component.html',
  styleUrls: ['./my-playlists.component.css']
})
export class MyPlaylistsComponent implements OnInit {

  public currentUser;
  public list;
  acc:Account;
  constructor(
    private accountService:AccountService,
    private toastr:ToastrService
  ) {
    this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
    this.list = this.printPlaylist(this.currentUser.id);
    this.accountService.getAccount(this.currentUser.id).subscribe(acc=>this.acc=acc);
   }

  ngOnInit() {
    // this.get();
  }

  get():void{
    this.accountService.getAccount(this.currentUser.id).subscribe(acc=>this.acc=acc);
  }

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
}
