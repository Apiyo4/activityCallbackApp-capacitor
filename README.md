# Testing App
## Getting Started

These instructions will get you a copy of the project up and running on your
local machine for development and testing purposes.

### Prerequisites

For development, you will need to have installed on your machine:

- [Node](https://nodejs.org)
- Android Studio

#### To start app

- Run `npm install`
-  npm run start

#### To start the app with mobile
- Run npm run build
- Run npx cap sync
- Run npx cap open android
- Run the app in android studio using run button on simulator or on mobile
 
### Known bugs

- StartActivityForResult doesn't work when service is passed in the intent, but starts when an activity is passed on intent
