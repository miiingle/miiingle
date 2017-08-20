import {Component, OnInit} from '@angular/core';

import {Observable} from 'rxjs/Observable';
import {AngularFireAuth} from 'angularfire2/auth';
import * as firebase from 'firebase';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: Observable<firebase.User>;

  constructor(public afAuth: AngularFireAuth) {
    this.user = afAuth.authState;
  }

  ngOnInit() {
  }

  login() {
    let provider = new firebase.auth.FacebookAuthProvider();
    provider.addScope('user_birthday');
    provider.setCustomParameters({
      'display': 'popup'
    });
    firebase.auth().signInWithPopup(provider).then(function (/*result*/) {
      // This gives you a Facebook Access Token. You can use it to access the Facebook API.
      //let token = result.credential.accessToken;
      // The signed-in user info.
      //let user = result.user;
      // ...
    }).catch(function (error: Error) {
      // Handle Errors here.
      //var errorCode = error.code;
      let errorMessage = error.message;
      // The email of the user's account used.
      //var email = error.email;
      // The firebase.auth.AuthCredential type that was used.
      //var credential = error.credential;
      // ...
      console.log("Error: " + errorMessage)
    });
  }

  logout() {
    this.afAuth.auth.signOut();
  }

}
