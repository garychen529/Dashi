package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class RecommendRestaurants
 */
@WebServlet("/recommendation")
public class RecommendRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendRestaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray array = new JSONArray();
		try {
			if (request.getParameterMap().containsKey("user_id")) {
				String userId = request.getParameter("user_id");

				// create some fake restaurants
				JSONObject restaurant1 = new JSONObject();
				JSONObject restaurant2 = new JSONObject();
				
				restaurant1.put("name", "panda express");
				restaurant1.put("location", "downtown");
				restaurant1.put("country", "United States");
				
				restaurant2.put("name", "hongkong express");
				restaurant2.put("location", "uptown");
				restaurant2.put("country", "United States");
				
				array.put(restaurant1);
				array.put(restaurant2);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		RpcParser.writeOutput(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
