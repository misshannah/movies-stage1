# movies-stage1
An app to allow users to discover the most popular movies playing.

# Required Tasks

* Build a UI layout for multiple Activities.
* Launch Activities via Intent.
* Fetch data from themovieDB API.

# Features

* Present the user with a grid arrangement of movie posters upon launch.
* Allow your user to change sort order via a setting. i.e. The sort order can be by most popular or by highest-rated
* Allow the user to tap on a movie poster and transition to a details screen with additional information such as,
 original title or movie poster image thumbnail, a plot synopsis (called overview in the api) and user rating (called vote_average in the api)

# API Key Used
* Create an API Key here: https://www.themoviedb.org/settings/api/request
Once you obtain your key, you append it to the HTTP request as a URL parameter e.g
http://api.themoviedb.org/3/movie/popular?api_key=[YOUR_API_KEY]
For this project, you will insert it on the strings.xml file i.e
<string name="movie_api_key">[YOUR_API_KEY]</string>


# References
* http://mateoj.com/2015/10/06/creating-movies-app-retrofit-picasso-android/
* http://mateoj.com/2015/10/07/creating-movies-app-retrofit-picasso-android-part2/
