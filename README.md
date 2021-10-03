# JPM-Album
Android Assignment
## Prerequisites
The following components must be installed in order to go through the Usage Instructions.

* [Gradle Build Tool](https://gradle.org/).
* Latest release of the [Java JDK version 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
* [Git client](https://git-scm.com/downloads).
* [Android Studio](https://developer.android.com/studio/) version 3.1 or later.
* [Android SDK](https://developer.android.com/studio/index.html#downloads) with the API level 26 or later.
* [Processing 3.1](http://processing.org/download/) or later.
* Android mode for Processing, installed into the PDE using the [Contributions Manager](https://android.processing.org/tutorials/getting_started/index.html).

## Set Up and Compile
 Clone this repository and import into **Android Studio**

## Import to Android Studio

1. Open Android Studio and select the "Import project" menu item in the welcome screen.
2. Navigate to the location where you checked out the repository in your computer, and select the debug folder.
3. Android Studio should be able to import the debug project automatically, which includes the library itself and a minimal test app.

## Structure

- build.gradle - root gradle config file
- settings.gradle - root gradle settings file
- app - our only project in this repo
- app/build.gradle - project gradle config file
- app/src - main project source directory
- app/src/main - main project flavour
- app/src/main/AndroidManifest.xml - manifest file
- app/src/main/java - java source directory
- app/src/main/res - resources directory

## Generating signed APK

The Android system requires that all installed applications be digitally signed with a certificate whose private key is held by the application's developer. The Android system uses the certificate as a means of identifying the author of an application and establishing trust relationships between applications. The certificate is not used to control which applications the user can install. The certificate does not need to be signed by a certificate authority: it is perfectly allowable, and typical, for Android applications to use self-signed certificates.

## Signing process
The Android build process signs your application differently depending on which build mode you use to build your application. There are two build modes: debug mode and release mode. You use debug mode when you are developing and testing your application. You use release mode when you want to build a release version of your application that you can distribute directly to users or publish on an application marketplace such as Google Play.

## From Android Studio:
1. Build menu
2. Generate Signed APK...
3. Fill in the keystore information (you only need to do this once manually and then let Android Studio remember it)
