package org.ipc.synapsis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
@RequestMapping("/application")
public class Controller {

    @Autowired
    Environment env;

    @RequestMapping("/nameapp")
    public String index() {

        return "Nom de l'application: "+env.getProperty("name");
    }
	
	  @RequestMapping("/activeprofile")
	  public String index2() {

        return "Profil actif: "+ Arrays.toString(env.getActiveProfiles());
    }

}