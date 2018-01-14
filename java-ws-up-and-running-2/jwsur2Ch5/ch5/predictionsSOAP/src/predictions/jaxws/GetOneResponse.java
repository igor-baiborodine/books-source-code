
package predictions.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getOneResponse", namespace = "http://predictions/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOneResponse", namespace = "http://predictions/")
public class GetOneResponse {

    @XmlElement(name = "return", namespace = "")
    private predictions.Prediction _return;

    /**
     * 
     * @return
     *     returns Prediction
     */
    public predictions.Prediction getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(predictions.Prediction _return) {
        this._return = _return;
    }

}
