# CameraX - Simple Image capturing Library for Android

This library aims to provide an Simple In App Image Capturing .

## Step - 1 - Add Dependency

We distribute our SDK from the Maven Central Repository. To begin with this SDK open your build.gradle file of Module:app add the following dependency.

```
implementation 'io.github.gokulakrishnan3099:camerax:0.1'
```
## Step - 2 - Implement Capture Listener
Set and Implement our capture listener to receive the capture result.
Use the below code to obtain the capture result.

```
class MainActivity : AppCompatActivity(), CaptureListener{
    override fun onCaptureFailed(message: String) {
         // Failure Callback
    }

    override fun onCaptureSuccess(uri: Uri) {
         // Success Callback
    }
}
```
## Step - 3 - Trigger Camera
The CameraX configuration is created using the builder pattern.
Make Sure to check wheather Camera permission is Granted

```
if (ActivityCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            CameraX.of(this@MainActivity)
                .attachListener(this@MainActivity)
                .setFacing(Facing.BOTH)
                .start()
        }
```

## Progurad Rules

If you are using Proguard for your builds, modify the Proguard rule file:
```
-dontwarn com.gokul.camerax**
-keep class com.gokul.camerax** { *; }
-keep interface com.gokul.camerax** { *; }
```

### Let us know!

We’d be really happy if you sent us links to your projects where you use our component. Just send an email to gokulakrishnan3099@gmail.com And do let us know if you have any questions or suggestion regarding the library.

## License

    Copyright 2017, 

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


