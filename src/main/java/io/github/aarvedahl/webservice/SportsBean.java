package io.github.aarvedahl.webservice;

import com.sportsing.api.ContenderResult;
import com.sportsing.api.Match;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@ViewScoped
public class SportsBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Match> matches;
    private List<ContenderResult> contenders;
    private static Client client = ClientBuilder.newClient();
    private static WebTarget baseTarget = client.target("http://localhost:8080/jaxrs-webservice/sportservice/list");


    public List<Match> getMatches() {
        if(matches == null) {
            matches = baseTarget.request().get(new GenericType<List<Match>>() {});
        }
        return matches;
    }

    public List<ContenderResult> getCopy() {
        contenders = new ArrayList<ContenderResult>();
        for(Match match : getMatches()) {
            while(match.getContenderIterator().hasNext()) {
                contenders.add(match.getContenderIterator().next());
            }
        }
        return contenders;
    }
}

