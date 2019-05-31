# Compte-rendu du TP de MDI portant sur les patrons de conception

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
- 


## V. Conclusion