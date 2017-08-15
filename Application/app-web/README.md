# Miiingle: Web Application

## Development server
```
npm start
ng serve --env=custom
```

## Deploying the App
```
npm build
firebase deploy
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
- [Angular Environment Variables](http://tattoocoder.com/angular-cli-using-the-environment-option/)
- [Angular Fire](https://github.com/angular/angularfire2)