package com.bigpugloans.events;

import com.bigpugloans.events.antrag.Antrag;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AntragEingereicht implements Serializable {
    private String antragsnummer;
    private Date timestamp;
    private Antrag antrag;

    public String getAntragsnummer() {
        return antragsnummer;
    }

    public void setAntragsnummer(String antragsnummer) {
        this.antragsnummer = antragsnummer;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Antrag getAntrag() {
        return antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
    }

    @Override
    public String toString() {
        return "AntragEingereicht{" +
                "antragsnummer='" + antragsnummer + '\'' +
                ", timestamp=" + timestamp +
                ", antrag=" + antrag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntragEingereicht that = (AntragEingereicht) o;
        return Objects.equals(antragsnummer, that.antragsnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(antragsnummer);
    }
}
