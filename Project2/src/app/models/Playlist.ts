import {Account} from './Account';
import {Song} from './Song';

export class Playlist {
   id: number;
   playlistName: string;
   account: Account;
   songs:Song[];
}