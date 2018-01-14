package predEJB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQueries({
   @NamedQuery(name = "pred.list", query = "select p from Prediction p")
})
public class Prediction implements Serializable {
    private String who;   // person
    private String what;  // his/her prediction
    private int    id;    // identifier used as lookup-key

    public Prediction() { }

    public String getWho() { return this.who; }
    public void setWho(String who) { this.who = who; }

    public String getWhat() { return this.what; }
    public void setWhat(String what) { this.what = what; }

    @Id
    @GeneratedValue
    public int getId() { return this.id; }
    public void setId(int id) {	this.id = id; }
}

