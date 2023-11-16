# Backend-FilmApp

## Description

### server.port=8083 in application.properties


pentru Butonul de login, sa foloseasca `<a href='/oauth2/authorization/google'></a>`
pentru cel de logout, `<a href='/logout'></a>`


trebuie adaugata logica pentru creating a new user 

ca sa faci rost de date de la user, vezi modelul asta pentru rest controller

```Java
@GetMapping("/path")
    public String getUser(Authentication authentication) {
        return "Email: " + ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
    }
```


mai trebuie facuta niste configuratie la rute