package io.github.aarvedahl.jpa;

import javax.persistence.*;

@Entity
@Table(name="contender")
public class ContenderJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contenderid;

    @Column
    private String contendername;

    @Column
    private float score;

    @Column
    private int place;

    public ContenderJPA() {}
    public ContenderJPA(String contendername, float score, int place) {
        this.contendername = contendername;
        this.score = score;
        this.place = place;
    }

    public String getContendername() { return contendername; }
    public void setContendername(String contendername) { this.contendername = contendername; }
    public float getScore() { return score; }
    public void setScore(float score) { this.score = score; }
    public int getPlace() { return place; }
    public void setPlace(int place) { this.place = place; }
    public void setContenderid(int contenderid) { this.contenderid = contenderid; }
    public int getContenderid() { return contenderid; }
}
