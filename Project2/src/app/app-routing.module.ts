import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { BysongComponent } from './components/bysong/bysong.component';
import { BylyricsComponent } from './components/bylyrics/bylyrics.component';
import { HomeComponent } from './components/home/home.component';
import { AuthGuard } from './helpers/auth.guard';
import { MyPlaylistsComponent } from './components/my-playlists/my-playlists.component';
import { AllPlaylistsComponent } from './components/all-playlists/all-playlists.component';



const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  // { component: HomeComponent, path: "home" },
  { component: HomeComponent, canActivate: [AuthGuard], path: ''},
  { component: SignupComponent, path: "signup" },
  { component: LoginComponent, path: "login" },
  { component: BylyricsComponent, path: "bylyrics" },
  { component: BysongComponent, path: "bysong" },
  { component: MyPlaylistsComponent, canActivate: [AuthGuard], path: 'myplaylists'},
  { component: AllPlaylistsComponent, canActivate: [AuthGuard], path: 'allplaylists'},
  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }