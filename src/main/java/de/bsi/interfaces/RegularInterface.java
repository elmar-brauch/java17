package de.bsi.interfaces;

// INTERFACE
// public: Interface Sichtbarkeit kann public oder package sein - bei package wird public einfach weggelassen.
// abstract: ist vor interface möglich, macht aber keinen Unterschied.
// sealed & permits / non-sealed: Versiegeltes (sealed) Interface legt mit permits fest, welche Klassen es implementieren dürfen und welche Interface es erweitern dürfen. non-sealed bricht die Versiegelung.
// strictfp: ist vor interface möglich und bewirkt, dass arithmetischer Berechnungen streng nach IEEE 754 gerundet werden.
// final: ist vor interface nicht möglich, da es dann nicht implementiert werden könnte, was dem Zweck eines Interface widersprechen würde.
// implements: ist nicht möglich, weil Interfaces nie eine Implementierung sein können.
// extends: Interface können mit extends eine Vererbungshierachie bilden. Bei Interfaces ist sogar Mehrfachvererbung möglich.

// KONSTANTEN, VARIABLEN
// Interfaces erlauben nur Attribute mit public, static und final Modifikatoren, also Konstanten und sonst nichts.
// public, static und final kann man bei Attributen auch weglassen, diese Modifikatoren werden dann implizit gesetzt.
// private und protected sind bei Interface "Attributen" nicht möglich.
// Es gibt in Interface keine nicht statischen oder nicht finalen Attribute.

// INTERFACE-METHODEN
// abstract: wird bei jeder Methoden-Deklaration im Interface implizit vom Compiler hinzugefügt, ob man es explizit setzt oder nicht. Es sei denn die Methode ist default oder statisch.
// public: Alle im Interface deklarierten, abstract Methoden sind public. protected und private sind dann nicht möglich.
// default: Default Methoden können von Interface Implementierungen überschrieben oder übernommen werden, sie können nicht statisch und sind immer public, ob public explizit gesetzt ist oder nicht. Default Methoden haben einen Body bzw. eine Implementierung direkt im Interface. 
// static: Statische Methoden sind möglich im Interface, sie benötigen einen Body und akzeptieren nur public und private als Sichtbarkeits-Modifikator:
// - private static: Statische Methoden sind nur im Interface sichtbar und können von default oder anderen privaten Methoden verwendet werden.
// - public static: Statische Methoden, die überall sichtbar sind.
// private: nur im Interface sichtbar und nicht statische Methode, kann von default Methoden oder anderen private-sichtbaren, nicht statischen Methoden verwendet werden.

// MEHRFACHVERERBUNG
// Mehrdeutige Konstanten im Fall von Mehrfachvererbung müssen eindeutig referenziert werden (Interface.Konstante).
// Mehrfach deklarierte, abstrakte Methoden mit gleicher Signatur werden einfach einmal implementiert in der konkreten Klasse.
// Static Methoden werden in Interfaces nicht vererbt, daher gibt es auch keine Mehrfachvererbung. Man muss static Methoden in Interfaces über den Interfacenamen referenzieren.
// Doppelt definierte default Methoden mit gleicher Signatur werden vom Compiler im Fall von Mehrfachvererbung abgelehnt.
// Haben default und abstrakte Methoden im Mehrfachvererbungs-Szenario die gleiche Signatur, so muss das mehrfach erbende Interface diese Situation auflösen und die Methode überschreiben.

// ÜBERLADEN & ÜBERSCHREIBEN
// Konstanten werden nicht überschrieben sondern nur versteckt, da sie static sind.
// Statische Methoden sind nicht betroffen, da sie von Interfaces nicht geerbt werden.
// Default Methoden werden überschrieben, wenn Rückgabewert, Methodennamen und Parametertyp und -reihenfolge übereinstimmen.
// Abstrakte und Default Methoden mit dem gleichen Methodennamen werden überladen, wenn sich mindestens ein Parametertyp oder die Anzahl der Parameter unterscheidet.

// public class und public interface sind innerhalb eines Interfaces möglich, aber vermutlich keine gute Idee.

public non-sealed interface RegularInterface extends FirstSuperInterface, SecondSuperInterface {
	
	String CONSTANT_A = "hides constant";
	
	static String addInfo(String input) {
		return input + staticInfo();
	}
	
	private static String staticInfo() {
		return "private static method can be called by any method inside this interface";
	}
	
}

