
package restModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Like {

    @SerializedName("oy_toplam")
    @Expose
    private String oyToplam;
    @SerializedName("ortalama")
    @Expose
    private String ortalama;

    public String getOyToplam() {
        return oyToplam;
    }

    public void setOyToplam(String oyToplam) {
        this.oyToplam = oyToplam;
    }

    public String getOrtalama() {
        return ortalama;
    }

    public void setOrtalama(String ortalama) {
        this.ortalama = ortalama;
    }

}
