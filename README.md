# lol-profile-be

This is the back-end LolProfile project. The front-end can be found at https://github.com/gordonplumb/lol-profile-fe

This app retrieves data from Riot's API and stores it in a MySQL database. Get interesting stats, view match history and update your account/match list through the `/api` endpoint. 

## Getting Started

You will need a Riot API key. See https://developer.riotgames.com/ for details.

The app looks for environment variable `RIOT_API_KEY`, so make sure to set that with your key.

To set up the database:

```
docker pull mysql/mysql-server:latest
docker run -p 3306:3306 --name=mysql -d -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=lol_profile_dev -e MYSQL_USER=admin -e MYSQL_PASSWORD=root mysql/mysql-server
```

By default, the app will run on port 8080. 
