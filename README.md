# Test automation challenge

Welcome to the test automation challenge!


## Instructions


all testcase are in Espresso test framework form

* despite the fact that there was lots of problem with source code, i have design two test case so you can find them in activity under androidTest Folder:

```
loginTest

signUpTest

signUpWithMisMatchConfirmPasswordToSeeErrorMessageTest

```
* the pattern are include activity which is for testcases and scenarios , base for AndroidTestBase which held base settings like after before rules and other thins as well, modules for connecting testSteps that i have defined in steps folder

* utils contains TestUtils object that have defined for one purpose to serve required test tools.

* gradle settings up for espresso usage

after all you can run testcase using Android Studio or below command as CI gradle command:

```
./gradlew connectedAndroidTest
```
* this command generate html report in HTML test result files: */build/reports/androidTests/connected/ directory.
* furthermore, you can use it this command to run testcase on all variants and all connected devices
* there are better solution than junit runner like spoon or marathon opensource tools

* this application test on Api 31 and version 1.0 of this android application

## Finally

Thank you Artem for support while completing this task!
Good luck!
