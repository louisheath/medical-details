package medinfo.client;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    private String nHSNumber;
    private String name;
    private String iCEName;
    private String iCENumber;
    @ElementCollection
    private List<String> infos;
    @ElementCollection
    private List<String> meds;

    public Client() {
        this.infos = new ArrayList<>();
        this.meds = new ArrayList<>();
    }

    public Client(String nHSNumber, String name, String iCEName, String iCENumber) {
        this.nHSNumber = nHSNumber;
        this.name = name;
        this.iCEName = iCEName;
        this.iCENumber = iCENumber;
        this.infos = new ArrayList<>();
        this.meds = new ArrayList<>();
    }

    public String getnHSNumber() {
        return nHSNumber;
    }

    public void setnHSNumber(String nHSNumber) {
        this.nHSNumber = nHSNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getiCEName() {
        return iCEName;
    }

    public void setiCEName(String iCEName) {
        this.iCEName = iCEName;
    }

    public String getiCENumber() {
        return iCENumber;
    }

    public void setiCENumber(String iCENumber) {
        this.iCENumber = iCENumber;
    }

    public List<String> getInfos() {
        return infos;
    }

    public void setInfos(List<String> infos) {
        this.infos = infos;
    }

    public List<String> getMeds() {
        return meds;
    }

    public void setMeds(List<String> meds) {
        this.meds = meds;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[NHSnum='%s', name='%s']",
                nHSNumber, name);
    }
}
