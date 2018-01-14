
package predictions.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllResponse", namespace = "http://predictions/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllResponse", namespace = "http://predictions/")
public class GetAllResponse {

    @XmlElement(name = "return", namespace = "")
    private List<predictions.Prediction> _return;

    /**
     * 
     * @return
     *     returns List<Prediction>
     */
    public List<predictions.Prediction> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<predictions.Prediction> _return) {
        this._return = _return;
    }

}
