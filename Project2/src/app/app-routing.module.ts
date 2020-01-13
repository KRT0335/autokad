import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { BysongComponent } from './components/bysong/bysong.component';
import { BylyricsComponent } from './components/bylyrics/bylyrics.component';
import { HomeComponent } from './components/home/home.component';
import { AuthGuard } from './helpers/auth.guard';



const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  // { component: HomeComponent, path: "home" },
  { component: HomeComponent, canActivate: [AuthGuard], path: ''},
  { component: SignupComponent, path: "signup" },
  { component: LoginComponent, path: "login" },
  { component: BylyricsComponent, path: "bylyrics" },
  { component: BysongComponent, path: "bysong" },
  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }