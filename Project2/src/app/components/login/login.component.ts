import { Component, OnInit } from '@angular/core';
import { MusicService } from '../../services/music.service';
import {Account} from '../../models/Account';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private account:Account;
  constructor(private musicService: MusicService) { }

  any: string;
  ngOnInit() {
    // this.get();
  }

  get(username:string, password:string) {
    this.musicService.getSomething().subscribe(any => this.any = any);
    console.log(this.any);
  }
}