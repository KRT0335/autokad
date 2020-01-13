import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentUser;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    // this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
    this.authenticationService.currentUser.subscribe(x => this.currentUser=x);
   }

  ngOnInit() {
  }

  logout(){
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }
}