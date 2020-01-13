import { Component, OnInit } from '@angular/core';
import { MusicService } from 'src/app/services/music.service';
import { Song } from 'src/app/models/Song';

@Component({
  selector: 'app-bylyrics',
  templateUrl: './bylyrics.component.html',
  styleUrls: ['./bylyrics.component.css']
})
export class BylyricsComponent implements OnInit {

  song:Song;

  constructor(
    private musicService:MusicService
  ) { }

  ngOnInit() {
  }

  byTheLyrics(q:string){
    this.musicService.getByLyrics(q).subscribe(song => this.song = song);
    console.log(this.song);
    console.log(this.musicService.getByLyrics(q));
  }

}
