<!--
author:   Falko Krügel

email:    faklo.kruegel@tu-dresden.de

version:  0.0.1

language: de

icon:     https://upload.wikimedia.org/wikipedia/commons/f/f9/Logo_TU_Dresden.svg

link:     style.css

@onload
  LIA.settings.sound = false;
  LIA.settings.mode = "Slides";
@end

-->

# Der Digitale Versorgungsatlas (DVA)

Die Inhalte sind als aufbereitet als Foliensatz auch hier erhätlich: [Der DVA als  ] (https://raw.githubusercontent.com/GeoinformationSystems/dva/main/Readme.md#1) [https://liascript.github.io/course/?](https://raw.githubusercontent.com/GeoinformationSystems/dva/main/Readme.md#1)https://raw.githubusercontent.com/GeoinformationSystems/dva/main/Readme.md#1

<h4>Was ist der DVA?</h4>

                          {{0-4}}
***********************************************************

Der _Digitale Versorgungsatlas_, kurz _DVA_, ist eine **Webanwendung** zur Einsicht von Versorgungsinfrastrukuten der Daseinsvorsorge im Bundesgebiet und zur Betrachtung von Versorgungssituationen.

***********************************************************

                          {{1-4}}
***********************************************************


Der _DVA_ ist aber auch ein **Methodenservice**, mit dessen Hilfe durch eine ArcGIS Toolbox individuelle gravitationsbasierte Versorgungsanalysen, Erreichbarkeitsmatritzen und Isochronen im dt. Bundesgebiet berechnet werden können.

***********************************************************

                          {{2-4}}
***********************************************************

<h4>Der DVA und diese Dokumentation ist eine Zusammenarbeit von:</h4>

Dr. Stephan Mäs - Professur für Geoinformatik

M.Sc. Falko Krügel - Professur für Geoinformatik

B.Sc. Erik Buthmann - Professur für Geoinformatik

B.Sc. Paul Hindorf - Professur für Geoinformatik

TU Dresden

_Stand der Dokumentation: 20.03.2024_



---
***********************************************************

                          {{3-4}}
***********************************************************

Wenn du ein Anwender bist, sind für dich folgende Punkte interessant:



1.  Die DVA-Webanwendung

- Themen (Karteninhalte der Anwendung)

- Räumliche Analysen

  - Entscheidungsunterstützung

  - Räumlicher Zugang

2. **Zugriff auf die Methoden - die ArcGIS Toolbox DVA_Tools**

- Enhanced 2SFCA

- Isochrones

- Matrix


Wenn du Entwickler bist, sind für dich folgende Punkte interessant:

1. Architektur

2. Setup
___

***********************************************************

# Die DVA-Webanwendung
Bereitstellung bei Produktivgang
## Themen
Bereitstellung bei Produktivgang
## Räumliche Analysen
Bereitstellung bei Produktivgang
### Entscheidungsunterstützung
Bereitstellung bei Produktivgang
### Räumlicher Zugang
Bereitstellung bei Produktivgang

# Die DVA-ArcGIS-Toolbox
Bereitstellung bei Produktivgang
## Einzugsgebiete
Bereitstellung bei Produktivgang
## Distanzmatritzen
Bereitstellung bei Produktivgang
## Räumlicher Zugang
Inhalt in Arbeit
Die Bestimmung der räumlichen "Zugänglichkeit" eines bestimmten Dienstleisters (Angebotsstandort) für Wohnorte der Bevölkerung (Nachfragestandorte) mit _2SFCA-Methodengruppen_ bzw. _gravitationsbasierten Zugangsanalysen_ ist komplexer als die üblichen geographischen Fragestellungen wie:

- Frage nach dem Einzugsgebiet: Wohnt eine bestimmte Person in einem Einzugsgebiet eines Dienstleisters? (Antwort ja/nein)

- Frage nach der Distanz(-matrix): Welche Distanz (Zeit- oder Entfernungsmaße wie Minuten oder Kilometer) muss zwischen Angebots- und Nachfragstandort überwunden werden? (Antwort Maßzahl in Zeit oder Minuten)

Diese eher üblichen geographischen Analysen beantworten nicht die Frage ob der Dienstleister für die (oder den einen speziellen) Nachfrager überhaupt verfügbar ist (Frage nach einer Dimension der Zugänglichkeit im Zuge von Auslastung/Accessibility in the course of capacity utilisation). D.h. die obigen Fragen beantworten nicht die lokale Nachfrage nach diesem Anbieter. Luo und Qi entwickelten die Enhanced Two-Step Floating Catchment Area (E2SFCA)-Methode, um eine Messung zu ermöglichen, die intuitiv sinnvoll ist, um den räumlichen Zugang zu (Gesundheits-)Dienstleistern zu bestimmen.

Für die Berechnung der Enhanced2SFCA sollten folgende Eingabedaten vorliegen:

Nachfragestandorte - oder -flächen (möglichst klein räumlich als Punkt- oder Shapefeatureclass)

Angebotsstandorte /Dienstleister

Optional sind Gewichtungsfelder die z. B. die Kapazitätskennziffern bei Anbietern (Zahl der Ärzte etc.) oder die Menge der Nachfrager modellieren (z.B. Zahl der Einwohner).


# Die Methoden zur Versorgungsanalyse
## Einzugsgebiete und Erreichbarkeiten
### Einleitung

<h4>Reicht die Ermittlung von Reisezeit oder Einzugsgebieten für Versorgungsanalysen denn nicht mehr aus?</h4>

                          {{1-1}}
***********************************************************
Leider nein!

Wir benötigen mehr, als die einfachen Reisezeiten von einem Angebotsort zu einem Nachfrageort als uns die Ermittlung von Reisezeiten über Einzugsgebiete oder auch Distanzmatrizen liefern würden.

Diese Art der Analysen sagen uns zwar, **ob** ein Anbieter _theoretisch_ zu erreichen ist, sie sagen aber nicht, ob er _praktisch_ für alle Nachfrager zugänglich ist. In Englischen wird dies unter dem Begriff "*accessibility*" geführt, worauf wir später eingehen.


 <h4> Um die knappe Antwort '*Leider nein*' zu verstehen, schauen wir uns ein plastisches Beispiel im nächsten Kapitel *Grenzen von Einzugsgebietsanalysen* an. </h4>

***********************************************************
### Grenzen von Einzugsgebietsanalysen

<h4>Grenzen von Einzugsgebietsanalysen:</h4>


                          {{1-9}}
***********************************************************
Sehr allgemein formuliert: Bei einem Einzugsgebiet handelt es sich um ein geographischen Raum, der um einen definierten Einflussbereich eines bestimmten Objektes liegt.

Um dem jedoch eine etwas schärfere Definition zu geben, die sich eignet um antrophogeograhische Fragestellungen, wie z. B. aus der Versorgungsforschung, zu beantworten, konretisieren wir diese Definition:
***********************************************************

                          {{2-9}}
***********************************************************

Ein **Einzugsgebiet**, umschließt einen Dienstleistungsort einen geographischen Raum, welches den Einflussbereich der Dienstleitung definiert. Die Beschreibung des umschlossenen Raumes erfolgt mit Entfernungs- oder Zeiteinheiten und wird über Luftlinie (*radiales Einzugsgebiet*) oder auch über ein Konstrukt aus Wegebeziehungen, z.B. *Straßennetzwerk* gebildet.

***********************************************************

                        {{3-9}}
***********************************************************
Die **Einzugsgebietsanalyse** ermöglicht es, die Eigenschaften eines oder mehrerer Einzugsgebiete mittels geographischer Analysemethoden zu beschreiben. Es ist beispielsweise möglich, die Größe (*Fläche, Ausdehnungseigenschaften, Topologie*) des Einzugsgebietes zu identifizieren oder die darin enthaltenen Elemente (*Potentiale*) zu ermitteln.

![Beispielhaftes Einzugsgebiet](doc/pic/chatchment_explainer.jpg "Abb.: Um einen Dienstleistungsort gebildetes radiales Einzugegebiet (rote Linie) und netzwerkabhäniges Einzugsgebiet (blaue Fläche).")

***********************************************************


                          {{4-9}}
***********************************************************
Bauen wir nun unser Beispiel Stück für Stück auf.
Betrachten wir hierzu die Nachfrage einer Dienstleistung in einem zufällig gewählten Raumausschnitt, die durch das fiktive Angebot einer Dienstleistung versorgt werden sollten.


***********************************************************

                          {{5-9}}
***********************************************************

Gehen wir in unserem Beispiel ferner von folgemdem aus:

<span style="color: #335A17;font-weight: bold;"> Angebot:</span>.

Das Angebot einer Dienstleistung wird durch eine hausärztliche Einzelpraxis repräsentiert, deren Fachpersonal ca. 2.000 Einwohner (und damit in etwa 1.600 zu behandelnde Personen in einem Quartal) versorgen kann.

<span style="color: #B2B2B2;font-weight: bold;"> Nachfrage:</span>

Ein 100x100m Raster repräsentiert die Nachfragestandorte. Die Höhe der Nachfrage nach einem ärztlichen Angebot wird durch die Bevölkerungszahl am Wohnort anhand der innenstehenden Zahl repräsentiert.

![Beispielhaftes Untersuchungsgebiet](doc/pic/suppyer_demander.jpg "Abb.: Angebotsstandort (grüner Punkt) in einer Wohngebietslage in Hannover mit Wohnortbevölkerung als Nachfragestandorte (graues Raster)")<!--- style "with:100px" --->

***********************************************************

                          {{6-9}}
***********************************************************

Beginnen wir nun mit einer einfachen Einzugsgebietsanalyse.
Finden wir heraus, wie viele Einwohner (Nachfragepotential) mit einer PKW-Fahrzeit von 2 Minuten den Standort erreichen.

<span style="color: red;font-weight: bold;"> 2-Min Einzugsgebiet:</span>

Welche Nachfragestandorte (Bevölkerung) nach einer Dienstleistung (hausärztliches Angebot) erreichen binnen <span style="color: red;font-weight: bold;">zwei Minuten PKW-Fahrzeit</span> den Dienstleistungsort (hausärztliche Praxis)?

<span style="color: #08306B;font-weight: bold;"> Nachfragepotential:</span>

Wie groß ist das Nachfragepotential für diesen Standort?

![Beispielhaftes Einzugsgebiet](doc/pic/catchment120_supplyer.jpg "Abb.: 2 Min-PKW-Einzugsgebiet um den Angebotsstandort (grüner Punkt)")<!--- style "with:100px" --->


***********************************************************

                          {{7-9}}
***********************************************************

 <h4> Welche Antworten gibt uns nun also unsere geographische Einzugsgebietsanalyse? </h4>

1. Die räumliche Ausdehnung des Einzugsgebietes und die enthaltenen Nachfragestandorte
2. Die Menge der Bevölkerung, die binnen zwei Minuten PKW-Fahrzeit einen Arzt erreichen.

Wenn wir nun die Bevölkerung im Einzugsgebiet aufsummieren, kommen wir zu einer recht erstaunlichen Menge von 23.211 Einwohnern, die für die Einzelpraxis potentiell zu behandelnde Personen sein können.


Folgende Aussage können wir treffen:

**Binnen 2 Minuten per PKW-Fahrzeit erreichen mehr als 23.000 Einwohner eine Arztpraxis.**
***********************************************************

                      {{8-9}}
***********************************************************
Und damit sind wir bei den Grenzen!

Nur weil wir das Versorgungsgebiet einer Infrastruktur und das darin enthaltene Nachfragepotenzial kennen, ist die Situation oder Qualität der Versorung defr Einwohner noch lange nicht bekannt.

<h4> Grenzen von Einzugsgebietsanalysen:</h4>
Diese geographischen Analysen beantworten die Fragen ob eine Dienstleitung **erreichbar** ist. Ein Verständnis, ob eine Dienstleitung für die Nachfragenden überhaupt verfügbar ist, lässt damit nicht gewinnen (Frage nach einer Dimension der Zugänglichkeit im Zuge von Auslastung).

Wirdmen wir uns daher im nächsten Kapitel den gravitationsbasierten Analysemethoden


***********************************************************

## gravitationsbasierte Analysemethoden I
### Theorie und graphisches Beispiel

{{1-10}}
***********************************************************
Sogenannte gravitationsmodelle werden in der räumlichen Planung verwendet, um bestimmte Verhaltensweisen vorherzusagen und zu beschreiben, die sich ähnlich der in den Gravitationsgesetzen von Isaac Newton beschriebenen Gravitationsinteraktion wiederfinden.

Im Allgemeinen enthalten die sozialwissenschaftlichen Modelle einige Elemente von Masse und Entfernung, was ihnen die Metapher der physikalischen Schwerkraft verleiht. Ein Gravitationsmodell liefert eine Schätzung des Volumens der Ströme von z. B. Waren, Dienstleistungen oder Menschen zwischen zwei oder mehreren Orten.
***********************************************************

{{2-10}}
***********************************************************
Die Berücksichtung einer "Anziehungskraft" ist eine wichtige Vorsetzung, um Versorgung besser zu verstehen. Wir konzentrieren uns im folgenden auf die 2SFCA-Methodengruppe (engl. Two-step floating catchment area method). Um uns der Metode zu nähern gehen wir wieder mit plastischen Beispielen Schritt für Schritt vor.
***********************************************************

{{3-10}}
***********************************************************
 Luo und Qi entwickelten 2009 die Enhanced Two-Step Floating Catchment Area (E2SFCA)-Methode, um eine Messung zu ermöglichen, die intuitiv sinnvoll ist, um den räumlichen Zugang zu (Gesundheits-)Dienstleistern zu bestimmen. Sie basieren auf den vorausgegangenen Überlegungen von Luo und Wang (2003) und Radke und Mu (2000). Die Methodengruppe ist darüber hinaus eng verbunden mit den von Huff (1964) getroffenen Erkenntnissen zu Einzugsgebieten.
***********************************************************

{{4-10}}
***********************************************************
Die Herleitung der E2SFCA unterehmen wir wie folgt:

1. Suche für jenden Versorgungsstandort (_Suppyer_) _S<sub>1</sub>_...

2. die geographisch verteilten Bevölkerungsstandorte (_Population_) von _P<sub>k</sub>_...

3. die sich durch innerhalb eines Einzugsgebiet mit einer Enfernung (_Distance_) von _d_ bis _d<sub>0</sub>_ befinden.

4. Berechne das Verhältnis (_Ratio_) _R<sub>j</sub>_  zwischen des Versorgungsstandortes und der jeweiligen Bevölkerung innerhalb des Einzugsgebietes.   


![2sfcaexplainer_step1_1](doc\pic\2sfcaexplainer_step1_1.gif "Abb.: 1. Schritt der 2sfca-Methode - Verhältnis von Angebot (P<sub>k</sub>) und Bevölkerung (P<sub>k</sub>) ermitteln.")

***********************************************************

{{5-10}}
***********************************************************

5. Der erste Teilschritt ist für alle Standorte wiederholbar. _Bemerkung: Berücksichtige, dass durch diese Schritte eine Gewichtung von Kapazitätsmerkmalen an einem Versorgungsstandort möglich ist, wie am Standort von S<sub>2</sub>, S<sub>3</sub> und S<sub>4</sub> sichtbar wird._

![2sfcaexplainer_step1_2](doc\pic\2sfcaexplainer_step1_2.gif "Abb.: 1. Schritt der 2sfca-Methode - Wiederholung für alle weitern Standorte.")

***********************************************************

{{6-10}}
****
6. Suche für jeden Bevölkerungsstandort der innerhalb des Einzugsgebietesschwellwertes _d<sub>0</sub>_ liegt, alle erreichbaren Versorgungsstandorte und addiere deren unter 4. genannte Verhältnis _R<sub>j</sub>_ der Versorgungsstandortes und der jeweiligen Bevölkerung.

![2sfcaexplainer_step2](doc\pic\2sfcaexplainer_step2.gif "Abb.: 2. Schritt der 2sfca-Methode - Wiederholung für alle weitern Standorte.")
***********************************************************

{{7-10}}
***********************************************************
Nach Toblers (1970) erstem Gesetz der Geographie _hängt alles mit allem Zusammen, aber nähere Sachen hängen stärker voneinander ab, als weiter entfernte_. Noch wird das durch unserer Vorgehen noch nicht berücksichtigt.

Wir implementieren daher noch eine entfernungsabhängige Gewichtungsfunktion, damit das "Enhanced" in _E2SFCA_ seinem Namen gerecht wird.

![2sfcaexplainer_enhanced](doc\pic\2sfcaexplainer_enhanced.gif "Abb.: Text.")

***********************************************************

{{8-10}}
***********************************************************
Die Art und Weise der Abgewichtung sowie die Wahl der Einzugsgebietsgröße sind entscheidend für die Plausibiltät des Ergebnisses. Sie hängen jedoch stark vom Untersuchungsgegenstand und der entsprechenden "Fachfrage" ab.


***********************************************************

{{9-10}}
***********************************************************
Im nächsten Kapitel betrachten wir diese Abfolge noch einmal. Nun aber zur besseren Nachvollziehbarkeit mit dem Praxisbeispiel und Karten die schon aus der Erläuterung des Kapitels zur Einzugsgebieten bek
***********************************************************

{{10-10}}
***********************************************************

***********************************************************

### Praxis am geographischen Beispiel

{{1-2}}
***********************************************************
Sogenannte gravitationsmodelle werden in der räumlichen Planung verwendet, um bestimmte Verhaltensweisen vorherzusagen und zu beschreiben, die sich ähnlich der in den Gravitationsgesetzen von Isaac Newton beschriebenen Gravitationsinteraktion wiederfinden.

Im Allgemeinen enthalten die sozialwissenschaftlichen Modelle einige Elemente von Masse und Entfernung, was ihnen die Metapher der physikalischen Schwerkraft verleiht. Ein Gravitationsmodell liefert eine Schätzung des Volumens der Ströme von z. B. Waren, Dienstleistungen oder Menschen zwischen zwei oder mehreren Orten.
***********************************************************
{{2-4}}
***********************************************************
Die Berücksichtung einer "Anziehungskraft" ist eine wichtige Vorsetzung, um Versorgung besser zu verstehen. Wir konzentrieren uns im folgenden auf die 2SFCA-Methodengruppe (engl. Two-step floating catchment area method). Um uns der Metode zu nähern gehen wir wieder mit plastischen Beispielen Schritt für Schritt vor.
***********************************************************
{{3-4}}
***********************************************************
Luo und Qi entwickelten 2009 die Enhanced Two-Step Floating Catchment Area (E2SFCA)-Methode, um eine Messung zu ermöglichen, die intuitiv sinnvoll ist, um den räumlichen Zugang zu (Gesundheits-)Dienstleistern zu bestimmen. Sie basieren auf den vorausgegangenen Überlegungen von Luo und Wang (2003) und Radke und Mu (2000). Die Methodengruppe ist darüber hinaus eng verbunden mit den von Huff (1964) getroffenen Erkenntnissen zu Einzugsgebieten.
***********************************************************

{{4-5}}
***********************************************************
Die Herleitung der E2SFCA unterehmen wir wie folgt:

1. Suche für jenden Versorgungsstandort (_Suppyer_) _S<sub>1</sub>_...

2. die geographisch verteilten Bevölkerungsstandorte (_Population_) von _P<sub>k</sub>_...

3. die sich durch innerhalb eines Einzugsgebiet mit einer Enfernung (_Distance_) von _d_ bis _d<sub>0</sub>_ befinden.

4. Berechne das Verhältnis (_Ratio_) _R<sub>j</sub>_  zwischen des Versorgungsstandortes und der jeweiligen Bevölkerung innerhalb des Einzugsgebietes.   


![2sfcaexplainer_step1_1](doc\pic\2sfcaexplainer_step1_1.gif "Abb.: 1. Schritt der 2sfca-Methode - Verhältnis von Angebot (P<sub>k</sub>) und Bevölkerung (P<sub>k</sub>) ermitteln.")

***********************************************************


{{5}}
***********************************************************
5. Der erste Teilschritt ist für alle Standorte wiederholbar. _Bemerkung: Berücksichtige, dass durch diese Schritte eine Gewichtung von Kapazitätsmerkmalen an einem Versorgungsstandort möglich ist, wie am Standort von S<sub>2</sub>, S<sub>3</sub> und S<sub>4</sub> sichtbar wird._

![2sfcaexplainer_step1_2](doc\pic\2sfcaexplainer_step1_2.gif "Abb.: 1. Schritt der 2sfca-Methode - Wiederholung für alle weitern Standorte.")
***********************************************************

# Der DVA-Code
## Softwarearchitektur
## Hardwarearchitektur (strukturelle Empfehlung)



# Liascript Beispiele
This is your **course** initialization stub.

Please see the [Docs](https://liascript.github.io/course/?https://raw.githubusercontent.com/liaScript/docs/master/README.md)
to find out what is possible in [LiaScript](https://liascript.github.io).

If you want to use instant help in your Atom IDE, please type **lia** to see all available shortcuts.

##

You can use common [Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet) syntax to create your course, such as:

1. Lists
2. ordered or

   * unordered
   * ones ...


| Header 1   | Header 2   |
| :--------- | :--------- |
| Item 1     | Item 2     |


Images:

![images](https://farm2.static.flickr.com/1618/26701766821_7bea494826.jpg)


### Extensions

     --{{0}}--
But you can also include other features such as spoken text.

      --{{1}}--
Insert any kind of audio file:

       {{1}}
?[audio](https://bigsoundbank.com/UPLOAD/mp3/1068.mp3)


     --{{2}}--
Even videos or change the language completely.

       {{2-3}}
!?[video](https://www.youtube.com/watch?v=bICfKRyKTwE)


      --{{3 Russian Female}}--
Первоначально создан в 2004 году Джоном Грубером (англ. John Gruber) и Аароном
Шварцем. Многие идеи языка были позаимствованы из существующих соглашений по
разметке текста в электронных письмах...


    {{3}}
Type "voice" to see a list of all available languages.


### Styling

<!-- class = "animated rollIn" style = "animation-delay: 2s; color: purple" -->
The whole text-block should appear in purple color and with a wobbling effect.
Which is a **bad** example, please use it with caution ...
~~ only this is red ;-) ~~ <!-- class = "animated infinite bounce" style = "color: red;" -->

## Charts

Use ASCII-Art to draw diagrams:

                                    Multiline
    1.9 |    DOTS
        |                 ***
      y |               *     *
      - | r r r r r r r*r r r r*r r r r r r r
      a |             *         *
      x |            *           *
      i | B B B B B * B B B B B B * B B B B B
      s |         *                 *
        | *  * *                       * *  *
     -1 +------------------------------------
        0              x-axis               1

## Quizzes

### A Textquiz

What did the **fish** say when he hit a **concrete wall**?

    [[dam]]

### Multiple Choice

Just add as many points as you wish:

    [[X]] Only the **X** marks the correct point.
    [[ ]] Empty ones are wrong.
    [[X]] ...

### Single Choice

Just add as many points as you wish:

    [( )] ...
    [(X)] <-- Only the **X** is allowed.
    [( )] ...

## Executable Code

A drawing example, for demonstrating that any JavaScript library can be used, also for drawing.

```javascript
// Initialize a Line chart in the container with the ID chart1
new Chartist.Line('#chart1', {
  labels: [1, 2, 3, 4],
  series: [[100, 120, 180, 200]]
});

// Initialize a Line chart in the container with the ID chart2
new Chartist.Bar('#chart2', {
  labels: [1, 2, 3, 4],
  series: [[5, 2, 8, 3]]
});
```
<script>@input</script>

<div class="ct-chart ct-golden-section" id="chart1"></div>
<div class="ct-chart ct-golden-section" id="chart2"></div>


### Projects

You can make your code executable and define projects:

``` js     -EvalScript.js
let who = data.first_name + " " + data.last_name;

if(data.online) {
  who + " is online"; }
else {
  who + " is NOT online"; }
```
``` json    +Data.json
{
  "first_name" :  "Sammy",
  "last_name"  :  "Shark",
  "online"     :  true
}
```
<script>
  // insert the JSON dataset into the local variable data
  let data = @input(1);

  // eval the script that uses this dataset
  eval(`@input(0)`);
</script>

## More

Find out what you can even do more with quizzes:

https://liascript.github.io/course/?https://raw.githubusercontent.com/liaScript/docs/master/README.md


# Beispiel
