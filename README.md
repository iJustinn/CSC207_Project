# CSC207 Project
2023 Fall CSC207 Group Project (Group #130)

# Media Manager using the Spotify API
[Link to Spotify API](https://developer.spotify.com/documentation/web-api/tutorials/getting-started)

# Overview
Our Media Manager system, designed for music enthusiasts, offers a unique way to interact with Spotify's extensive music library. By utilizing the Spotify API as a primary search engine, our system enables users to explore and find their desired albums and songs with ease. Moreover, it offers the capability to manage music collections locally. Users can create and access local playlists within our system, tailoring their music experience to their preferences. Each song in these playlists can be enriched with personal comments, allowing users to annotate tracks with special memories or notes. This makes our Media Manager not just a tool for music discovery and management, but also a personal music diary.

# Functionalities currently have
1. Metadata Insights:
	* Fetch and display detailed metadata for tracks, albums, and artists.
	* Including artist biographies, album release dates, track durations, etc.
	
2. Advanced Searching:
	* Allows users to search for tracks, albums and artists.

3. Local Playlist Management:
	* Create and manage local playlists within the application.
	* Add songs from Spotify searches to these playlists for personalized curation.

4. Personalized Song Comments:
   * Add personal comments to songs in local playlists.
   * Turn playlists into a collection of memories and stories.

# Running Application Locally

1. Clone the project repository from GitHub.
2. Ensure Java installed on your system.
3. Open the repository in your preferred Java IDE.
4. Set up the Maven, and get access token see below
   ### Generating Access Tokens
- For generating an access token: https://hopp.sh/r/Nt8tZ9jYThJW.
- Click send
- Save this generated `access_token`, it lasts 1 hour.
- Click the "More Actions" icon beside Run.
- Click "Edit".
- Inside "Main", in "Environment variables", add "API_KEY=`access_token`".

5. Add Necessary libraries Jackson for it project.
6. Run the 'Main' class to start the application.

### If packages are not working
`View` -> `Tool Windows` -> `Maven` -> `Reload All Maven Projects`