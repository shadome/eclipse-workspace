package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import domain.Monster;
import domain.Player;
import domain.Statistic;
import domain.Trainer;
import domain.Type;
import domain.battlefield.Battlefield;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Battlefield")
public class BattlefieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattlefieldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().println("battlefield");
		Battlefield b = new Battlefield();
		Monster m = new Monster();
		Statistic s = new Statistic();
		b.setOpponent(new Trainer());
		b.setPlayer(new Player());
		s.setBase(100);
		m.setLevel(50);
		m.setName("mew");
		m.setNumber(151);
		m.setType1(Type.PSYCHIC);
		m.setType2(Type.NONE);
		m.setHp(100);
		try {
			m.setAttack((Statistic) s.clone());
			m.setDefense((Statistic) s.clone());
			m.setSpattack((Statistic) s.clone());
			m.setSpdefense((Statistic) s.clone());
			m.setSpeed((Statistic) s.clone());
			b.getOpponent().getTeam().add((Monster) m.clone());
			b.getOpponent().getTeam().add((Monster) m.clone());
			b.getPlayer().getTeam().add((Monster) m.clone());
			b.getPlayer().getTeam().add((Monster) m.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = new Gson().toJson(b);
		System.out.println(b);
		response.getWriter().println(this.battlefieldToString(b));
//		response.setContentType("application/json");
//		// Get the printwriter object from response to write the required json object to the output stream      
//		PrintWriter out = response.getWriter();
//		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
//		out.print(jsonObject);
//		out.flush();
	}
	
	@Deprecated
	private String battlefieldToString(Battlefield b) {
		return new StringBuilder()
				.append(this.monsterToString(b.getOpponent().getTeam().get(0)))
				.append(System.lineSeparator())
				.append(this.monsterToString(b.getOpponent().getTeam().get(1)))
				.append(System.lineSeparator())
				.append(System.lineSeparator())
				.append(this.monsterToString(b.getPlayer().getTeam().get(0)))
				.append(System.lineSeparator())
				.append(this.monsterToString(b.getPlayer().getTeam().get(1)))
				.toString();
	}
	@Deprecated
	private String monsterToString(Monster m) {
		return new StringBuilder()
			.append(m.getName())
			.append(" [")
			.append(m.getHp())
			.append("]")
			.toString();
	}
// TODO search for RESTful API best practice (GET? POST?)
}
