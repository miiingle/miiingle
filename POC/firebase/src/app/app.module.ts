import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgModule } from '@angular/core';
import { RouterModule } from "@angular/router";

import { AgmCoreModule } from '@agm/core';

import { AngularFireModule } from "angularfire2";
import { AngularFireAuthModule } from "angularfire2/auth";

import { environment } from '../environments/environment';
import { appRoutes } from "./routes";

import { AppComponent } from './app.component';
import { MaterialModule } from "./material.module";
import { NavComponent } from "./nav/nav.component";
import { MapComponent } from './map/map.component';
import { FriendsComponent } from './friends/friends.component';
import { SettingsComponent } from './settings/settings.component';
import { AuthComponent } from './auth/auth.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MapComponent,
    FriendsComponent,
    SettingsComponent,
    AuthComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    BrowserAnimationsModule,
    AgmCoreModule.forRoot({
      apiKey: environment.gMapsApiKey
    }),
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireAuthModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
