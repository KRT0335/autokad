import { SongResult } from './SongResult';

export class MouritsResult {
  private success: boolean;
  private result: SongResult;
  private artist: string;
  private songname: string;

  constructor(success: boolean, result: SongResult, artist: string, songname: string) {
    this.success = success;
    this.result = result;
    this.artist = artist;
    this.songname = songname;
  }

  getSuccess(): boolean {
    return this.success;
  }
  setSuccess(success: boolean) {
    this.success = success;
  }
  getResult(): SongResult {
    return this.result;
  }
  setResult(result: SongResult) {
    this.result = result;
  }
  getArtist(): string {
    return this.artist;
  }
  setArtist(artist: string) {
    this.artist = artist;
  }
  getSongname(): string {
    return this.songname;
  }
  setSongname(songname: string) {
    this.songname = songname;
  }
}