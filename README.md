# What Do You Meme...
...ist ein Kartenspiel. Ein Spieler zieht ein Bild und die anderen Spieler müssen ein lustiges Quote dazu finden. Danach wird das beste Quote gewählt.
![Alt text](img/81EH6+X0+VL._AC_SL1500_.jpg)



## Backend mit Spring Boot
Im Backend wird die Architektur Ports & Adapters verwendet. 

### Domänenklassen
Das Projekt besteht aus drei Entitäten:
- Quote: Text, der einem Bild zugeordnet werden kann (siehe blaue Karte oben) 
- Picture: Bild, zu einem Text das gewählt werden kann (siehe Bild oben)
- Meme: die Kombination aus Bild und Text

Diese Entitäten werden folgenden Datenfeldern haben:
- Picture
    - id
    - name
    - kategorie (enum)
    - url from https://api.memegen.link/templates/

- Quote
    - id
    - text

- Meme
    - id
    - date
    - picture
    - quote
    - likes

### Datenlayer
Der Datenlayer verwendet für CRUD JPARepository und die In-Memory Datenbank H2.

Der Datenlayer besteht aus einem Interface (Repository) für jede Entität:
- MemeJPARepo
- PictureJPARepo
- QuoteJPARepo
Diese Repos werden von den jeweiligen DbZugriffJPAPictureH2 verwendet.

### Servicelayer
Im Servicelayer wird für jede Entität ein Service angeboten. In diesem Beispiel besteht der Service nur aus dem Zugriff auf die DB. 

Pro Entität werden dafür zwei Interfaces (DbZugriffMeme, MemeService) und eine Implementierung(MemeServiceImpl) verwendet.

### Exception Handling
Damit beim Werfen einer Exception nicht das ganze System beendet wird, braucht es ein zentrales Handling. Ein ExceptionController übernimmt das systemweite Exception Handling. Er sendet auch eine Responseentity mit ensprechendem Fehlercode.

Hierfür braucht man eine Klasse die mit @ControllerAdvice gekennzeichnet ist. Für jede Exception muss eine eigene Methode erstellt werden.

Es werden eigene Exceptions für jede Entität und für die Formvalidierung erstellt.

### Controller
Da ein Thymeleaf- sowie ein JavaScript Frontend programmiert werden, werden zwei verschiedene Controller benötigt.
#### Thymeleaf Controller
Im Thymeleaf Controller werden die Services verwendet, um verschiedene Funktionen anzubieten. Hierbei werden nur Get- und Post-Mappings verwendet.

#### Rest Controller
Im Rest können alle Mappings verwendet werden. Hierbei findet auch ein Put- und ein Delete-Mapping neben den klassischen Get- und Post-Mapping Verwendung.

## Thymeleaf
Durch das Aufrufen von verschiedenen URLs kann das Backend in Thymeleaf angesprochen werden. Dieser Controller liefert ein ModelAndView bzw. String zurück.

Im HTML werden thymeleaf-spezifische Tags mit th: begonnen. Dafür muss am Anfang der Datei ein Namespace bestimmt werden.

## JS
JavaScript arbeitet mit dem Rest-Controller zusammen. Dabei werden asynchrone Anfragen an den Controller mit der richtigen Method und der URL gesendet. Es wird ein Promise zurückgesendet, dass in JSON umgewandelt werden kann. 

Danach wir der restliche DOM dynamisch mit den Werten aus der Antwort aufgebaut.