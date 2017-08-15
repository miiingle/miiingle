# Miiingle: Web Application

## Development server
```
npm start
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
