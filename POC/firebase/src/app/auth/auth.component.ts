import { Component, OnInit } from '@angular/core';
import {AngularFireAuth} from "angularfire2/auth";
import {auth} from "firebase";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  constructor(public afAuth: AngularFireAuth) { }

  ngOnInit() { }

  login() {
    this.afAuth.auth.signInWithPopup(new auth.GoogleAuthProvider());
  }

  loginWithFb() {
    this.afAuth.auth.signInWithPopup(new auth.FacebookAuthProvider());
  }

}
