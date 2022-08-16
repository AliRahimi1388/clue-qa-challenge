# Test automation challenge

Welcome to the test automation challenge!


## Instructions


all testcase are in Espresso test framework form

* despite the fact that there was lots of problem with source code, i have design two test case so you can find them in activity under androidTest Folder:

'''
loginTest

signUpTest

'''
* the pattern are include activity which is for testcases and scenarios , base for AndroidTestBase which held base settings like after before rules and other thins as well, modules for connecting testSteps that i have defined in steps folder

* utils contains TestUtils object that have defined for one purpose to serve required test tools.

* gradle settings up for espresso usage

after all you can run testcase using Android Studio or below command as CI gradle command:

'''
./gradlew connectedAndroidTest
'''

* this command generate html report in HTML test result files: */build/reports/androidTests/connected/ directory.



## Instructions

* Download and inspect the open-sourced android application from the current repo
* Design a test suite for the sign-up and login functionality
* Build an infrastructure for test case implementation
* Implement your test cases


## Finally

Thank you Artem for support while completing this task!
Good luck!
