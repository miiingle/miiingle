import { Component, OnInit } from '@angular/core';
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

  constructor(db: AngularFireDatabase, public afAuth: AngularFireAuth) {
  	this.items = db.list('/items');
  	this.user = afAuth.authState;
  }

  ngOnInit() {
  }

}
