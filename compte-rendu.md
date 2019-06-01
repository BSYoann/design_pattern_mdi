# Compte-rendu du TP de MDI portant sur les patrons de conception

Timothée Schneider-Maunoury

Yoann Breton

## I. Introduction

Le but de ce TP est de découvrir et d'implémenter plusieurs types de patrons de conception.

## II. Pattern Observer

Nous avons implémenté le design pattern observer en créant un boite aux lettres (MailBox) sous forme de design pattern singleton qui est un Sujet (Subject). Nous avons créé des observateurs qui implémente l'interface IObserver.
- CounterObserver qui compte le nombre de mail reçu par la boite aux lettres
- LastMailObserver qui regarde le dernier mail reçu dans la boite aux lettre

Voici le diagramme UML de notre programme :

![Diagramme UML du design pattern observer](uml/observer_uml.jpg?raw=true)

Nous pouvons grace à la mise en place de ce design pattern ajouter autant d'observateurs que l'on veut à notre boite aux lettres (MailBox). Ici si l'on ajouter un CounterObserver et un LastMailObserver, nous avons juste à appeler la fonction notifyObservers() lors d'un changement pour que les observateurs mettent à jour leurs informations.

## III. Pattern Visitor



## IV. Pattern Decorator and State

### Question 1 : Les erreurs de conception dans le diagramme de classe proposé

Après étude du diagramme de classe initialement conçue, nous avons détecté plusieurs erreurs de conception et pistes d'améliorations, que nous allons lister ici.

- Tout d'abord, il ne devrait pas y avoir une classe pizza de laquelle hérite deux classes PetitePizza et GrandePizza. En effet, une pizza et soit grande soit petite, mais ne peut pas exister sans avoir une taille définie. Nous supprimerons donc les sous-classe pour simplement ajouter un attribut taille à la classe mère, qui sera égal à 'petite' ou 'grande'.
- Un collaborateur peut être soit pizzaiolo, soit coordinateur soit livreur. Il serait donc préférable de définir une interface 'Collaborateur' qui serait implémenté par les classes 'Pizzaiolo', 'Coordinateur' et 'Livreur'.
- C'est la classe Pizza qui possède des références vers des 'Commande'. Cela devrait être l'inverse, une 'Commande' qui possède des références vers 1 à 5 'Pizza'.
- Un client a des références vers des 'Commande' et des commandes en cours. Une seule des deux pourrait être nécessaire s'il on rajoutait la valeur 'EnCoursDeCommande' dans l'enum EtatCommande.

Après quelques corrections, voici le diagramme de place :

![Diagramme de classe Gotham Pizzas après correction](uml/Gotham_Pizzas_UML.jpeg?raw=true)

### Question 2 : Le design pattern decorator pour changer le prix d'une commande

Voici à quoi le diagramme UML ressemble si l'on implémente le design pattern decorator :

![Diagramme de classe Gotham Pizzas avec design pattern decorator](uml/Gotham_Pizzas_Retard_UML.jpeg?raw=true)

S'il n'y a aucun retard, on prend le prix de la client Prix. Sinon on prend le prix de la classe PrixEnRetard qui fera le calcul en fonction du prix normal. On pourrait ajouter d'autre prix modifié qui hérite donc du décorateur 'PrixModifié'. Ce serait le cas si l'on voudrait faire un prix happy hours, on créer une classe PrixHappyHours qui hérite de Prix modifié et qui donne le prix de la commande à 50%.

### Question 3 : Le design pattern state

Jusqu'ici la classe Commande avait la possibilité d'appeler ces opérations dans n'importe quel ordre. Or l'ordre a une importance puisque qu'on ne peut pas 'Emportée' une commande s'il elle n'a pas été préparée avant.

Le design pattern State nous permet d'avoir un ordre définie, un état définie lequel est l'état suivant. Voici le diagramme de classe UML :

![Diagramme de classe State](uml/State_UML.jpeg?raw=true)

Chaque étape change l'état de la commande quand celle-ci est finie. On aura donc DemarragePreparation -> FinPreparation -> Emportee -> Livree.

## V. Conclusion

Ces différents exercice nous on permis de découvrir certains design pattern dans des exemples concrets. Cela permet d'être plus modulable et plus flexible si l'on veut rajouter des fonctionnalités au système (sans eux il faudrait souvent revoir toute l'architecture du système).