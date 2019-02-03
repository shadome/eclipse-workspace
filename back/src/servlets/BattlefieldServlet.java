package servlets;

import java.io.IOException;
import java.util.Arrays;

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
import domain.moves.IMove;
import domain.moves.Move;
import domain.moves.MoveCategory;
import domain.moves.SpecialMoveDecorator;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/battlefield")
public class BattlefieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	// mock for WS
	private static final Battlefield battlefield = new Battlefield();
	private static final Move psychic = new Move();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattlefieldServlet() {
        super();
		Monster m = new Monster();
		Statistic s = new Statistic();
		battlefield.setOpponent(new Trainer());
		battlefield.setPlayer(new Player());
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
			battlefield.getOpponent().getTeam().add((Monster) m.clone());
			battlefield.getOpponent().getTeam().add((Monster) m.clone());
			battlefield.getPlayer().getTeam().add((Monster) m.clone());
			battlefield.getPlayer().getTeam().add((Monster) m.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		psychic.setPower(90);
		psychic.setType(Type.PSYCHIC);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().println("battlefield");
		String s1 = request.getParameter("move1");
		String s2 = request.getParameter("move2");
		String str = new Gson().toJson(battlefield);
		IMove decoratedPsychic = new SpecialMoveDecorator(psychic);
		decoratedPsychic.execute(battlefield.getPlayer().getTeam().get(0), Arrays.asList(battlefield.getOpponent().getTeam().get(1)), battlefield);
		s1 = '\n' + s1 + '\n' + s2;
		System.out.println(battlefield);
		response.getWriter().println(this.battlefieldToString(battlefield) +  s1);
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
