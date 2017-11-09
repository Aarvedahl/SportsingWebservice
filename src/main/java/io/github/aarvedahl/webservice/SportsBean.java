package io.github.aarvedahl.webservice;


import com.sportsing.api.ContenderResult;
import com.sportsing.api.Match;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Named
@ViewScoped
public class SportsBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Match matches;
    private List<ContenderResult> contenders;

    public Match getMatches() {
        if(matches == null) {
            WebTarget sportstarget = ClientBuilder.newClient().target("http://localhost:8080/jaxrs-webservice/sportservice/sport/2");
            // WebTarget specificsport = sportstarget.path("/list");
            matches = sportstarget.request(MediaType.APPLICATION_XML).get(Match.class);
        }
        return matches;
    }

    public List<ContenderResult> getCopy() {
        Iterator<ContenderResult> matches = getMatches().getContenderIterator();
        contenders = new ArrayList<ContenderResult>();
        while (matches.hasNext())
            contenders.add(matches.next());
        return contenders;
    }
}

