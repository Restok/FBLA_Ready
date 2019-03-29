package profoundmasteryinidiocy.gmail.com.schedulermaybe.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class writeBugRequest extends StringRequest {
    public static final String WRITE_BUG_REQUEST_URL = "https://mhskey.club/bugreport.php";
    private Map<String, String> params;

    public writeBugRequest(String category, String details, Response.Listener<String> listener){

        super(Method.GET, WRITE_BUG_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("Category",category);
        params.put("Details", details);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
