# Backend-FilmApp

## Description

### server.port=8083 in application.properties

<img width="894" alt="image" src="https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/6a2c1955-2576-4fb7-86f6-b985323bc861">

<img width="934" alt="image" src="https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/edf4643b-77f8-4b57-aa8d-48cb2caadbc9">

<img width="892" alt="image" src="https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/6497c5e1-4543-405b-b352-69878f7ad63b">
#dupa ce v-ati conectat la baza de date si cumva pusca, va rog dati drop , o creati din nou si rulati proiectul ! 
#drop database ProiectColectiv1

Gasiti pe teams !!!




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