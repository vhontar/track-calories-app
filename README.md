## TrackCaloriesApp


### Tech stack

- **Clean architecture**
- **Multi module architecture** for faster builds and code separation
- **MVVM with Use Cases** for presentation layer
- **Kotlin** for all code
- **Coroutines** and **Kotlin Flow** for async work
- **Gradle Kotlin DSL** for build scripts configuration
- **Jetpack** (Compose, Navigation, ViewModel) for
  presentation layer
- **Material Components** for styling UI components and transitions
- **Room** for storing data
- **Hilt** for DI
- **Retrofit + OkHttp** for network requests
- **Moshi** for parsing JSONs
- **Coil** for images loading


### Modules

- [**core**](core) for core(shared) classes between all modules
- [**core-ui**](core-ui) for core(shared) UI-related classes between all modules
- [**tracker**](tracker) for tracker overview / searching foods
  - [**tracker-data**](tracker/tracker_data) data layer (local, remote)
  - [**tracker-domain**](tracker/tracker_domain) domain layer (use cases, repositories)
  - [**tracker-presentation**](tracker/tracker_presentation) presentation layer (Composables, Screens, ViewModels)
- [**onboarding**](onboarding) for onboarding steps to setup users data and goals
  - [**onboarding-domain**](onboarding/onboarding_domain) domain layer (use cases, repositories)
  - [**onboarding-presentation**](onboarding/onboarding_presentation) presentation layer (Composables, Screens, ViewModels)


### Features

- Setup your age/height/weight/activity level/your weight goals/your nutritional goals
- Overview your food tracking for total which consists of breakfast/lunch/dinner/snack
- Change date to see your tracking history
- Search for food
- Add a food to your breakfast/lunch/dinner/snack
- Remove a food from your breakfast/lunch/dinner/snack
- Measure your daily calories goal depends on inputted data

### Screenshots

![Tracker Overview](/screenshots/screen1.png "Tracker Overview") ![Search for foods](/screenshots/screen2.png "Search for foods") ![Track food](/screenshots/screen3.png "Track food")