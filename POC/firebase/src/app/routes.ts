import {Routes} from "@angular/router";
import { MapComponent } from "./map/map.component";
import {FriendsComponent} from "./friends/friends.component";
import {SettingsComponent} from "./settings/settings.component";

export const appRoutes: Routes = [
  {
    path: '',
    component: MapComponent
  }, {
    path: 'friends',
    component: FriendsComponent
  }, {
    path: "settings",
    component: SettingsComponent
  }
];
