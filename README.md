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

ca sa faci rost de date de la user, vezi modelul asta pentru rest controller

```Java
@GetMapping("/path")
    public String getUser(Authentication authentication) {
        return "Email: " + ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
    }
```


mai trebuie facuta niste configuratie la rute (url pentru pagina de `/error`)

la prietenie: in db poti sa ai prietenie intre utilizatorii 2, 3 dar nu si intre 3, 2 ceea ce inseamna ca prietenia e doar de o parte...
e un pic dubios si nu foarte corect; rezolvare: creem automat la acceptarea unei cereri si prietenia inversa si o adaugam in baza de date?
---
# Rulare Backend + Frontend
Necesitati:
1. Referintele pe frontend trebuie sa fie relative (`/login`, nu `http://localhost:8080/login`)
2. Trebuie sa stim in avans pe ce pagini nu avem voie sa fim daca nu suntem logati ca sa putem face configurarea
3. Orice tine de backend si API (fara login si logout), trebuie sa aiba inceapa cu `/api/`

## Nginx
Nginx e un web server pe care o sa-l folosim pentru a ruta request-urile catre aplicatia corecta (frontend sau backend), in functie de path-ul dat. Adica orice request catre un link care incepe cu `/api/` (sau `/login`, `/logout` si `oauth`) va fi trimis catre backend, iar restul vor fi trimise catre frontend.

Asa arata configuratia:
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
	
	# trebuie sa fii logat sa le accesezi; nu exista inca
	location /test.html {
		auth_request /api/test;
		error_page 500 =302 /oauth2/authorization/google; 
		proxy_pass http://localhost:5173;
	}
}
}
```

Cum se ruleaza:
1. Se porneste backend-ul
2. Se porneste frontend-ul
3. Se ruleaza comanda `start nginx` intr-un terminal Powershell in acelasi folder in care se afla nginx.exe (este o arhiva cu toate fisierele)
4. Daca e nevoie de modificari, se modifica fisierul `conf/nginx.conf`, si se ruleaza `./nginx.exe -s reload`