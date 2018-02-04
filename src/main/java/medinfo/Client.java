package medinfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    private String nHSNumber;
    private String name;

    protected Client() {}

    public Client(String nHSNumber, String name) {
        this.nHSNumber = nHSNumber;
        this.name = name;
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

    @Override
    public String toString() {
        return String.format(
                "Customer[NHSnum='%s', name='%s']",
                nHSNumber, name);
    }
}
