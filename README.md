[![travis](https://travis-ci.org/Amuerte/borbah.svg?branch=master)](https://travis-ci.org/Amuerte/borbah)

![logo](http://www.thrillingdetective.com/images/borbah.jpg)

borbah
======

> bor'ba/борьба (Russian)  
>     1. *n* a fight - a situation in which you use a lot of effort to defeat someone or achieve something  
>     2. *art (Charles Burns)* El Borbah is a private eye who wears a Mexican wrestler's tights subsisting entirely on junk food and beer  
>     3. *n* Rest API to manage players during a tournament/fight/battle

## Build

```bash
gradlew clean build shadowJar
run.sh
```

## More coming soon : 

### Core
- Validation des parametres de PlayerResource
- Test PlayerResource
- Pagination sur findAll (-> revoir Index gsi ?)
- Test Integ du repository (Conflit kotlin-test vs Runner Junit 5)

### Transverse
- authentication
- metrics
- https (merge branch + variable env dans script run.sh)
- configuration client http aws sdk
- swagger2markup api doc generation for github
