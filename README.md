# Nasa Pics

An android app created to explore a multi-module gradle setup. It uses the [nasa open apis](https://api.nasa.gov/)

The multi-module architecture is heavily inspired by this [Square's Talk](https://www.droidcon.com/media-detail?video=380843878)

## General setup

The app is composed of the following modules:

- **:app** - Contains the actual android app code. Hosts the application component and wires it up with the subcomponents of the different features.
- **:features** - Contains the code for each feature. The current app only has 2 - Astronomy picture of the day and the curiosity pictures
- **:foundation** - Contains code that is shared between all other modules, in other words, code that belongs to some foundation or common modules.

## Inside each feature

Each feature is composed of 4 modules:

- **:data** - Code that interacts with the data layer and its entities. Currently, it only hosts code that accesses the api.
- **:domain** - Hosts the use cases for each feature and the domain entities. Depends on the data module to be able to access the different data sources.
- **:public** - Contains the code that is accessible by other features and the app module. Depends on domain to be able to use its usecases.
- **:wiring** - Wires up the contracts and their implementation. This depends on all other feature submodules so it's capable of satisfying all dependencies.

## Caveats

In theory, a module should only need to depend on the `:feature:xyz:public` submodule to be able to use that feature. Unfortunately, with the current setup and libraries used this is simply not possible. The dagger modules in the `:app:` module require access to the implementation code inside the other feature submodules and therefore the gradle files expose transitive dependencies to these.


