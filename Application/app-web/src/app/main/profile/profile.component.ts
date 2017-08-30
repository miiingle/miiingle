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
    this.profileChanges = db.list("/items/abs");
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log("submitted" + this.form);

    this.db.list("/items/abc").push({"profile": this.userProfile});

    this.user.merge(this.profileChanges).subscribe(res => {
      console.log()
    })
  }

  onReset() {
    this.userProfile = new UserProfile("ref","changed");
  }

}
