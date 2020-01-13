import { Playlist } from './Playlist';

export class Account {
   id: number;
   name: string;
   username: string;
   password: string;
   playlists: Playlist[];
}