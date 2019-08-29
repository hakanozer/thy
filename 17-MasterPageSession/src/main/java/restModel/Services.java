package restModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Services {
	
	@GET("product.php?ref=5380f5dbcc3b1021f93ab24c3a1aac24&start=0")
	Call<JsonData> fncProduct();

}
