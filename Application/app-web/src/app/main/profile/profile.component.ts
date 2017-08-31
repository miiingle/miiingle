import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {UserProfile} from "./user-profile";
import {AngularFireDatabase, FirebaseListObservable} from "angularfire2/database";
import {AngularFireAuth} from "angularfire2/auth";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/merge';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @ViewChild("f") form: NgForm;

  userProfile = new UserProfile("John","Doe");
  user: Observable<firebase.User>;
  profileChanges: FirebaseListObservable<any>;

  constructor(
    private db: AngularFireDatabase,
    private auth: AngularFireAuth) {

    this.user = auth.authState;
    this.profileChanges = db.list("/profiles");
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log("submitted" + this.form);
    this.user.subscribe((u: firebase.User) => {
      let userDB = this.profileChanges.set( u.uid, this.userProfile);
    });
  }

  onReset() {
    this.userProfile = new UserProfile("ref","changed");
  }

}
