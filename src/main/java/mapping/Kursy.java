package mapping;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Kursy {
    private int kursId;
    private int odleglosc;
    private BigDecimal cena;
    private Klienci klienciByKlientId;
    private Kierowcy kierowcyByKierowcaId;
    private Daty datyByDataId;

    @Id
    @Column(name = "kurs_id", nullable = false)
    public int getKursId() {
        return kursId;
    }

    public void setKursId(int kursId) {
        this.kursId = kursId;
    }

    @Basic
    @Column(name = "odleglosc", nullable = false)
    public int getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(int odleglosc) {
        this.odleglosc = odleglosc;
    }

    @Basic
    @Column(name = "cena", nullable = false, precision = 0)
    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kursy kursy = (Kursy) o;
        return kursId == kursy.kursId &&
                odleglosc == kursy.odleglosc &&
                Objects.equals(cena, kursy.cena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kursId, odleglosc, cena);
    }

    @ManyToOne
    @JoinColumn(name = "klient_id", referencedColumnName = "klient_id", nullable = false)
    public Klienci getKlienciByKlientId() {
        return klienciByKlientId;
    }

    public void setKlienciByKlientId(Klienci klienciByKlientId) {
        this.klienciByKlientId = klienciByKlientId;
    }

    @ManyToOne
    @JoinColumn(name = "kierowca_id", referencedColumnName = "kierowca_id", nullable = false)
    public Kierowcy getKierowcyByKierowcaId() {
        return kierowcyByKierowcaId;
    }

    public void setKierowcyByKierowcaId(Kierowcy kierowcyByKierowcaId) {
        this.kierowcyByKierowcaId = kierowcyByKierowcaId;
    }

    @ManyToOne
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false)
    public Daty getDatyByDataId() {
        return datyByDataId;
    }

    public void setDatyByDataId(Daty datyByDataId) {
        this.datyByDataId = datyByDataId;
    }

    public String getImie() {
        return kierowcyByKierowcaId.getImie();
    }

    public void setImie(String imie) {
        this.kierowcyByKierowcaId.setImie(imie);
    }

    public String getNazwisko() {
        return kierowcyByKierowcaId.getNazwisko();
    }

    public void setNazwisko(String nazwisko) {
        this.kierowcyByKierowcaId.setNazwisko(nazwisko);
    }
}
