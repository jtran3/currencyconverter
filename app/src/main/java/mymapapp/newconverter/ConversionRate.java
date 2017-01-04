package mymapapp.newconverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jtran_000 on 3/26/2016.
 */
public class ConversionRate
{

    private String base;
    private String date;
    private String rates;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The base
     */
    public String getBase() {
        return base;
    }

    /**
     *
     * @param base
     * The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }



    /**
     *
     * @return
     * The Rate
     */
    public String getRates() {
        return rates;
    }

    /**
     *
     * @param Rate
     * The Rate
     */
    public void setRate(String Rate) {
        this.rates = rates;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}

