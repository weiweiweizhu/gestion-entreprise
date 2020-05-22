# gestion-entreprise
c'est une exercice avec java poo l'heritage



Exercice à faire par groupe :
Une entreprise a un certain nombre d’employés.
Un employé est connu par
- son nom.
- son matricule (qui l’identifie de façon unique).
- son indice salarial.
Le salaire est calculé en multipliant cet indice par une certaine valeur qui peut
changer en cas d’augmentation générale des salaires, mais qui est la même pour tous les employés.
Question 1
Écrivez la classe des employés avec les informations utiles et des méthodes pour afficher les
caractéristiques d’un employé et pour calculer son salaire.
Question 2
Certains employés ont des responsabilités hiérarchiques.
Ils ont sous leurs ordres d’autres employés.
Écrivez une sous-classe des employés qui représente ces responsables en enregistrant leurs
inférieurs hiérarchiques directs dans une structure (tableau ou autre).
Écrivez une méthode qui affiche les inférieurs directs (placés directement sous leurs ordres).
Question 3
Les commerciaux, qui sont aussi des employés, ont un salaire composé d’un fixe et 
d’un intéressement proportionnel à leurs nombre de ventes.
Le fixe d'un commercial peut être différent de celui d'un autre commercial.
Si le nombre de ventes entre 10 et 20 alors le salaire est égal au fixe plus 1/5 du fixe
Si le nombre de ventes entre 20 et 50 alors le salaire est égal au fixe plus 1/3 du fixe
Si le nombre de ventes entre 51 et 80 alors le salaire est égal au fixe plus 2/3 du fixe
Si le nombre de ventes > 80 alors le salaire est égal à 2 * fixe.
Écrivez une sous-classe des commerciaux qui contient l’information sur leurs ventes du dernier
mois, une méthode pour mettre à jour cette information et redéfinissez
la méthode de calcul de leurs salaires.
Un commercial peut être reponsable et avoir dans son équipe des employés simples ou des commerciaux ou 
des responsables qui sont en même temps des commerciaux ou des responsables qui ne sont pas des commerciaux.
Question 4
Écrivez un programme avec un menu qui permet de :
- créer un employé simple
- créer un responsable
- créer commercial
- afficher la liste des employés / commerciaux / responsables.
- afficher le salaire d'un employé dont l'id est saisi
- afficher le total des salaires de tous les employés
- ajouter/supprimer un employé existant (dont l'id est saisi) à l'équipe d'un responsable dont l'id est saisi
- supprimer un employé d'une équipe d'un responsable
- afficher l'équipe d'un responsable
- modifier l'indice salarial d'un employés
- modifier la valeur fixe des salaires des employés
- modifier le nombre de vente d'un commercial
- modifier la valeur du salaire fixe d'un commercial
- modifier la valeur d’intéressement des commerciaux
contrainte :
- un employé ne peut pas être son propre responsable.
- un employé ne peut pas être responsable directement ou indirectement de son responsable.
- si on supprime le responsable d'une équipe, les employés de cette équipe sont intégrés à l'équipe du responsable
de l'employé supprimé. Si l'employé supprimé est responsable qui n'a pas de responsable, alors ses sous employés
ne sont affectés à aucune équipe. 
