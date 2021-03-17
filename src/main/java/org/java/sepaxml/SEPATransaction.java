package org.java.sepaxml;

import java.math.BigDecimal;
import java.util.Date;

public class SEPATransaction {

	public enum Currency {
		BGN, HRK, CZK, DKK,
		EUR, GIP, HUF, ISK,
		NOK, PLN, RON, SEK,
		CHF, GBP
	}

	public enum Purpose {
		BENE, 	// SEPA Gutschrift Arbeitslosengeld
		BONU, 	// SEPA Gutschrift Bonuszahlung
		CBFF, 	// SEPA Gutschrift VL-Zahlung / VWL-Zahlung
		CHAR, 	// SEPA Gutschrift Spendenzahlung
		GOVT, 	// SEPA Gutschrift öffentliche Kassen
		PENS, 	// SEPA Gutschrift Rente / Pension
		SALA, 	// SEPA Gutschrift Lohn / Gehalt
		SSBE, 	// SEPA Gutschrift Sozialleistung

		CDCB, 	// Kartenzahlung mit CashBack
		CDCD, 	// Cash-Auszahlung
		CDCS, 	// Cash-Auszahlung mit Aufgeld
		CDOC, 	// Original Kredit
		CDQC, 	// Quasi-Geld
		ETUP, 	// Elektronischer Geldbeutel aufbessern
		FCOL, 	// Gebührensammlung
		MTUP, 	// Handy aufladen
		ACCT, 	// Kontoverwaltung
		CASH, 	// Cash-Management Überweisung
		COLL, 	// Sammelzahlung
		CSDB, 	// Cash-Auszahlung
		DEPT, 	// Einzahlung
		INTC, 	// interne Firmenzahlung
		LIMA, 	// Liquiditätsverwaltung
		NETT, 	// Verrechnung
		AGRT, 	// landwirtschaftliche Überweisung
		AREN, 	// Debitoreneingänge
		BEXP, 	// Geschäftsausgaben
		BOCE, 	// Umwandlung eines Eingangs bei einer Abwicklungsstelle
		COMC, 	// Handelszahlung
		CPYR, 	// Urheberrecht/schutz
		GDDS, 	// Einkauf/Verkauf von Waren
		GDSV, 	// Einkauf/Verkauf von Waren und Dienstleistungen
		GSCB, 	// Einkauf/Verkauf von Waren und Dienstleistungen mit CashBack
		LICF, 	// Lizenzgebühr
		POPE, 	// Zahlung am Point of Sale
		ROYA, 	// Patentgebühr
		SCVE, 	// Einkauf/Verkauf von Dienstleistungen
		SUBS, 	// Abonnementgebühr
		SUPP, 	// Lieferantenzahlung
		TRAD, 	// Handelsdienstleistung
		COMT, 	// Konsument für dritte Person konsolidierte Zahlung
		CLPR, 	// Autodarlehen Ablösung
		DBTC, 	// Lastschriftsammelzahlung
		GOVI, 	// Regierungsversicherung
		HLRP, 	// Wohnungsdarlehensrückzahlung
		INPC, 	// Versicherungsbeitrag Auto
		INSU, 	// Versicherungsbeitrag
		INTE, 	// Zinsen
		LBRI, 	// Versicherung Arbeit
		LIFI, 	// Lebensversicherung
		LOAN, 	// Darlehen
		LOAR, 	// Darlehensrückzahlung
		PENO, 	// Zahlung basiert auf einem Vollstreckungsbefehl
		PPTI, 	// Hausratversicherung
		RINP, 	// Wiederholende Ratenzahlungen
		TRFD, 	// Treuhandfond
		ADMG, 	// administrative Verwaltung/Management
		ADVA, 	// ansteigende Zahlung
		BLDM, 	// Gebäudeinstandhaltung
		CCRD, 	// Kreditkartenzahlung
		CDBL, 	// Kreditkartenrechnung
		CFEE, 	// Annullierungskosten
		COST, 	// Kosten
		DCRD, 	// Debit-Kartenzahlung
		FAND, 	// Finanzielle Unterstützung bei dem Eintritt von Naturkatastrophen
		ICCP, 	// Unwiderrufliche Kreditkartenzahlung
		IDCP, 	// Unwiderrufliche Debit-Kartenzahlung
		IHRP, 	// Raten-/Mieteinkauf-Vereinbarung
		INSM, 	// Rate
		MSVC, 	// vielfache Dienstleistungstypen
		NOWS, 	// Nicht anders vorgeschrieben
		OFEE, 	// Eröffnungsgebühr
		OTHR, 	// Andere
		PADD, 	// davor authorisierte Lastschrift
		PTSP, 	// Zahlungsbedingungen
		RCKE, 	// nochmals vorgelegte Scheckzahlung
		RCPT, 	// Erhaltene Zahlung
		REFU, 	// Rückzahlung
		RENT, 	// Miete/Pacht
		STDY, 	// Studiengebühr
		TELI, 	// Telefon-initiierte Transaktion
		WEBI, 	// Internet-initiierte Transaktion
		ANNI, 	// Wiederkehrende Zahlung
		CAFI, 	// Hausmeistergebühr Inhouse
		CFDI, 	// Anlagevermögen fällig innerbetrieblich
		CMDT, 	// Warenüberweisung
		DERI, 	// Derivative
		DIVD, 	// Dividende
		FREX, 	// Devisenkurs
		HEDG, 	// Hedging
		PRME, 	// Edelmetall
		SAVG, 	// Ersparnisse
		SECU, 	// Sicherheiten
		SEPI, 	// Sicherheiten Einkauf intern
		TREA, 	// Finanzamt-Zahlung
		ANTS, 	// Narkosedienstleistungen
		CVCF, 	// Genesungs-/Heilungseinrichtung
		DMEQ, 	// strapazierfähiges Medizinequipment
		DNTS, 	// Zahnarzt
		HLTC, 	// häusliche Krankenpflege/Hauspflege
		HLTI, 	// Krankenversicherung
		HSPC, 	// Krankenhauspflege
		ICRF, 	// Betreuungseinrichtung
		LTCF, 	// Langzeitbetreuungseinrichtung
		MDCS, 	// Sanitätsdienst
		VIEW, 	// Vision Care
		ALMY, 	// Alimentezahlung
		AEMP, 	// aktive Arbeitsmarktpolitik
		BECH, 	// Kindergeld
		COMM, 	// Provision
		CSLP, 	// Sozialkreditzahlung einer Firma an die Bank
		GFRP, 	// Garantie- /Fond- /Rechte-Zahlung
		GVEA, 	// Österreichische Regierungsangestellte Kategorie A
		GVEB, 	// Österreichische Regierungsangestellte Kategorie B
		GVEC, 	// Österreichische Regierungsangestellte Kategorie C
		GVED, 	// Österreichische Regierungsangestellte Kategorie D
		GWLT, 	// Regierungs-Kriegsgesetze Überweisung
		EPAY, 	// paydirekt-Transaktion
		PAYR, 	// Gehaltsliste
		PRCP, 	// Preiszahlung
		RHBS, 	// Rehabilitationsunterstützung
		ESTX, 	// Erbschaftsteuer
		HSTX, 	// Wohnungssteuer
		INTX, 	// Einkommenssteuer
		NITX, 	// Steuer auf Gewinn
		TAXS, 	// Steuerzahlung
		VATX, 	// Umsatzsteuerzahlung
		WHLD, 	// Quellensteuer
		TAXR, 	// Steuerrückzahlung
		AIRB, 	// Luftfracht
		BUSB, 	// BUS
		FERB, 	// Fähre
		RLWY, 	// Eisenbahn
		CBTV, 	// KabelTV-Rechnung
		ELEC, 	// Elektrikrechnung
		ENRG, 	// Energie
		GASB, 	// Gasrechnung
		NWCH, 	// Netzwerkgebühr
		NWCM, 	// Netzwerkkommunikation
		OTLC, 	// Andere Telekom bezogene Rechnungen
		PHON, 	// Telefonrechnung
		WTER  	// Wasserrechnung
	}

	private SEPABankAccount bankAccount;

	private String id;
	private String subject;
	private BigDecimal value;
	private Date date;
	private String endToEndId;

	private String mandatReference;
	private Date mandatReferenceDate;

	private Currency currency = Currency.EUR;
	private Purpose purpose = Purpose.BENE;
	private String remittance;

	public SEPATransaction(
		SEPABankAccount bankAccount,
		BigDecimal value,
		String subject,
		Date date,
		String mandatReference,
		Date mandatReferenceDate,
		Currency currency,
		Purpose purpose,
		String remittance
	) {
		this.bankAccount = bankAccount;
		this.subject = subject;
		this.value = value;
		this.date = date;
		this.mandatReference = mandatReference;
		this.mandatReferenceDate = mandatReferenceDate;
		this.currency = currency;
		this.purpose = purpose;
		this.remittance = remittance;
	}

	public SEPATransaction(
			SEPABankAccount bankAccount,
			BigDecimal value,
			String subject,
			Date date,
			String mandatReference,
			Date mandatReferenceDate
	) {
		this(bankAccount, value, subject, date, mandatReference, mandatReferenceDate, Currency.EUR, Purpose.BENE, null);
	}

	public SEPATransaction(SEPABankAccount bankAccount, BigDecimal value, String subject) {
		this(bankAccount, value, subject, new Date(), null, null, Currency.EUR, Purpose.BENE, null);
	}

	public SEPATransaction(SEPABankAccount bankAccount, BigDecimal value, String subject, Currency currency) {
		this(bankAccount, value, subject, new Date(), null, null, currency, Purpose.BENE, null);
	}

	public SEPATransaction(SEPABankAccount bankAccount, BigDecimal value, String subject, Currency currency, Purpose purpose) {
		this(bankAccount, value, subject, new Date(), null, null, currency, purpose, null);
	}

	public String getId() {
		return id;
	}

	public SEPATransaction setId(String id) {
		this.id = id;
		return this;
	}

	public String getEndToEndId() {
		return endToEndId;
	}

	public SEPATransaction setEndToEndId(String endToEndId) {
		this.endToEndId = endToEndId;
		return this;
	}

	public SEPABankAccount getBankAccount() {
		return bankAccount;
	}

	public BigDecimal getValue() {
		return value;
	}

	public String getSubject() {
		return subject;
	}

	public String getMandatReference() {
		return mandatReference;
	}
	
	public Date getMandatReferenceDate() {
		return mandatReferenceDate;
	}

	public Date getDate() {
		return date;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Purpose getPurpose() { return purpose; }

	public String getRemittance() { return remittance; }
}
