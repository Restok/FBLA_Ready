package profoundmasteryinidiocy.gmail.com.schedulermaybe.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest{

    public static final String REGISTER_REQUEST_URL = "https://mhskey.club/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String password, String email, Response.Listener<String> listener){

        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
