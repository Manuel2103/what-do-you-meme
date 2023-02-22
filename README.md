# What Do You Meme...
...ist ein Kartenspiel. Ein Spieler zieht ein Bild und die anderen Spieler müssen ein lustiges Quote dazu finden. Danach wird das beste Quote gewählt.
![Alt text](img/81EH6+X0+VL._AC_SL1500_.jpg)

## Grundstruktur des Projekts
Das Projekt besteht aus drei Entitäten:
- Quote: Text, der einem Bild zugeordnet werden kann (siehe blaue Karte oben) 
- Picture: Bild, zu einem Text das gewählt werden kann (siehe Bild oben)
- Meme: die Kombination aus Bild und Text

Diese Entitäten werden folgenden Datenfeldern und Funktionen haben:
- Picture
    - id
    - name
    - kategorie
    - url from https://api.memegen.link/templates/
    - Funktionen:
        - addPicture (Bild hinzufügen)
        - getAllPictures (alle Bilder anzeigen)
        - getPictureByID (bestimmtes Bild anzeigen)
        - getRandomPicture (zufälliges Bild anzeigen)
        - deletePicture (Bild löschen)
        - updatePicture (Bildinformation updaten)
- Quote
    - id
    - text
    - Funktionen:
        - addQuote (Text hinzufügen)
        - getAllQuotes (alle Texte anzeigen)
        - getQuoteByID
        - get4RandomQuotes (4 zufällige Texte anzeigen)
        - deleteQuote (Text löschen)
        - updateQuote (Textinformation aktualisieren)
- Meme
    - id
    - datetime
    - pictureid
    - quoteid
    - likes
    - Funktionen:
        - addMeme
        - deleteMeme
        - showLast5Memes (letzten 5 Memees anzeigen)
        - getAllMemes
        - getAllMemesAfter(Datetime)
        - getMemeByID
        - getFavoriteMeme (meiste Likes)
        - addLike (Like hinzufügen)

Funktionen: 
Boilerplate
Standard-Crud


~ deleteMemePictureQuote


## Backend mit Spring Boot

## Thymeleaf

## JS