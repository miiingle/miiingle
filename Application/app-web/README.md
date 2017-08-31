# Miiingle: Web Application

## Development server
```
npm start
```

## Deploying the App
```
npm run deploy
```

## Initial Setup
- Configure Firebase
```
sudo npm install -g firebase-tools
firebase login
touch .firebaserc
```
- paste the following to .firebaserc
```
{
  "projects": {
    "default": "<my-firebase-project-name>"
  }
}
```
- configure environment variables
```
cp src/environments/environment.prod.ts src/environments/environment.custom.ts
```

###### Resources:
- [RxJS](http://reactivex.io/rxjs/)
- [Angular Environment Variables](http://tattoocoder.com/angular-cli-using-the-environment-option/)
- [Angular Fire](https://github.com/angular/angularfire2)
- [Firebase Authentication: Facebook](https://firebase.google.com/docs/auth/web/facebook-login)
