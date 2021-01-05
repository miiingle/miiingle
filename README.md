# Miiingle.NET
Your local professional network!

# Dev Stack
- Postman (API Demo, Design, Tests, Documentation)
- Figma (UI Demo)
- Micronaut (Backend)
- iOS/Swift (Frontend)

## Runtime and Deployment
- AWS EKS and Spot Instances (Backend Runtime)
- AWS Cognito (Auth Server)
- AWS RDS/Postgres (Database)

## Build + Automation
- Terraform
- Travis

# Feature Roadmap
- Seed Infra
```
create a dummy micronaut app and push it to dockerhub (nothing fancy just a "ping")
we already have a TF template for EKS + api gateway, so lets do that first (using spot instances)
create a simple mobile app with nothing but a simple ping on it
once we have an api in dev, we can begin integrating it with FE

use fake db at this point first
```
- Basic Social Profile
```
basic stuff, no networking feature yet, anyone can join, 
lets focus on the single user first

login: hardcoded user
- basic auth on server

user info crud:
- name
- birthdate
- contact information (mobile number or email is required)
- jobs
- skills

use a real database
```
- Mobile Information Extraction
```
run a web browser and let the mobile app extract the entire page
```
- Desktop Information Extraction
```
create a mac app
by installing a chrome/safari extension, users can magically scan and extract skills, info from their linked-in or fb profile and integrate that information
```
- Advanced Networking
```
only people with actual connections can proceed - the mechanism TBD
tiers (close friends, acquaintance, worked at the same company)
```
- Photo Vault
```
a photo storage service, data is secured/locked by default
a good exercise for permissions / micronaut security
```
```
- Meetups
```
users think of something they want to do at the moment (time + location data), and suggest "miiingling activities"
```

