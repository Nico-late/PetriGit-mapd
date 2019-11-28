Référentiel des documents

Nous avons réutilisé le modèle développé par nos soins dans le début du fil rouge, le tout étant dans 
org.pneditor.petrinet.models.roullier_schweitzer_scholten.
Il contient donc une classe pour définir les places, une pour les transitions, une pour les arcs, 
une classe PetriNet implémentant l'interface IPetriNet, une classe définissant une exception,
et une dernière pour tester le modèle

Nous avons ensuite réalisé notre propre adapteur, composé de 4 classes toutes contenues dans le package
org.pneditor.petrinet.adapters.roullier_schweitzer_scholten.
Ces classes sont PetriNetAdapter, ArcAdapter, PlaceAdapter et TransitionAdapter, qui permettent chacune d'adapter notre modèle
à la classe abstraite ou interface correspondante dans org.pneditor.petrinet
(respectivement PetriNetInterface, AbstractArc, AbstractPlace, AbstractTransition).

Nous avons travaillé à trois sur chaque classe, et de manière variée; il nous est ainsi difficile de mettre un ou des noms
précis sur chaque classe codée.
Dates :
-5/11 Ajout du modèle, d'AdapterTransition, AdapterPlace, AdapterArc et AdapterPetriNet
-6/11 Completion d'AdapterTransition, AdapterPlace, AdapterArc et AdapterPetriNet
-27/11 Ajout des commentaires