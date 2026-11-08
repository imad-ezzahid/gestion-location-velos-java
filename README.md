# Système de Gestion de Location de Vélos en Libre-Service (Java)

Projet en Java démontrant la modélisation et l'implémentation orientée objet d'un service de vélos partagés (type Vélib' / CityBike). L'application gère de bout en bout le cycle de vie des usagers, des stations d'accueil et des vélos en libre-service, en assurant l'intégrité métier et la cohérence des transactions.

---

## 🎯 Objectifs pédagogiques
- **Encapsulation & Cohérence d'état** : Protection des attributs critiques (`private`, `final`), validation stricte des préconditions et gestion des invariants (capacités des stations, seuils de crédit).
- **Relations entre classes** : Association bidirectionnelle et agrégation entre `Station`, `Velo` et `Abonne`.
- **Règles métiers & Robustesse** :
  - Empêcher la location d'un vélo en maintenance ou absent de la station.
  - Interdire le cumul de locations simultanées pour un même abonné.
  - Bloquer la restitution si la station d'arrivée a atteint sa capacité maximale.
  - Gestion du débit de compte et mise à jour automatique du kilométrage.
- **Tests & Scénarios fonctionnels** : Validation unitaire et fonctionnelle des cas nominaux et des cas limites dans `TestVelos`.

---

## 🏛️ Architecture et Modèle de Classes

```text
       ┌──────────────┐             ┌──────────────┐
       │   Station    │◇───────────*│     Velo     │
       ├──────────────┤             ├──────────────┤
       │ - nom        │             │ - numero     │
       │ - capacite   │             │ - km         │
       │ - velos      │             │ - reparation │
       └──────────────┘             └──────────────┘
              ▲                            ▲
              │                            │
       ┌──────────────┐                    │
       │    Abonne    │────────────────────┘ (veloLoue : 0..1)
       ├──────────────┤
       │ - nom        │
       │ - credit     │
       │ - veloLoue   │
       └──────────────┘
```

- **`Velo`** : Représente une bicyclette identifiée par un numéro immuable, avec historique de distance parcourue et état de maintenance.
- **`Station`** : Gère un parc local de vélos limité par une capacité d'accueil. Assure l'admission et la sortie sécurisée des vélos.
- **`Abonne`** : Représente l'usager avec son solde prépayé. Coordonne les opérations de prise et de dépose avec les stations.
- **`TestVelos`** : Classe exécutable simulant un scénario d'utilisation réel avec plusieurs stations et usagers.

---

## 📂 Structure du projet

```text
gestion-location-velos-java/
├── README.md               # Documentation complète
├── .gitignore              # Exclusion des fichiers compilés (.class)
├── src/
│   ├── Abonne.java         # Modèle Abonné et opérations de location
│   ├── Station.java        # Modèle Station et gestion des bornes
│   └── Velo.java           # Modèle Vélo et état d'exploitation
└── tests/
    └── TestVelos.java      # Scénario de tests d'intégration et assertions
```

---

## 🛠️ Compilation et exécution

### Prérequis
- Java Development Kit (JDK 11 ou version ultérieure, testé avec OpenJDK / Oracle JDK 17).

### 1. Compilation
Depuis la racine du projet :
```bash
javac -d bin src/*.java tests/*.java
```

### 2. Exécution des tests
```bash
java -cp bin TestVelos
```

### Exemple de sortie attendue :
```text
Louer vélo en réparation : false
Louer v1 : true
Second vélo en cours : false
Rendre en station pleine : false
Crédit insuffisant : false
```

---

## 👤 Auteur
**Imad Ezzahid** ([@imad27-maker](https://github.com/imad27-maker)) — Étudiant en Licence Sciences et Techniques (Informatique)