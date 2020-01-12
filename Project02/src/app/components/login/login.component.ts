import { Component, OnInit } from '@angular/core';
import { MusicService } from '../../services/music.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private musicService: MusicService) { }

  any: string;
  ngOnInit() {
    this.get();
  }

  get() {
    this.musicService.getSomething().subscribe(any => this.any = any);
  }
}
