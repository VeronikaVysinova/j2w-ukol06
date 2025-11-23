package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.client.support.InterceptingHttpAccessor;

@Entity
public class Vizitka {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length (max = 100, min = 2, message = "Celé jméno musí mít minimálně 2 znaky a maximálně 100 znaků.")
    @NotBlank (message = "Celé jméno je povinný údaj.")
    private String celeJmeno;

    @Length (max = 100,  message = "Název firmy nesmí být delší než 100 znaků.")
    @NotBlank (message = "Firma je povinný údaj.")
    private String firma;

    @Length (max = 100, message = "Název ulice nesmí být delší než 100 znaků.")
    @NotBlank (message = "Název ulice je povinný údaj.")
    private String ulice;

    @Length (max = 100, message = "Název obce nesmí být delší než 100 znaků.")
    @NotBlank (message = "Název obce je povinný údaj.")
    private String obec;

    @Pattern(regexp = "\\d{5}", message = "PSČ musí mít přesně 5 číslic.")
    @NotBlank(message = "Název obce je povinný údaj.")
    private String psc;

    @Length (max = 100, message = "Email nesmí být delší než 100 znaků.")
    @Email (message = "Email musí mít správný formát.")
    private String email;

    @Length (max = 20, message = "Telefonní číslo nesmí být delší než 20 znaků.")
    private String telefon;

    @Length (max = 100, message = "Web nesmí být delší než 100 znaků.")
    @Pattern(regexp = "www\\..+")
    private String web;

    public String getCelaAdresa(){
        return ulice + " " + obec + " " + psc;
    }

    public Vizitka(){ //bezparam. konstruktor
    }


    public Integer getId(){ return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
