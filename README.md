# storybytes-desktop

Desktop version of the StoryBytes story viewer for [mica-ink](https://github.com/micabytes/mica-ink).

This is an extremely simple application built using Kotlin and [TornadoFX](https://github.com/edvin/tornadofx).

## Roadmap

I basically built this just to play around a bit with TornadoFX, so at present there are no specific plans. I might try to make it
a desktop version of the StoryBytes android app at some point (i.e., a generic Ink player) but there is no ETA on that.

## Building

The application is built and run using gradle.

To build the application:
```
./gradlew build
```
The first time you do this, it will likely download a LOT of stuff. You will need a working development environment for Java.

To run the application (will build it, if not yet built)
```
./gradlew run
```
Use the `bat` file on windows.

To run this with your own Ink files, place your ink file in the "resource/ink" directory, and change the path in line 13 of
the StoryViewModel.kt file to reference your file. The story will then start up with your Ink story (within the limitations
of the [mica-ink](https://github.com/micabytes/mica-ink) engine).

## License

Currently set to the MIT license, but I'll have to take a look at it at some point (it may be a bit restrictive). Ping me if
you want to use the code for something.