package io.github.aarvedahl.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="match")
public class MatchJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchid;

    @Column
    private String sport;

    private List<ContenderJPA> contenders;

    public MatchJPA() {}
    public MatchJPA(String sport) {
        this.sport = sport;
        contenders = new ArrayList<ContenderJPA>();
    }
    public void registerContender(ContenderJPA cr) {
        contenders.add(cr);
    }
    public void registerContender(String name, float score, int place) {
        registerContender(new ContenderJPA(name, score, place));
    }

    public String getSport() {
        return sport;
    }
    public List<ContenderJPA> getContenders() {
        return contenders;
    }

    public int getMatchid() {
        return matchid;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }
}
