# music-service

Project to read music data from a file and return id's corresponding to the query(album name passed).
Music data file is read from musical_group.tsv in to a list. This list is then parsed and a trie is generated.
This trie is then used to search for any query (album name) and its matching id's are returned.
**Implemented multithreading for efficient searching, thread count can be considered via property file.**

For searching of album a REST endpoint is provided, to search for album having Indigo in its name, rest call will be
```sh
localhost:8080/music/search?query=Indigo
```
This project has gradlew.bat file which helps in building project and running application.
For building application first time
```sh
path\music-service> gradlew build
```
Running application
```sh
path\music-service> gradlew bootrun
```
