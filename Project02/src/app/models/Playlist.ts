export class Playlist {
  private id: number;
  private playlistName: string;
  private account: Account;

  constructor(id: number, playlistName: string, account: Account) {
    this.id = id;
    this.playlistName = playlistName;
    this.account = account;
  }
  getId(): number {
    return this.id;
  }
  setId(id: number) {
    this.id = id;
  }
  getPlaylistName(): string {
    return this.playlistName;
  }
  setPlaylistName(playlistName: string) {
    this.playlistName = playlistName;
  }
  getAccount(): Account {
    return this.account;
  }
  setAccount(account: Account) {
    this.account = account;
  }
}