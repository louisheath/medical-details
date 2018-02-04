package medinfo.client;


import medinfo.misc.FormString;
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

    // add fixed clients to save dev time
    private void makeClients() {
        Client jack = new Client("12345", "Jack Jones", "Katie", "071234");
        Client kenny = new Client("15435", "Kenny Lomas", "Jake Campbell", "0712463");
        Client palvi = new Client("64533", "Palvi Shah", "Muntazim", "07567467");
        clientRepo.save(jack);
        clientRepo.save(kenny);
        clientRepo.save(palvi);
    }

    @RequestMapping("/")
    public String hello(Model model) {
        makeClients();
        List<Client> clients = new ArrayList<>();
        clientRepo.findAll().forEach(c -> clients.add(c));
        model.addAttribute("clients", clients);
        return "index";
    }

    @RequestMapping("/{id}")
    public String showClient(@PathVariable String id, Model model) {
        model.addAttribute(clientRepo.findOne(id));
        return "viewClient";
    }

    // Add client
    //
    @RequestMapping("/add")
    public String addClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "addClient";
    }
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addClient(@ModelAttribute Client client, Model model) {
        clientRepo.save(client);
        return ("redirect:/" + client.getnHSNumber());
    }

    // Add info bullet to client
    //
    @RequestMapping("/{id}/addInfo")
    public String addInfoForm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("formString", new FormString());
        return "addInfo";
    }
    @RequestMapping(value="/{id}/addInfo", method=RequestMethod.POST)
    public String addInfo(@ModelAttribute FormString formString, Model model, @PathVariable String id) {
        Client client = clientRepo.findOne(id);
        List<String> infos = client.getInfos();
        infos.add(formString.getContents());
        client.setInfos(infos);
        clientRepo.save(client);
        return ("redirect:/" + client.getnHSNumber());
    }

    // Add meds bullet to client
    //
    @RequestMapping("/{id}/addMed")
    public String addMedForm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("formString", new FormString());
        return "addMed";
    }
    @RequestMapping(value="/{id}/addMed", method=RequestMethod.POST)
    public String addMed(@ModelAttribute FormString formString, Model model, @PathVariable String id) {
        Client client = clientRepo.findOne(id);
        List<String> meds = client.getMeds();
        meds.add(formString.getContents());
        client.setMeds(meds);
        clientRepo.save(client);
        return ("redirect:/" + client.getnHSNumber());
    }
}
