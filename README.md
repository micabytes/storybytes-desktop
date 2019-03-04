# storybytes-desktop

StoryBytes is a simple viewer for [Ink]() scripts; [storybytes-desktop](https://github.com/micabytes/storybytes-desktop) is a simple desktop application built using Kotlin and [TornadoFX](https://github.com/edvin/tornadofx).

StoryBytes was originally developed as a very simple demo for [mica-ink](https://github.com/micabytes/mica-ink); the current version is built to use [blade-ink](https://github.com/bladecoder/blade-ink) which I recommend for Java development with Ink.

## Roadmap

I basically built this just to play around a bit with TornadoFX, so at present there are no specific plans. I might try to make it a desktop version of the StoryBytes android app at some point (i.e., a generic Ink player with file loading, etc) but there is no ETA on that.

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

To run this with your own Ink files, place your ink file in the "resource/ink" directory, and change the constant FILENAME in the BladeViewer.kt file to reference your file. The app will then start up with your Ink story.

## License

Currently set to the MIT license, but I'll have to take a look at it at some point (it may be a bit restrictive). Ping me if you want to use the code for something.