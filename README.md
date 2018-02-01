# My-First-Android-App
Introductory mobile application that was used for instructional purposes during HackUCI 2018. This tutorial is split up into 4 parts:
1) Introductory information about Android
2) Introducing the code and basics of Java
3) Developing your first app
4) Deploying to your mobile device or an emulator

# Introduction to Android Vocabulary
- Android Activity: The activity initiates an Android program and is typically characterized by the onCreate() method, which should be nested in the Activity object

- Other Important Activity Methods:
onStart(): Called whenever the activity becomes visible for the user
onResume(): Called whenever the user interacts with the application
onStop(): Called when the activity is no longer visible
For further reading: https://www.tutorialspoint.com/android/android_acitivities.htm

- AppCompatActivity: A base class that provides newer features on older versions of Android. Also defaults to older features if the newer features are not available on older versions. Essentially allows for backward compatibility. Important since it allows for simpler development and wider support

- setContentView(): A method that sets the layout of the page to the XML page specified

- Bundle: Used to pass data between activities. Also used to retain data about a page when the state changes (i.e. orientation of the device, browser changes, etc.)

- Android Layouts: Layouts are defined in XML files. They are a bit cumbersome at first but you will see the usefulness of the clear organization when you undertake larger projects. Works similarly to HTML/CSS

- Types of Layouts:
Constraint Layout: Allows for flexible layouts that are defined by constraints between elements in a layout. Constraints are the criteria for determining the position of UI elements. Tutorial link: https://codelabs.developers.google.com/codelabs/constraint-layout/#0

Linear Layout: View group that aligns all children elements in a single direction, either vertically or horizontally

Relative Layout: View gorup that aligns children in relative positions

Table Layout: 
