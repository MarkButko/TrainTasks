import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    String cc;
    BigDecimal rate;

    @Override
    public String toString() {
        return "Currency{" +
                "cc='" + cc + '\'' +
                ", rate=" + rate +
                '}';
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
