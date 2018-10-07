# SmartToast

[![](https://jitpack.io/v/dwieners/SmartToast.svg)](https://jitpack.io/#dwieners/SmartToast)

SmartToast is an Android library for a beautiful and customizable Toast

## Usage

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add the dependencies

```gradle
dependencies {
	implementation 'com.github.dwieners:SmartToast:0.1.2'
}
```

### Snackbars
Default Snackbars:
```kotlin
SmartToast.successSnack(this, "YOUR TEXT", Snackbar.LENGTH_SHORT).show()
SmartToast.successSnack(this, "YOUR TEXT").show()

SmartToast.infoSnack(this, "YOUR TEXT", Snackbar.LENGTH_LONG).show()
SmartToast.infoSnack(this, "YOUR TEXT").show()

SmartToast.errorSnack(this, "YOUR TEXT", Snackbar.LENGTH_LONG).show()
SmartToast.errorSnack(this, "YOUR TEXT").show()
 ```
 
 
 Custom Snackbars:
 ```kotlin
 SmartToast.customSnack(this, "YOUR TEXT", SmartToast.DEFAULT_TEXT_COLOR,
                    resources.getColor(android.R.color.holo_purple, theme),
                    Snackbar.LENGTH_LONG).show()
 ```
### Toasts 
Default Toasts: 
```kotlin
SmartToast.normalToast(this,"YOUR TEXT", Toast.LENGTH_LONG).show()
SmartToast.normalToast(this,"YOUR TEXT").show()

SmartToast.successToast(this, "YOUR TEXT", Toast.LENGTH_LONG).show()
SmartToast.successToast(this, "YOUR TEXT").show()

SmartToast.infoToast(this, "YOUR TEXT", Toast.LENGTH_LONG).show()
SmartToast.infoToast(this, "YOUR TEXT").show()

SmartToast.errorToast(this, "YOUR TEXT", Toast.LENGTH_LONG).show()
SmartToast.errorToast(this, "YOUR TEXT").show()
```

Custom Toasts:
```kotlin
SmartToast.customToast(this, "YOUR TEXT", SmartToast.DEFAULT_TEXT_COLOR,
                    resources.getColor(android.R.color.holo_purple, theme),
                    Toast.LENGTH_LONG).show()
```

	
