package io.github.aarvedahl.webservice;

import com.sportsing.api.Match;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/sportservice")
public class SportService {

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
    @Path("/listnumber/{number}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Match> getNumberMatches() {
        // Return a specific number of matches
        return matches;
    }

    private List<Match> initMatches() {
        List<Match> sports = new ArrayList<>();
        Match match = new Match("Ice Hockey");
        match.registerContender("Alex", 3, 4);
        sports.add(match);
        return sports;
    }
}
