import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-all-playlists',
  templateUrl: './all-playlists.component.html',
  styleUrls: ['./all-playlists.component.css']
})
export class AllPlaylistsComponent implements OnInit {

  public currentUser;
  accs:Account[];
  constructor(
    private accountService:AccountService,
    private toastr:ToastrService
  ) {
    this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
    this.accountService.getAllAccount().subscribe(accs=>this.accs=accs);
   }

  ngOnInit() {
    // this.get();
  }

  printAllPlaylist(id:number){
    return this.accountService.getAllAccount().subscribe(
      data => {
        // console.log(data);
      },
      error => {
        this.toastr.error(error.error.message, "Error");
      }
    );
  }
}
