# Keep ARCore related classes
-keep class com.google.ar.** { *; }
-dontwarn com.google.ar.**

# Keep Sceneform
-keep class com.google.ar.sceneform.** { *; }
-dontwarn com.google.ar.sceneform.**

# Kotlin (optional if you use reflection)
-keepclassmembers class kotlin.Metadata { *; }
-dontwarn kotlin.**

# Keep model rendering and transformation
-keep class com.google.ar.sceneform.rendering.** { *; }
-keep class com.google.ar.sceneform.ux.** { *; }

# Suppress warnings for reflection (optional)
-dontwarn javax.annotation.**
-dontwarn com.google.gson.**

# Keep app-specific classes
-keep class com.example.arfurniture.** { *; }

# Keep annotations
-keep @interface androidx.annotation.Keep
-keep @androidx.annotation.Keep class * { *; }

# Optional: Keep everything in assets
-keep class * {
    public private *;
}
