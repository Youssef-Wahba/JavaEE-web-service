package services;

import java.util.HashMap;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ejbs.Calculator;

@Stateless
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalcService {
	@PersistenceContext
	EntityManager em;
	
	@POST
	@Path("/calc")
	public  HashMap<String,Object> calculate(Calculator calc) throws EJBException {
		String op = calc.getOperator();
		int num1 = calc.getNumber1();
		int num2 = calc.getNumber2();
//		hash map for response format
		HashMap<String,Object> res= new HashMap<String ,Object>();
		em.persist(calc);
//		logic for calculations
		if(op.equals("+")) {
			res.put("Result", num1 + num2);
			return res;
		}
		else if(op.equals("-")){
			res.put("Result", num1 - num2);
			return res;
		}
		else if(op.equals("*")){
			res.put("Result", num1 * num2);
			return res;
		}
		else if(op.equals("/")){
			res.put("Result", num1 / num2);
			return res;
		}
		else {
			res.put("Result", "unsupported operator");
			return res;
		}
	}
	
	@GET
	@Path("/calculations")
	public List<Calculator> getAllCalculations() throws EJBException {
//		query to get all calculations
		TypedQuery<Calculator> query = em.createQuery("SELECT c FROM Calculator c",Calculator.class);
		return query.getResultList();
	} 
}
