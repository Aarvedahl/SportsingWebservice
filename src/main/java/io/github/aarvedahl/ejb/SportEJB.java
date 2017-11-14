package io.github.aarvedahl.ejb;

import com.sportsing.api.Match;

import javax.persistence.EntityManager;
import java.util.List;

public class SportEJB {

    protected EntityManager em;

    public List<Match> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Match.class));
        return em.createQuery(cq).getResultList();
    }

    public void edit(Match match) {
        em.merge(match);
    }


    public void create(Match match) {
        em.persist(match);
    }

    public Match find(Match id) {
        return em.find(Match.class, id);
    }

}
