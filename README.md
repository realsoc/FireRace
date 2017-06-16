# FireRace
L'application a pour but de récupérer la dernière course dans l'API de courses de F1 http://ergast.com/api/, et affiche l'age moyen des pilotes de la dernière course à l'user après avoir gardé les données dans une BDD Firebase https://console.firebase.google.com/project/firerace-2251c/.

La BDD est ouverte à tout user, authentifié ou non.

<img src="https://raw.githubusercontent.com/realsoc/FireRace/master/screenshot_FireRace.png" alt="Screenshot de l'application" width="400">

## API CALL 
L'appel à l'API est faite à l'aide du client Retrofit de manière asynchrone.

Retrofit fait interface avec l'API simplement et créé nos classes JAVA à partir du json via gson.

## FIREBASE 
La dernière course est gardée en BDD.

Un listener actualise le compteur en cas de modification en BDD.

## UI
Utilisation d'un code externe pour animer le compteur et donner un peu de vie à l'application.

Effet de ralentissement ~ roulette de casino ~ jusqu'à arriver à la valeur désirée.

## TODO
Quelques points peuvent être améliorés :
* L'UI est minimal et pourrait subir quelques amélioriations
* L'app ne garde que la dernière course, on pourrait garder un historique des courses plus anciennes
* Traiter les données pour apporter de nouvelles fonctionnalités à l'user, courbes d'évolution des ages etc
* ...
