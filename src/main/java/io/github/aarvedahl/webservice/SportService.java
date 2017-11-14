package io.github.aarvedahl.webservice;

import com.sportsing.api.Match;
import io.github.aarvedahl.ejb.SportEJB;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/sportservice")
public class SportService {

    @EJB private SportEJB sportEJB;

    private List<Match>matches = initMatches();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getString() {
        return "test123";
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_XML)
    public List<Match> getMatches() {
        return matches;
    }

    @GET
    @Path("/sport/{number}")
    @Produces(MediaType.APPLICATION_XML)
    public Match getOneSport(@PathParam("number") String number) {
        int sport = Integer.parseInt(number);
        if(sport > matches.size() -1) {
            return matches.get(0);
        }
        return matches.get(sport);
    }


    private List<Match> initMatches() {
        List<Match> sports = new ArrayList<>();
        Match ice_hockey = new Match("Ice Hockey");
        ice_hockey.registerContender("Alex", 3, 4);
        Match soccer = new Match("Soccer");
        soccer.registerContender("Sweden", 1, 3);
        soccer.registerContender("Italy", 0, 2);
        sports.add(soccer);
        sports.add(ice_hockey);
        return sports;
    }
}
