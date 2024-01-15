# Backend-FilmApp

## MovieMatch

### Overview

MovieMatch is an application designed to streamline your movie preferences and social interactions. The application boasts several key features:

1. **Add Movies to Your List:** Easily add movies to your personal watchlist.
2. **Friendship Management:** Send, accept, or decline friendship requests.
3. **Movie Search:** Quickly find movies within the application.
4. **User Search:** Locate other users within the application.
5. **New Movie Notifications:** Receive notifications for newly added movies.
6. **Movie Filtering by Category:** Filter movies based on categories.
7. **Create a Shared List:** Establish a shared movie list with friends.
8. **Movie Deletion:** Remove movies from your lists.
9. **Already Watched List:** Maintain a list of movies you've already watched.
---

## UML Diagrams

The following UML diagrams illustrate the architecture of MovieMatch, including entities, constructors, and methods.

![StatusCerere](https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/30824deb-9dd7-4e77-9259-206f5edb6c8e)

![Film](https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/1b52f804-2e8c-42c7-b034-dc5d2b16d8ce)

![Prietenie](https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/aa109c7a-53f4-4277-9239-fbe3a37c7248)

![package](https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/7dbe2c89-d84f-4ec4-9daa-d93c9694e5a6)

![StatusVizionare](https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/3d94cb64-83c3-4942-af48-16f9643bdf3b)


## Running Backend + Frontend (https://github.com/DaniKDS/MovieMatch-Frontend)

### Prerequisites

1. Frontend references must be relative (`/login` instead of `http://localhost:8080/login`).
2. Determine the pages inaccessible without login for configuration purposes.
3. Backend and API paths (excluding login and logout) should start with `/api/`.
--- 

## Nginx Configuration

Use Nginx as a web server to route requests to the appropriate application (frontend or backend) based on the path. Requests starting with `/api/` (or `/login`, `/logout`, and `oauth`) go to the backend, while the rest go to the frontend.

```nginx
events{}
http{
server {
    listen 9090;
    server_name localhost;
    
    #backend
    location ~* /(api|oauth2|logout|login)/? {
        proxy_pass http://localhost:8083;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header Host $host:$server_port;
        proxy_pass_request_headers on;
    }
    
    # frontend
    location / {
        proxy_pass http://localhost:5173;
    }
    
    # login required; not implemented yet
    location /test.html {
        auth_request /api/test;
        error_page 500 =302 /oauth2/authorization/google; 
        proxy_pass http://localhost:5173;
    }
}
}
```
---
## Running the Project:

1. Start the Backend:
2. Start the Frontend:
3. Run the following command in a PowerShell terminal within the directory containing nginx.exe (an archive with all files).
start nginx
4. Make Changes (if needed):
If adjustments are required, edit the conf/nginx.conf file.
Reload Nginx Configuration (if needed):
./nginx.exe -s reload

## Concllusion

In closing, let's take a moment to reflect on our journey together. As BugBusters, we embarked on a mission to create MovieMatch, a platform designed to enhance the way users connect with movies and each other. Through collaboration, creativity, and a shared passion for problem-solving, we've not only addressed challenges but also transformed them into opportunities.

Our dedication and teamwork have shaped MovieMatch into a testament of our collective capabilities. Each line of code, every thoughtful design choice, and the countless debugging sessions have been keystones in the foundation of this project. It's more than just a collection of features; it's a manifestation of our commitment to excellence.
