package medinfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    ClientRepo clientRepo;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "<p>/id -> show client</p>" +
                "<p>/add -> add new client</p>" +
                "<p>/all -> show all clients</p>";
    }

    @RequestMapping("/{id}")
    public String render(@PathVariable String id, Model model) {
        model.addAttribute(clientRepo.findOne(id));
        return "dynamic";
    }

    @RequestMapping(value="/all")
    @ResponseBody
    public String getAll() {
        List<Client> clients = new ArrayList<>();
        clientRepo.findAll().forEach(c -> clients.add(c));
        return clients.toString();
    }

    // create new client object and point to form to fill in attributes
    @RequestMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("client", new Client());
        return "addClient";
    }

    // receive the new client from form and save
    @RequestMapping(value="/confirmAdd", method=RequestMethod.POST)
    public String submitPatient(@ModelAttribute Client client, Model model) {
        clientRepo.save(client);
        return ("redirect:/" + client.getnHSNumber());
    }
}
