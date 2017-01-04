package mymapapp.newconverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jtran_000 on 3/26/2016.
 */
public class Rates
{
    private Double GBP;
    private Double JPY;
    private Double EUR;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The GBP
     */
    public Double getGBP() {
        return GBP;
    }

    /**
     *
     * @param GBP
     * The GBP
     */
    public void setGBP(Double GBP) {
        this.GBP = GBP;
    }

    /**
     *
     * @return
     * The JPY
     */
    public Double getJPY() {
        return JPY;
    }

    /**
     *
     * @param JPY
     * The JPY
     */
    public void setJPY(Double JPY) {
        this.JPY = JPY;
    }

    /**
     *
     * @return
     * The EUR
     */
    public Double getEUR() {
        return EUR;
    }

    /**
     *
     * @param EUR
     * The EUR
     */

    public void setEUR(Double EUR) {
        this.EUR = EUR;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
