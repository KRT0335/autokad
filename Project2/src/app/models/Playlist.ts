import {Account} from './Account';
import {Song} from './Song';

export class Playlist {
   id: number;
   account: Account;
   songs:Song[];
   playlistName: string;
}