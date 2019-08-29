
package restModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Campaign {

    @SerializedName("campaignTypeId")
    @Expose
    private String campaignTypeId;

    public String getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(String campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

}
