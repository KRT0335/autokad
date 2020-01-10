export class SongResult {
  private lyrics: string;

  constructor(lyrics: string) {
    this.lyrics = lyrics;
  }
  getLyrics(): string {
    return this.lyrics;
  }
  setLyrics(lyrics: string) {
    this.lyrics = lyrics;
  }
}