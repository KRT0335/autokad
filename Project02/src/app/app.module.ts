import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ByartistComponent } from './components/byartist/byartist.component';
import { BysongComponent } from './components/bysong/bysong.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BylyricsComponent } from './components/bylyrics/bylyrics.component';

@NgModule({
  declarations: [
    AppComponent,
    ByartistComponent,
    BysongComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    BylyricsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
