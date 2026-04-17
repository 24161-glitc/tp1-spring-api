Partie 8 : Questions de réflexion

7. Quelle est la différence entre @RestController et @Controller ?

•	@Controller : Cette annotation est utilisée pour les applications Spring MVC classiques. Elle renvoie généralement une vue (une page HTML) traitée par un moteur de template.
•	@RestController : C'est une annotation spécifique aux API REST qui combine @Controller et @ResponseBody. Elle indique que chaque méthode renvoie directement des données (généralement en JSON) dans le corps de la réponse HTTP au lieu de renvoyer une page web.

8. Pourquoi utiliser un DTO (Data Transfer Object) ?

L'utilisation d'un DTO est essentielle pour plusieurs raisons :
•	Sécurité : Il évite d'exposer directement la structure de la base de données (l'entité) aux utilisateurs externes.
•	Découplage : Il permet de modifier la structure interne de la base de données sans casser l'interface de l'API utilisée par les clients.
•	Optimisation : Il permet de ne transférer que les champs nécessaires pour une requête spécifique, réduisant ainsi la taille des données échangées.

9. Quel est le rôle de @Transactional ?

L'annotation @Transactional permet de gérer les transactions de manière déclarative. Elle garantit que toutes les opérations effectuées dans une méthode (par exemple, plusieurs sauvegardes en base de données) sont traitées comme une seule unité : soit elles réussissent toutes, soit, en cas d'erreur, toutes les modifications sont annulées (rollback) pour maintenir la cohérence des données.

10. Quelle est la différence entre findById() et getById() ?

•	findById() : Cette méthode de Spring Data JPA effectue une requête immédiate en base de données et retourne un objet Optional. Elle est utilisée quand on veut vérifier si l'entité existe réellement.
•	getById() (souvent remplacée par getReferenceById()) : Elle retourne un proxy (une référence) de l'entité sans charger immédiatement toutes ses données. Elle est plus performante si vous avez seulement besoin de l'identifiant pour créer une relation avec une autre entité sans consulter ses autres propriétés.

11. Pourquoi utiliser la validation (@Valid) ?

L'utilisation de @Valid associée à des contraintes (comme @NotNull ou @Size) est indispensable pour :
•	Filtrer les données entrantes : Elle empêche l'enregistrement de données incorrectes ou incomplètes dans la base de données.
•	Gestion automatique des erreurs : Spring rejette directement la requête avec un message d'erreur si les critères ne sont pas respectés, garantissant ainsi l'intégrité des données du système.


