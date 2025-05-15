Carvision - Fahrzeugklassifikationsanwendung
Carvision ist eine moderne Anwendung, die mithilfe von maschinellem Lernen Fahrzeugtypen anhand hochgeladener Bilder klassifiziert. Die Anwendung bietet eine benutzerfreundliche Weboberfläche, mit der Benutzer Bilder hochladen und detaillierte Klassifikationsergebnisse erhalten können. Sie ist vollständig containerisiert und kann einfach mit Docker bereitgestellt werden.

Funktionen
🚗 Fahrzeugklassifikation: Laden Sie ein Bild hoch, und die Anwendung klassifiziert den Fahrzeugtyp (z. B. SUV, Limousine, LKW).
📜 Klassifikationshistorie: Sehen Sie sich eine Historie der zuvor klassifizierten Bilder und deren Ergebnisse an.
🏷️ Verfügbare Labels: Zeigt alle unterstützten Fahrzeugkategorien an.
🧠 Modellinformationen: Bietet Details zu den verwendeten maschinellen Lernmodellen.
🌐 Weboberfläche: Eine moderne und responsive Benutzeroberfläche für einfache Interaktionen.
🐳 Dockerisierte Bereitstellung: Einfach mit Docker bereitstellbar, um konsistente Umgebungen zu gewährleisten.
Verwendete Technologien
Backend: Java, Spring Boot
Frontend: HTML, CSS (Bootstrap), JavaScript
Maschinelles Lernen: Vorgefertigte Deep-Learning-Modelle
Containerisierung: Docker
Build-Tool: Maven
Projektstruktur
Voraussetzungen
Java: JDK 21 oder höher
Maven: Installiert oder Maven Wrapper (mvnw) verwenden
Docker: Installiert und ausgeführt
Installation und Ausführung
1. Repository klonen
Klonen Sie das Repository auf Ihren lokalen Rechner:

2. Anwendung bauen
Mit Maven
Mit Docker
3. Anwendung starten
Mit Java
Mit Docker
4. Anwendung aufrufen
Öffnen Sie Ihren Browser und navigieren Sie zu:

Verwendung
1. Bild hochladen
Klicken Sie auf die Schaltfläche "📷 Bild hochladen".
Wählen Sie ein Bild eines Fahrzeugs von Ihrem lokalen Rechner aus.
2. Fahrzeug klassifizieren
Klicken Sie auf die Schaltfläche "🔍 Klassifizieren".
Die Anwendung verarbeitet das Bild und zeigt die Klassifikationsergebnisse an.
3. Klassifikationshistorie anzeigen
Scrollen Sie nach unten zum Abschnitt "📜 Klassifikationshistorie", um zuvor klassifizierte Bilder und deren Ergebnisse anzuzeigen.
4. Verfügbare Labels und Modelle erkunden
Überprüfen Sie den Abschnitt "🏷️ Verfügbare Labels" für unterstützte Fahrzeugkategorien.
Sehen Sie sich den Abschnitt "🧠 Verfügbare Modelle" für Details zu den maschinellen Lernmodellen an.
Verfügbare Fahrzeugkategorien
🚛 Großer LKW
🚗 Stadtauto
🚐 Mehrzweckfahrzeug
🚘 Limousine
🚙 SUV
🚚 LKW
🚐 Van
Entwicklung
Ordnerstruktur
src/main/java: Enthält die Backend-Logik, geschrieben in Java.
src/main/resources/static: Enthält die Frontend-Dateien (index.html, script.js).
Beitrag leisten
Beiträge sind willkommen! Wenn Sie beitragen möchten, forken Sie das Repository und senden Sie einen Pull-Request.

Lizenz
Dieses Projekt ist unter der MIT-Lizenz lizenziert. Weitere Informationen finden Sie in der Datei LICENSE.

Falls Sie weitere Fragen haben, lassen Sie es mich wissen! 😊