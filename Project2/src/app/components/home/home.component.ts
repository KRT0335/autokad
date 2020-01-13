import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public currentUser;
  constructor( ) {
    this.currentUser = localStorage.getItem('currentUser')?JSON.parse(localStorage.getItem('currentUser')):'';
   }

  ngOnInit() {
  }

}
