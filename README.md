# RPN

En **Notation Polonaise Inversée** (***Reverse Polish Notation***) les opérateurs (`+`, `-`, `*`, ...)
suivent les opérandes. Par exemple pour ajouter 3 et 4, au lieu d'écrire `3 + 4`, on écrira `3 4 +`.

S'il y a plusieurs opérateurs, les opérateurs sont écrits immédiatement après la second opérande.
L'expression `3 - 4 + 5` (qui pourrait s'écrire `(3 - 4) + 5`), s'écrira: `3 4 - 5 +`.
La première expression sera évaluée `3 4 -` en `-1`, on peut alors imaginer que l'expression initiale
devienne alors `-1 5 +` évaluée en `4`.

```
20 5 /          —>       (20/5) = 4
5 2 3 + -       ->      5-(2+3) = 0
4 2 + 3 -       —>      (4+2)-3 = 3
3 5 8 * 7 + *   —>  3*((5*8)+7) = 141
7 2 - 3 4       —>  5 3 4
```


# Projet

Objectifs:

  - [x] Le code doit compiler
  - [x] Les tests doivent passer
  - [x] Les tests devraient être enrichis
  - Supporter les opérateurs suivants:
    * [x] `+`
    * [x] `-`
    * [x] `*`
    * [x] `/` *(optionnel)*
    * [x] `^` _(bonus)_
  - [x] Supporter les nombres négatifs
  - [x] Supporter les nombres à virgules flottantes *(optionnel)*
  - [ ] Supporte l'usage & sélection de multiples implémentations _(bonus)_


## Lancer les tests:
_Remplacer mvn par `./mvnw` ou `./mvnw.cmd`) si vous utilisez le wrapper maven._
```shell
$ mvn clean test
```

## Executer le programme (via maven)
```shell
$ mvn compile exec:java -Dexec.args="4 3 +"
```

## Executer avec le jar
1. Générer le jar :
    ```shell
    $ mvn clean package
    ```

  Si les tests ne passent pas :scream:
    ```shell
    $ mvn clean package -DskipTests
    ```

2. Lancer le programme directement (une fois le jar générer):
    ```
    $ java -jar target/esgi-rpn-1.0-SNAPSHOT.one-jar.jar "4 3 +"
    ```


# Ressources

## Maven
  * [Maven wrapper](https://github.com/takari/maven-wrapper)
  * [Maven](https://maven.apache.org/run.html)
  * [Maven en français](https://www.jmdoudoux.fr/java/dej/chap-maven.htm)

## RPN
  * [RPN wikipedia](https://fr.wikipedia.org/wiki/Notation_polonaise_inverse)
