<!--
author:   Falko Krügel

email:    faklo.kruegel@tu-dresden.de

version:  0.0.2

language: de

icon:     https://upload.wikimedia.org/wikipedia/commons/f/f9/Logo_TU_Dresden.svg

link:     style.css

@onload
  LIA.settings.sound = false;
  LIA.settings.mode = "Slides";
@end

-->
<<<<<<< HEAD
Die Inhalte sind als aufbereitet als Foliensatz auch hier erhältlich: [DVA Foliensatz]
=======
Die Inhalte sind aufbereitet als Foliensatz auch hier erhätlich: [DVA Foliensatz]
>>>>>>> 52157db51c00166927aa70d2d54f043f7c7603e3

[DVA Foliensatz]: https://liascript.github.io/course/?https://raw.githubusercontent.com/GeoinformationSystems/dva/main/Readme.md


# Der Digitale Versorgungsatlas (DVA)

<h4>Was ist der DVA?</h4>



                          {{0-4}}
***********************************************************

Der _Digitale Versorgungsatlas_, kurz _DVA_, ist eine **Webanwendung** zur Einsicht von Versorgungsinfrastrukturen der Daseinsvorsorge im Bundesgebiet und zur Modellierung, Analyse und Bewertung von Versorgungssituationen.

***********************************************************

                          {{1-4}}
***********************************************************


Der _DVA_ ist aber auch ein **Methodenservice**, mit dessen Hilfe durch eine ArcGIS Toolbox individuelle gravitationsbasierte Versorgungsanalysen, Erreichbarkeitsmatritzen und Isochronen im dt. Bundesgebiet berechnet werden können.

***********************************************************

                          {{2-4}}
***********************************************************

<h4>Der DVA und diese Dokumentation ist eine Zusammenarbeit von:</h4>

Dr. Stephan Mäs - Professur für Geoinformatik

M. Sc. Falko Krügel - Professur für Geoinformatik

B. Sc. Erik Buthmann - Professur für Geoinformatik

B. Sc. Paul Hindorf - Professur für Geoinformatik

TU Dresden

_Stand der Dokumentation: 15.04.2024_



---
***********************************************************

                          {{3-4}}
***********************************************************

Wenn du ein _Anwender_ bist, sind für dich folgende Punkte interessant:

<h4>1.  Die DVA-Webanwendung</h4> (#2)


- Themen (Karteninhalte der Anwendung)

- Räumliche Analysen

  - Entscheidungsunterstützung

  - Räumlicher Zugang

<h4>2.  Die DVA-ArcGIS-Toolbox</h4>

- Enhanced 2SFCA

- Isochrones

- KNearest

- Matrix


Wenn du _Entwickler_ bist, sind für dich folgende Punkte interessant:

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

Zusammen mit [ArcGIS Pro](https://www.esri.com/en-us/arcgis/products/arcgis-pro/overview) (_getestet mit Version 3.2.2_) erlaubt die ArcGIS-Toolbox den Zugriff auf Dienste und Methoden, die bei der Umsetzung von Versorgungsanalysen verschiedenster Art unterstützen.

## Download und Einbindung

<br>

**Download:** Die Toolbox kann durch den [SharePoint](https://datashare.tu-dresden.de/s/GArikyxRo3dr3L5) der TU-Dresden heruntergeladen werden.

**Einbindung:** Für die Einbindung der ArcGIS-Toolbox in ArcGIS hilft diese offizielle [Anleitung](https://pro.arcgis.com/de/pro-app/latest/help/projects/connect-to-a-toolbox.htm).


## Enhanced2SFCA

Sicht auf die Toolbox mit einem möglichen Ergebnis für ein Einzugsgebiet:

![Beispielhafte Nutzung des Tools](doc\pic\ToolboxE2SFCA.png "Abb.: Beispielhafte Nutzung des Tools") <!--- style "with:200px" --->




### Allgemeines zur Nutzung

<!-- Infobox style="background-color: #EEE; padding:1rem"-->
   ℹ️ <br>
   Dieses Kapitel stellt keine methodischen Grundlagen vor. Für methodische Grundlagen bitte Kapitel **Die Methoden zur Versorgungsanalyse** zur Hilfe nehmen.

Wesentlich für die Qualität des Analyseergebnisses sind die Eingangsdaten. Je nach technischer Ausrichtung können diese im Bereich der Versorgungsanalysen sehr unterschiedlich sein.

Für die Berechnung der Enhanced2SFCA sollten folgende Eingabedaten in folgender Struktur vorliegen:

- **Nachfragestandorte oder -flächen**

  - möglichst klein räumlich als Punkt- oder Shapefeatureclass (z.B. Punktfeatureclass mit Werteverteilungen, Gemeindekonturen mit Kaufkraftpotenzial, 100x100m Zensusgrid mit Bevölkerungsdaten)

  - Erforderlich ist das Hinterlegen eines Nachfragepotentials (z. B. Einwohneranzahl, Kaufkraft, Morbidität) in der Attributtabelle

<br>

- **Angebotsstandorte /Dienstleister**

  - Punktfeatureclass

  - Erforderlich ist das Hinterlegen einer Auslastungs-, Verfügbarkeits-  oder Kapazitätskennzahl (z. B. Anzahl tätiger Ärzte am Standort, Verkaufsfläche)
<br>


 <!-- Warningbox style="background-color: rgba(255, 99, 71, 0.5); padding:1rem"-->
❕ <br>
 **Berechnungshinweis:** <br>
 Es können maximal **10.000.000 Routen** gleichzeitig gerechnet werden.<br>
 <br>
 Bei einer größeren Anzahl an Routen erhalten Sie eine Fehlermeldung.<br>
 Ermitteln Sie Ihre Routenzahl wie folgt: <br>
  Anzahl Nachfragefeatures * Anzahl Angebotsfeatures --> <br>
  Das Ergebnis sollte < = 10.000.000 sein

### Grundlegende Parameter

<h4>URL</h4>

Zugriff auf den Methodenserver, der die Berechnung der räumlichen Zugänglichkeit übernimmt. Die URL ist über falko.kruegel@tu-dresden.de einzuholen.

<br>

<h4>Demand</h4>
Punkt- oder Shapefeatureclass welches die Nachfragepotenziale enthält. Bitte berücksichtigen: Eine große Fläche und viele Angebots- und Nachfragestandorte bedingen die Berechnung vieler/großer Einzugsgebiete, was die Berechnungszeit beeinflusst. Mehr als 1. Mio Routenabfragen können aktuell nicht zur gleichen Zeit berechnet werden.

<br>

<h4>Demand Weight</h4>

Gewichtungsparameter zur Modellierung des Nachfrageverhaltens. Idealerweise als Short/Long/Float/Double hinterlegen.

Erfolgt keine Angabe des Nachfragegewichtes, so wird jedes Feature hinsichtlich seiner Nachfrage als gleichwertig angesehen.

<br>

<h4>Supply</h4>

Punkt- oder Shapefeatureclass das ein Angebotspotenzial enthält.
Angebots- und Nachfragestandorte bedingen die Berechnung vieler/großer Einzugsgebiete was die Berechnungszeit beeinflusst. Mehr als 10.000.000 Routenabfragen können aktuell nicht zur gleichen Zeit berechnet werden.

<br>

<h4>Supply Weight</h4>

Gewichtungsparameter zur Modellierung des Angebotspotenzials. Idealerweise als Short/Long/Float/Double hinterlegen.


Erfolgt keine Angabe des Nachfragegewichtes, so wird jedes Feature hinsichtlich seiner Angebotskapazität als gleichwertig angesehen.

<br>

<h4>Distance Decay</h4>

Mit den Abgewichtungstypen wird die Bedeutung der Entfernung zwischen Angebots- und Nachfragestandort definiert.

<br>

Beispiel 1: Bei einer binären Modellierung wird bis zu einem individuell festgelegten Entfernungsschwellenwert davon ausgegangen, dass die Versorgungsleistung des Anbieters innerhalb des Schwellenwertes gleichgeartet ist.

Beispiel 2: Bei einer hybriden Modellierung werden mehrere (beliebig viele) Entfernungsschwellenwerte und ihre Bedeutung zur Versorgung definiert.

<br>

Folgende Wahlmöglichkeiten bestehen:

* **binary** - Binäre Abgewichtung $f(d_{ij}) = 1$
* **linear** - Liniare Abgewichtung $f(d_{ij}) = 1 - \frac{d_{ij}}{d_{max}}$ von 1 bis 0, der maximalen Entfernung
* **exponential** - Exponentielle Abgewichtung $f(d_{ij}) = e^{-d_{ij} \delta}$ mit Impedanzfaktor $\delta = -\frac{log(0.01)}{d_{max}}$
* **gaussian** - Abgewichtung entsprechend der gaussischen Normalverteilung $f(d_{ij}) = e^{\frac{-d_{ij}^2}{\delta}}$ mit Impedanzfaktor $\delta = -\frac{d_{max}^2}{log(0.01)}$
* **inverse-power** - Inverse Distanzabgewichtung $f(d_{ij}) = d_{ij}^{-\delta}$ mit Impedanzfaktor $\delta = log_{d_{max}}(100)$
* **kernel-density** - density weighting $f(d_{ij}) = 0.75 * (1 - (\frac{d_{ij}}{d_{max}})^2)$
* **hybrid** - Individuelle Abgewichtungsfunktion $f(d_{max, n-1} < d_{ij} < d_{max, n}) = w_n$ mit eigens gewählten Entfernungsschwellwerten $d_{max, n}$ und den für jeden Schwellwert festgelegten Gewicht $w_n$

  * Mit dieser Wahl werden Eingabefaktoren für _Ranges_ und _Range-Faktors_ geöffnet. In _Ranges_  werden die individuellen Entfernungsschwellwerte hinterlegt. Entsprechend der Reihenfolge kann unter _Range-Faktors_ die individuell festgelegte Entfernungsabgewichtung hinterlegt werden.

* **polynom** - Gewichtung nach einer polynomischen Formel $f(d_{ij}) = a_0 d_{ij}^{n} + a_1 d_{ij}^{n-1} + ... + a_n$ mit individuellen Koeffizienten $a_0, a_1, ..., a_n$ des Entfernungsfaktors

  * Mit dieser Wahl werden Eingabefaktoren für _Polynom Coefficients_ geöffnet. Mit der polynomischen Abgewichtung kann eine eigene Abgewichtungsfunktion definiert werden.


<br>

<!-- Infobox style="background-color: #EEE; padding:1rem"-->
   ℹ️ <br>
   Bitte beachten: Viele der Eingaben erfordern die Eingabe von **Entfernungsparametern** (Travelmode). Die Entfernung kann per **Zeit** (in Sekunden) oder **Entfernung** (in Metern) hinterlegt werden. Dokumentation im nächsten Kapitel **Erweiterte Parameter**


<br>

### Erweiterte Parameter
Weitere Einstellung für genauere Festsetzung des Routings.

<br>

<h4>Profile</h4>
Reiseprofile, über die das Routing erfolgt

<br>

<h4>Travelmode</h4>
Angabe, ob die Distanzmessung per Zeit- oder Entfernungseinheiten erfolgen sollte:

*	time: Angabe erfolgt in Sekunden
*	distance: Angabe erfolgt in Metern

<br>

<h4>Locationtype</h4>
Sollen die Routenpfade von Startpunkt zum Zielpunkt (start) oder vom Zielpunkt zum Startpunkt (destination) erfolgen?

Hinweis: Im Einzelfall, kann dies entscheidend sein, wenn z. B. Einbahnstraßen oder Straßen mit verschiedenen Geschwindigkeitsbegrenzungen je Fahrtrichtung gelten. Zumeist wirken sich solche Einstellungen auf die Straßennavigation im Individualverkehr aus, jedoch weniger bei der Modellierung einer großen Menge an Routen wie in diesen Versorgungsmodellierungen.

<br>

<h4>Avoid Features</h4>
Gibt es Straßenverbindungen, die nicht beim Routing berücksichtigt werden sollen?

*	highways: Autobahnen werden vermieden
*	tollways: Kostenpflichtige Straßen werden vermieden
*	ferries: Fähren werden vermieden

<br>

<h4>Avoid Polygons</h4>
Angabe eines Polygons, in dem ein Routing nicht erfolgen sollte.

<br>

<h4>Vehicle Type</h4>
Die Routingergebnisse hängen von dem Medium ab, mit dem gereist wird. So sind etwa LKW's (HGV)  bei der Routenwahl limitiert.
Bei fehlender Angabe wird immer "driving_car" genutzt.

<br>


### Fehlermeldungen beheben

<h4>url does not match valid format</h4>

<!-- Infobox style="background-color: #EEE; padding:1rem"-->
   ℹ️   <br>
   url does not match valid format. Has the address been entered correctly? Use the help for more information (https://liascript.github.io/course/?https://raw.githubusercontent.com/GeoinformationSystems/dva/main/Readme.md#7

Die im Toolbox-Parameter **URL** hinterlegte Adresse ist nicht korrekt.

**Es gibt zwei Lösungsmöglichkeiten:**

  1. Der Methodenservice der TU Dresden steht über eine URL-Freigabe zur Verfügung. Ist keine Freigabe vorhanden, wende dich bitte an falko.kruegel@tu-dresden.de
  2. Der OpenAcessibilityService und der OpenrouteService werden lokal auf der eigenen Maschine betrieben und der URL-Parameter beginnt wird über Localhost (Bsp: http://localhost:8082) betrieben. Der Service zur Berechnung der Enhanded2SFCA-Methoden wird also selbst gehostet und betrieben. Informationen zum Betrieb sind im Kapitel unter **DVA-Code** zu entnehmen.
<br>

<h4>Failed to write results to output</h4>

  <!-- Infobox style="background-color: #EEE; padding:1rem"-->
     ℹ️   <br>
     Failed to write results to output. Make sure demand-feature are writeable. ArcGIS often use schema-locking for Tabels, may that is the case.

Fehlermeldung kann verursacht werden, wenn …

-  in der aktuellen ArcGIS-Session Features, die Teil der Berechnung sind, editiert wurden. Oft wird die Tabelle durch ArcGIS gesperrt und die Schemasperre wird durch ArcGIS nicht freigegeben.
- einer Schemasperre aus sonstigen Gründen eingeführt wird.

**Lösung:**

Speicher das ArcGIS-Projekt, beende ArcGIS und lade das Projekt erneut. Die hinterlegten Parameter der Toolbox können im Berechnungsverlauf von ArcGIS erneut geladen werden.

<br>

<h4>Failed to compute travel-time-matrix:Error at location </h4>

  <!-- Infobox style="background-color: #EEE; padding:1rem"-->
     ℹ️   <br>
     Failed to compute travel-time-matrix: Error at location {*Coordinates*}: Unable to build an isochrone map.', 'path': '/v1/accessibility/enhanced_2sfca'}

Fehlermeldung wird verursacht, wenn Standorte von einer öffentlichen Straße so weit entfernt sind, dass diese nicht mehr eindeutig und automatisch einer Straße zugeordnet werden können.

**Lösung:**
Die Features an der entsprechenden Koordinate müssen manuell verschoben werden. Hierzu  *Bearbeiten* --> *Ändern*--> Featureclass auswählen und entsprechenden Punkt auf der Karte verschieben --> *Speichern*. Ggf. muss anschließend das ArcGIS-Projekt neu geladen werden, weil durch ArcGIS Schemasperren gesetzt wurden.




## Isochrones
Bereitstellung bei Produktivgang
## KNearest
Bereitstellung bei Produktivgang
## Matrix
Bereitstellung bei Produktivgang

# Die Methoden zur Versorgungsanalyse
## Einzugsgebiete und Erreichbarkeiten
### Einleitung

<h4>Reicht die Ermittlung von Reisezeit oder Einzugsgebieten für Versorgungsanalysen denn nicht mehr aus?</h4>

                          {{1-2}}
***********************************************************
Leider nein!

Wir benötigen mehr, als die einfachen Reisezeiten von einem Angebotsort zu einem Nachfrageort oder die Feststellung der Größe eines Einzugsgebietes liefern würden.

Diese Art der Analysen sagen uns zwar, **ob** ein Anbieter _theoretisch_ zu erreichen ist, sie sagen aber nicht, ob er _praktisch_ für alle Nachfrager zugänglich ist. In Englischen wird dies unter dem Begriff "*accessibility*" geführt, worauf wir später eingehen.


 <h4> Um die knappe Antwort '*Leider nein*' zu verstehen, schauen wir uns ein plastisches Beispiel im nächsten Kapitel *Grenzen von Einzugsgebietsanalysen* an. </h4>

***********************************************************
### Grenzen von Einzugsgebietsanalysen

<h4>Grenzen von Einzugsgebietsanalysen:</h4>


                          {{1-9}}
***********************************************************
Sehr allgemein formuliert: Bei einem Einzugsgebiet handelt es sich um einen geographischen Raum, der sich um einen definierten Einflussbereich eines bestimmten Objektes ausbreitet.

Um jedoch eine etwas schärfere Definition zu geben, die für die Beantwortung anthropogeografischer Fragestellungen, etwa aus der Versorgungsforschung, geeignet ist, werden wir diese Definition konkretisieren:

<br>

***********************************************************

                          {{2-9}}
***********************************************************

Ein **Einzugsgebiet**, umschließt einen geographischen Raum um einen Dienstleistungsort, welches den Einflussbereich der Dienstleitung definiert. Die Beschreibung des umschlossenen Raumes erfolgt mit Entfernungs- oder Zeiteinheiten und wird über Luftlinie (*radiales Einzugsgebiet*) oder auch über ein Konstrukt aus Wegebeziehungen, z.B. *Straßennetzwerk* gebildet.

<Br>

***********************************************************

                        {{3-9}}
***********************************************************
Die **Einzugsgebietsanalyse** ermöglicht es, die Eigenschaften eines oder mehrerer Einzugsgebiete mittels geographischer Analysemethoden zu beschreiben. Es ist unter anderem möglich, die Größe (*Fläche, Ausdehnungseigenschaften, Topologie*) des Einzugsgebietes zu identifizieren oder die darin enthaltenen Elemente (*Potenziale*) zu ermitteln.

![Beispielhaftes Einzugsgebiet](doc/pic/chatchment_explainer.jpg "Abb.: Um einen Dienstleistungsort gebildetes radiales Einzugsgebiet (rote Linie) und netzwerkabhängiges Einzugsgebiet (blaue Fläche).") <!--- style "with:200px" --->

<Br>

***********************************************************


                          {{4-9}}
***********************************************************
Bauen wir nun unser Beispiel Stück für Stück auf.
Betrachten wir hierzu die Nachfrage einer Dienstleistung in einem zufällig gewählten Raumausschnitt, die durch das fiktive Angebot einer Dienstleistung versorgt werden sollten.


***********************************************************

                          {{5-9}}
***********************************************************

Gehen wir in unserem Beispiel ferner von folgendem aus:

<span style="color: #335A17;font-weight: bold;"> Angebot:</span>.

Das Angebot einer Dienstleistung wird durch eine hausärztliche Einzelpraxis repräsentiert, deren Fachpersonal ca. 2.000 Einwohner versorgen kann (und da nicht alle Einwohner jedes Quartal zum Arzt gehen, handelt es sich um etwa 1.600 zu behandelnde Personen in einem Quartal).

<span style="color: #B2B2B2;font-weight: bold;"> Nachfrage:</span>

Ein 100x100m Raster repräsentiert die Nachfragestandorte. Die Höhe der Nachfrage nach einem ärztlichen Angebot wird durch die Bevölkerungszahl am Wohnort anhand der innen stehenden Zahl repräsentiert.

![Beispielhaftes Untersuchungsgebiet](doc/pic/suppyer_demander.jpg "Abb.: Angebotsstandort (Grüner Punkt) in einer Wohngebietslage in Hannover mit Wohnortsbevölkerung als Nachfragestandorte (graues Raster)") <!--- style "with:100px" --->

***********************************************************

                          {{6-9}}
***********************************************************

Beginnen wir indessen mit einer einfachen Einzugsgebietsanalyse.
Finden wir heraus, wie viele Einwohner (Nachfragepotential) mit einer PKW-Fahrzeit von 2 Minuten den Standort erreichen.

<span style="color: red;font-weight: bold;"> 2-Min Einzugsgebiet:</span>

Welche Nachfragestandorte (Bevölkerung) nach einer Dienstleistung (hausärztliches Angebot) erreichen binnen <span style="color: red;font-weight: bold;">zwei Minuten PKW-Fahrzeit</span> den Dienstleistungsort (hausärztliche Praxis)?

<span style="color: #08306B;font-weight: bold;"> Nachfragepotential:</span>

Wie groß ist das Nachfragepotential für diesen Standort?

![Beispielhaftes Einzugsgebiet](doc/pic/catchment120_supplyer.jpg "Abb.: 2 Min-PKW-Einzugsgebiet um den Angebotsstandort (Grüner Punkt)") <!--- style "with:200px" --->


***********************************************************

                          {{7-9}}
***********************************************************

 <h4> Welche Antworten gibt uns nun also unsere geographische Einzugsgebietsanalyse? </h4>

1. Die räumliche Ausdehnung des Einzugsgebietes und die enthaltenen Nachfragestandorte
2. Die Menge der Bevölkerung, die binnen zwei Minuten PKW-Fahrzeit einen Arzt erreichen.

Wenn wir nun die Bevölkerung im Einzugsgebiet aufsummieren, kommen wir zu einer recht erstaunlichen Menge von 23.211 Einwohnern, die für die Einzelpraxis potenziell zu behandelnde Personen sein können.

Folgende Aussage können wir treffen:

**Binnen 2 Minuten per PKW-Fahrzeit erreichen mehr als 23.000 Einwohner eine Arztpraxis.**

<Br>

***********************************************************

                      {{8-9}}
***********************************************************
Und damit sind wir bei den Grenzen!

Nur weil wir das Versorgungsgebiet einer Infrastruktur und das darin enthaltene Nachfragepotenzial kennen, ist die Situation oder Qualität der Versorgung der Einwohner noch lange nicht bekannt. Da bekannt ist, das die hausärztliche Praxis nur ca. 2.000 Einwohner versorgt, können wir noch keine Aussagen über die Versorgungssituation aller 23.000 Einwohner treffen.

<h4> Grenzen von Einzugsgebietsanalysen:</h4>
Diese geographischen Analysen beantworten die Fragen, ob eine Dienstleitung **erreichbar** ist. Ein Verständnis, ob eine Dienstleitung für die Nachfragenden überhaupt verfügbar ist, lässt damit nicht gewinnen (Frage nach einer Dimension der Zugänglichkeit im Zuge von Auslastung).

Widmen wir uns daher im nächsten Kapitel den gravitationsbasierten Analysemethoden

<Br>


***********************************************************

## gravitationsbasierte Analysemethoden I
### Theorie und graphisches Beispiel

{{1-10}}
***********************************************************
Sogenannte Gravitationsmodelle werden in der Raumplanung verwendet, um bestimmte Verhaltensweisen vorherzusagen und zu beschreiben, die der in den Gravitationsgesetzen von Isaac Newton beschriebenen Gravitationswechselwirkung ähneln.

Im Allgemeinen enthalten die sozialwissenschaftlichen Modelle einige Elemente von Masse und Entfernung, was ihnen die Metapher der physikalischen Schwerkraft verleiht. Ein Gravitationsmodell liefert eine Schätzung des Volumens der Ströme von z. B. Waren, Dienstleistungen oder Menschen zwischen zwei oder mehreren Orten.
***********************************************************

{{2-10}}
***********************************************************
Die Berücksichtigung einer "Anziehungskraft" ist eine wichtige Vorsetzung, um Versorgung besser zu verstehen. Wir konzentrieren uns im folgenden auf die 2SFCA-Methodengruppe (engl. Two-step floating catchment area method). Um uns der Methode zu nähern, gehen wir wieder mit plastischen Beispielen Schritt für Schritt vor.
***********************************************************

{{3-10}}
***********************************************************
 Luo und Qi entwickelten 2009 die Enhanced Two-Step Floating Catchment Area (E2SFCA)-Methode, um eine Messung zu ermöglichen, die intuitiv sinnvoll ist, um den räumlichen Zugang zu (Gesundheits-)Dienstleistern zu bestimmen. Sie basieren auf den vorausgegangenen Überlegungen von Luo und Wang (2003) und Radke und Mu (2000). Die Methodengruppe ist darüber hinaus eng verbunden mit den von Huff (1964) getroffenen Erkenntnissen zu Einzugsgebieten.
***********************************************************

{{4-10}}
***********************************************************
Die Herleitung der E2SFCA unternehmen wir wie folgt:

1. Suche für jeden Versorgungsstandort (_Supplyer_) _S<sub>1</sub>_ …

2. die geographisch verteilten Bevölkerungsstandorte (_Population_) von _P<sub>k</sub>_ …

3. die sich durch innerhalb eines Einzugsgebiet mit einer Entfernung (_Distance_) von _d_ bis _d<sub>0</sub>_ befinden.

4. Berechne das Verhältnis (_Ratio_) _R<sub>j</sub>_ zwischen des Versorgungsstandortes und der jeweiligen Bevölkerung innerhalb des Einzugsgebietes.   


![2sfcaexplainer_step1_1](doc\pic\2sfcaexplainer_step1_1.gif "Abb.: 1. Schritt der 2sfca-Methode - Verhältnis von Angebot (P<sub>k</sub>) und Bevölkerung (P<sub>k</sub>) ermitteln.") <!--- style "with:200px" --->

***********************************************************

{{5-10}}
***********************************************************

5. Der erste Teilschritt ist für alle Standorte wiederholbar. _Bemerkung: Berücksichtige, dass durch diese Schritte eine Gewichtung von Kapazitätsmerkmalen an einem Versorgungsstandort möglich ist, wie am Standort von S<sub>2</sub>, S<sub>3</sub> und S<sub>4</sub> sichtbar wird.

![2sfcaexplainer_step1_2](doc\pic\2sfcaexplainer_step1_2.gif "Abb.: 1. Schritt der 2sfca-Methode - Wiederholung für alle weitern Standorte.") <!--- style "with:200px" --->

***********************************************************

{{6-10}}
****
6. Suche für jeden Bevölkerungsstandort, der innerhalb des Einzugsgebietesschwellenwertes _d<sub>0</sub>_ liegt, alle erreichbaren Versorgungsstandorte und addiere deren unter 4. genannte Verhältnis _R<sub>j</sub>_ des Versorgungsstandortes und der jeweiligen Bevölkerung.

![2sfcaexplainer_step2](doc\pic\2sfcaexplainer_step2.gif "Abb.: 2. Schritt der 2sfca-Methode - Wiederholung für alle weiteren Standorte.") <!--- style "with:200px" --->
***********************************************************

{{7-10}}
***********************************************************
Nach Toblers (1970) erstem Gesetz der Geographie _hängt alles mit allem zusammen, aber nähere Sachen hängen stärker voneinander ab, als weiter entfernte_. Noch wird das durch unser Vorgehen keine Berücksichtigung.

Wir implementieren daher noch eine entfernungsabhängige Gewichtungsfunktion, damit das "Enhanced" in _E2SFCA_ seinem Namen gerecht wird.

![2sfcaexplainer_enhanced](doc\pic\2sfcaexplainer_enhanced.gif "Abb.: Darstellung verschiedener Entfernungsabgewichtung die eine Abnahme der Versorgungsleistung von S über die Entfernung d verdeutlichen.") <!--- style "with:200px" --->

***********************************************************

{{8-10}}
***********************************************************
Die Art und Weise der Abgewichtung sowie die Wahl der Einzugsgebietsgröße sind entscheidend für die Plausibilität des Ergebnisses. Sie hängen jedoch stark vom Untersuchungsgegenstand und der entsprechenden "Fachfrage" ab.


***********************************************************

{{9-10}}
***********************************************************
Im nächsten Kapitel betrachten wir diese Abfolge noch einmal. Nun aber zur besseren Nachvollziehbarkeit mit dem Praxisbeispiel und Karten, die schon aus der Erläuterung des Kapitels zu Einzugsgebieten bekannt sind.
***********************************************************

{{10-10}}
***********************************************************

***********************************************************

### Praxis am geographischen Beispiel

{{1-2}}
***********************************************************
Ergänzung folgt
***********************************************************
{{2-4}}
***********************************************************
Ergänzung folgt
***********************************************************
{{3-4}}
***********************************************************
Ergänzung folgt
***********************************************************

{{4-5}}
***********************************************************
Ergänzung folgt

***********************************************************


{{5}}
***********************************************************
Ergänzung folgt
***********************************************************

# Der DVA-Code
Bereitstellung bei Produktivgang
## Softwarearchitektur
Bereitstellung bei Produktivgang
## Hardwarearchitektur (strukturelle Empfehlung)
Bereitstellung bei Produktivgang
