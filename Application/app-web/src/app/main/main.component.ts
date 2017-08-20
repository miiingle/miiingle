import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

import { environment } from '../../environments/environment';

import { Observable } from 'rxjs/Observable';

import { AngularFireDatabase, FirebaseListObservable } from 'angularfire2/database';
import { AngularFireAuth } from 'angularfire2/auth';
import * as firebase from 'firebase/app';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  title = environment.title;

  items: FirebaseListObservable<any[]>;
  user: Observable<firebase.User>;

  constructor(public db: AngularFireDatabase, public afAuth: AngularFireAuth, private router: Router) {}

  ngOnInit() {
    this.items = this.db.list('/items');
    this.user = this.afAuth.authState;

    this.afAuth.authState.subscribe(auth => {
      if (!auth) {
        this.router.navigateByUrl("/login");
      }
    });
  }

  logout() {
    this.afAuth.auth.signOut();
  }

}
