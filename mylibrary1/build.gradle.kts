plugins {
    id("maven-publish")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
afterEvaluate {
    publishing {
        publications {
// Creates a Maven publication called "release".
            register<MavenPublication>("release") {
                groupId = "com.github.tjddn753"
                artifactId = "com.example.mylibrary1"
                version = "1.0.7"

            }
        }
    }
}
/*publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.tjddn753"
            artifactId = "mylibrary1"
            version = "1.0.5"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}*/
android {
    namespace = "com.example.mylibrary1"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}