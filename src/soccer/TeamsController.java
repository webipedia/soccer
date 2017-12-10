package soccer;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
class TeamsController {

	@RequestMapping(value = "/teams", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	List<Team> getTeams(HttpServletResponse response) {
		List<Team> l = null;
		
		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			// List<Team> list = session.createCriteria(Team.class).list(); /* deprecated */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Team> query = builder.createQuery(Team.class);
			Root<Team> root = query.from(Team.class);
			query.select(root);
			Query<Team> q = session.createQuery(query);
			l = q.getResultList();
			
			/* end transaction */
			transaction.commit();

			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(l));

			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_OK);
			// response.setHeader("Content-Type", "application/json");			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return l;
	}

	@RequestMapping(value = "/teams/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Team getTeam(@PathVariable("id") long id, HttpServletResponse response) {
		Team t = null;

		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Team> query = builder.createQuery(Team.class);
			Root<Team> root = query.from(Team.class);
			query.select(root).where(builder.equal(root.get("id"),id));
			Query<Team> q = session.createQuery(query);	
			List<Team> list = q.getResultList();
			if (!list.isEmpty()) {
				t = list.get(0);
			}
			
			/* end transaction */
			transaction.commit();
			
			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t));

			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_OK);
			// response.setHeader("Content-Type", "application/json");			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return t;
	}

	@RequestMapping(value = "/teams", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	Team postTeams(@RequestBody Team team, HttpServletResponse response) {
		Team t = null;
		
		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			int id = (int)session.save(team);
			t = team;
			t.setId(id);
			
			/* end transaction */
			transaction.commit();
			// HibernateUtil.shutdown(); /* cierra el pool y el siguiente acceso falla */

			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t));
			
			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_CREATED);
			// response.setHeader("Content-Type", "application/json");
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return t;
	}

	@RequestMapping(value = "/teams/{id}/stadium", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Stadium getStadium(@PathVariable("id") long idTeam, HttpServletResponse response) {
		Stadium s = null;

		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Team> query = builder.createQuery(Team.class);
			Root<Team> root = query.from(Team.class);
			query.select(root).where(builder.equal(root.get("id"),idTeam));
			Query<Team> q = session.createQuery(query);
			List<Team> teams = q.getResultList();
			if (!teams.isEmpty()) {
				Team t = teams.get(0);
				s = t.getStadium();				
			}	
			
			/* end transaction */
			transaction.commit();
			
			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s));

			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_OK);
			// response.setHeader("Content-Type", "application/json");			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return s;
	}

	@RequestMapping(value = "/teams/{id}/stadium", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	Stadium postStadium(@PathVariable("id") long idTeam, @RequestBody Stadium stadium, HttpServletResponse response) {
		Stadium s = null;
		
		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Team> query = builder.createQuery(Team.class);
			Root<Team> root = query.from(Team.class);
			query.select(root).where(builder.equal(root.get("id"),idTeam));
			Query<Team> q = session.createQuery(query);	
			List<Team> list = q.getResultList();
			if (!list.isEmpty()) {
				Team t = list.get(0);
				//t.setStadium(stadium);
				stadium.setTeam(t);
				int id = (int)session.save(stadium);
				s = stadium;
				s.setId(id);				
			}			
			
			/* end transaction */
			transaction.commit();
			// HibernateUtil.shutdown(); /* cierra el pool y el siguiente acceso falla */

			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s));
			
			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_CREATED);
			// response.setHeader("Content-Type", "application/json");
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return s;
	}

	@RequestMapping(value = "/teams/{id}/players", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Set<Player> getPlayers(@PathVariable("id") long idTeam, HttpServletResponse response) {
		Set<Player> l = null;
		
		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			// List<Team> list = session.createCriteria(Team.class).list(); /* deprecated */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Team> query = builder.createQuery(Team.class);
			Root<Team> root = query.from(Team.class);
			query.select(root).where(builder.equal(root.get("id"),idTeam));
			Query<Team> q = session.createQuery(query);
			List<Team> teams = q.getResultList();
			if (!teams.isEmpty()) {
				Team t = teams.get(0);
				l = t.getPlayers();				
			}	
			
			/* end transaction */
			transaction.commit();

			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(l));

			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_OK);
			// response.setHeader("Content-Type", "application/json");			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return l;
	}

	@RequestMapping(value = "/teams/{id}/players", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	Player postPlayers(@PathVariable("id") long idTeam, @RequestBody Player player, HttpServletResponse response) {
		Player p = null;
		
		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Team> query = builder.createQuery(Team.class);
			Root<Team> root = query.from(Team.class);
			query.select(root).where(builder.equal(root.get("id"),idTeam));
			Query<Team> q = session.createQuery(query);	
			List<Team> list = q.getResultList();
			if (!list.isEmpty()) {
				Team t = list.get(0);
				//t.setStadium(stadium);
				player.setTeam(t);
				int id = (int)session.save(player);
				p = player;
				p.setId(id);				
			}			
			
			/* end transaction */
			transaction.commit();
			// HibernateUtil.shutdown(); /* cierra el pool y el siguiente acceso falla */

			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p));
			
			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_CREATED);
			// response.setHeader("Content-Type", "application/json");
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return p;
	}

	@RequestMapping(value = "/teams/{id}/players/{id_player}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Player getPlayer(@PathVariable("id") long idTeam, @PathVariable("id_player") long idPlayer, HttpServletResponse response) {
		Player p = null;
		
		Session session = null;
		Transaction transaction = null;
		try {
			/* get session */
			session = HibernateUtil.getSessionFactory().openSession();
			
			/* start transaction */
			transaction = session.getTransaction();
			transaction.begin();
			
			/* perform query */
			// List<Team> list = session.createCriteria(Team.class).list(); /* deprecated */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Team> query = builder.createQuery(Team.class);
			Root<Team> root = query.from(Team.class);
			query.select(root).where(builder.equal(root.get("id"),idTeam));
			Query<Team> q = session.createQuery(query);
			List<Team> teams = q.getResultList();
			if (!teams.isEmpty()) {
				Team t = teams.get(0);
				Set<Player> l = t.getPlayers();	
				Iterator<Player> it = l.iterator();
				while (it.hasNext()) {
					Player currentPlayer = it.next();
					if (currentPlayer.getId() == idPlayer) {
						p = currentPlayer;
						break;
					}
				}
			}	
			
			/* end transaction */
			transaction.commit();

			/* convert object to JSON string */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p));

			/* set response http headers */
			response.setStatus(HttpServletResponse.SC_OK);
			// response.setHeader("Content-Type", "application/json");			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return p;
	}

}