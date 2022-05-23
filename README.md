# Movie App

A simple movie list app


![app_screenshots](images/movieapp2.png)

## Built With 


- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [DataBinding](https://developer.android.com/topic/libraries/view-binding)
- [Dagger Hilt](https://dagger.dev/) 
- [Retrofit](https://square.github.io/retrofit/) 
- [Glide](https://bumptech.github.io/glide/) 
- [Navigation Components](https://developer.android.com/guide/navigation)
- [Material Components for Android](https://github.com/material-components/material-components-android)

## Architecture

* Pattern [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)
* [Android architecture components](https://developer.android.com/topic/libraries/architecture/)

<p align="center"><a><img src="https://raw.githubusercontent.com/fortysevennn/MovieApp/master/architecture.png" width="700"></a></p>

## Project Structure 

```
Movie App
├── common
│   ├── BindingAdapters.kt
│   ├── Constants
│   └── Resource
├── data
│   ├── remote
│   │   └── retrofit
│   │       └── MovieApi
│   └── repository
│       └── MovieRepositoryImpl
├── di
│   ├── AppModule
│   └── MovieApp
├── domain
│   ├── model
│   │   └── Movie
│   │   └── MovieSearch
│   │   └── MovieDetail
│   ├── repository
│   │   └── MovieRepository
└── peresention
    └── ui
        ├── detail
        │   └── DetailFragment
        │   └── DetailViewModel
        ├── home
        │   ├── HomeAdapter
        │   ├── HomeFragment
        │   └── HomeViewModel
        └── MainActivity
        └── MainActivityViewModel
        
```

## LICENSE
```
MIT License
Copyright (c) 2022 Tugay Pamuk
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
