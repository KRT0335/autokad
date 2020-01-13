import { Component, OnInit } from '@angular/core';
import { MusicService } from '../../services/music.service';
import {Account} from '../../models/Account';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router, ActivatedRoute } from '@angular/router';
// import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private account:Account;
  public currentUser;
  constructor(
    private musicService: MusicService,
    private authenticationService:AuthenticationService,
    private router:Router,
    private route:ActivatedRoute,
    private toastr:ToastrService
    ) {
      this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
     }

  any: string;
  ngOnInit() {
    // this.get();
  }

  get(username:string, password:string) {
    this.musicService.getSomething().subscribe(any => this.any = any);
    console.log(this.any);
  }

  loginCalled(username:string, password:string){
    this.authenticationService.login(username, password)
      .subscribe(
        data => {
          this.router.navigate(['/']);
        },
        error => {
          this.toastr.error(error.error.message, "Error");
        }
      );
  }
}
