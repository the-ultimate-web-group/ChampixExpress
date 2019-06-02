# Champix Express

## Description

Les objectifs de ce projet sont de mettre en oeuvre les technologies suivantes :
- Architecture logicielle : Spring Boot
- Interface homme/machine : JSTL, BOOTSRAP, JQUERY, Responsive-Design,..
- Couche Métier : EJB 3.1 (StateLess, JMS synchrone )
- Couche Persistance : JPA/Hibernate
- Authentification en utilisant Json Web Token

## Commencer

Le projet est décomposé en 3 modules.

🍄 `ClientApplication` : un module de réservation en ligne pour une voiture libre sur une borne
- interface homme/machine de saisie
- produiction d’un message JMS qui indiquera le détail de la réservation

🍄 `AdminApplciation` : un module de visualisation des réservations dans les bornes
- planning global
- planning par borne

🍄 `ServerMOM` : un module serveur qui enregistre les données du message dans la base AutoLib

### Conditions préalables

- Serveur Wildfly 16 configuré avec le standalone.xml présent dans le zip.
- Base de données AutoLib importée depuis le script `sql/autolib.sql`

### Environnement

- JDK 1.8
- IDE Intellij

### Installation


`` `
étapes
`` `


## Déploiement

`` `
étapes
`` `

## Construit avec

* [Maven] (https://maven.apache.org/) - Gestion des dépendances
* [SpringBoot] (https://spring.io/projects/spring-boot) - Framework Java

## Versioning

Nous utilisons [Github] (https://github.com/) pour la gestion des versions.

## Auteurs

- **Valentin Berger** - *Client Application*
- **Alexandre Bruhat** - *Server*
- **Thibault Chatelain** - *Admin Application*
- **Léa Chemoul** - *Client Application*
- **Ilorian Ciavaldini** - *Server*