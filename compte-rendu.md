# Compte-rendu du TP de MDI portant sur les patrons de conception

## I. Introduction

## II. Pattern Observer

## III. Pattern Visitor

## IV. Pattern Decorator and State

### Question 1 : Les erreurs de conception dans le diagramme de classe proposé

Après étude du diagramme de classe initialement conçue, nous avons détecté plusieurs erreurs de conception et pistes d'améliorations, que nous allons lister ici.
- Tout d'abord, il ne devrait pas y avoir une classe pizza de laquelle hérite deux classes PetitePizza et GrandePizza. En effet, une pizza et soit grande soit petite, mais ne peut pas exister sans avoir une taille définie. Nous supprimerons donc les sous-classe pour simplement ajouter un attribut taille à la classe mère, qui sera égal à 'petite' ou 'grande'.
- Un collaborateur peut être soit pizzaiolo, soit coordinateur soit livreur. Il serait donc préférable de définir une interface 'Collaborateur' qui serait implémenté par les classes 'Pizzaiolo', 'Coordinateur' et 'Livreur'.
- 


## V. Conclusion