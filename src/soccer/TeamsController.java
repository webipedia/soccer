package soccer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
class TeamsController {

	@RequestMapping(value="/teams", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Collection<Team> getTeams(HttpServletResponse  response) {
		Team t1 = new Team("Real Madrid","1902","1");
		Team t2 = new Team("Barcelona","1904","2");
		Team t3 = new Team("Atlético","1914","3");

		Collection<Team> c = new ArrayList<Team>();
		c.add(t1); c.add(t2); c.add(t3);

		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_OK);
			//response.setHeader("Content-Type", "application/json");	
			return c;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/teams/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Team getTeam(@PathVariable("id") long id, HttpServletResponse  response) {
		Team t1 = new Team("Real Madrid","1902","1");
		Team t2 = new Team("Barcelona","1904","2");
		Team t3 = new Team("Atlético","1914","3");
		
		Team t = null;
		if (id == 1) { t = t1; }
		else if (id == 2) {	t = t2;	}
		else if (id == 3) { t = t3;	}		
		
		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_OK);
			//response.setHeader("Content-Type", "application/json");
			return t;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/teams", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	Team postTeams(@RequestBody Team t, HttpServletResponse  response) {	
		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_CREATED);
			//response.setHeader("Content-Type", "application/json");
			return t;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value="/teams/{id}/stadium", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Stadium getStadium(@PathVariable("id") long id, HttpServletResponse  response) {
		Stadium s1 = new Stadium("100000","Santiago Bernabeu","Madrid");
		Stadium s2 = new Stadium("120000","Camp Nou","Barcelona");
		Stadium s3 = new Stadium("50000","Mestalla","Valencia");
		
		Stadium s = null;
		if (id == 1) { s = s1; }
		else if (id == 2) {	s = s2;	}
		else if (id == 3) { s = s3;	}	

		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_OK);
			//response.setHeader("Content-Type", "application/json");	
			return s;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/teams/{id}/stadium", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	Stadium postStadium(@RequestBody Stadium s, HttpServletResponse  response) {	
		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_CREATED);
			//response.setHeader("Content-Type", "application/json");
			return s;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value="/teams/{id}/players", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Collection<Player> getPlayers(@PathVariable("id") long id, HttpServletResponse  response) {
		Player p1 = new Player("Cristiano","10","Portugal","30");
		Player p2 = new Player("Bale","3","Gales","25");
		Player p3 = new Player("Isco","3","España","23");
		Collection<Player> c1 = new ArrayList<Player>();
		c1.add(p1); c1.add(p2); c1.add(p3);
		
		Player p4 = new Player("Messi","14","Argentina","28");
		Player p5 = new Player("Suárez","5","Uruguay","31");
		Collection<Player> c2 = new ArrayList<Player>();
		c2.add(p4);
		c2.add(p5);
		
		Collection<Player> c = null;
		if (id == 1) c = c1;
		else if (id == 2) c = c2;
				
		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_OK);
			//response.setHeader("Content-Type", "application/json");	
			return c;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/teams/{id}/players", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	Player postPlayers(@PathVariable("id") long id, @RequestBody Player p, HttpServletResponse  response) {	
		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_CREATED);
			//response.setHeader("Content-Type", "application/json");
			return p;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}	
	
	@RequestMapping(value = "/teams/{id}/players/{id_player}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Player getPlayer(@PathVariable("id") long id, @PathVariable("id_player") long id_player, HttpServletResponse  response) {
		Player p1 = new Player("Cristiano","10","Portugal","30");
		Player p2 = new Player("Bale","3","Gales","25");
		Player p3 = new Player("Isco","3","España","23");
		Player p4 = new Player("Messi","14","Argentina","28");
		Player p5 = new Player("Suárez","5","Uruguay","31");
		
		Player p = null;
		if (id == 1) { 
			if (id_player == 1) { p = p1; }
			else if (id_player == 2) {	p = p2;	}
			else if (id_player == 3) { p = p3;	}		
		}
		else if (id == 2) {
			if (id_player == 1) { p = p4; }
			else if (id_player == 2) {	p = p5;	}
		}
		
		try {
			// Convert object to JSON string
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p));
			
			// Send response
			response.setStatus(HttpServletResponse.SC_OK);
			//response.setHeader("Content-Type", "application/json");
			return p;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}	
	
	/*
	 * private final BookmarkRepository bookmarkRepository;
	 * 
	 * private final AccountRepository accountRepository;
	 * 
	 * @Autowired BookmarkRestController(BookmarkRepository bookmarkRepository,
	 * AccountRepository accountRepository) { this.bookmarkRepository =
	 * bookmarkRepository; this.accountRepository = accountRepository; }
	 * 
	 * @RequestMapping(method = RequestMethod.GET) Collection<Bookmark>
	 * readBookmarks(@PathVariable String userId) { this.validateUser(userId);
	 * return this.bookmarkRepository.findByAccountUsername(userId); }
	 * 
	 * ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark
	 * input) { this.validateUser(userId);
	 * 
	 * return this.accountRepository .findByUsername(userId) .map(account -> {
	 * Bookmark result = bookmarkRepository.save(new Bookmark(account, input.uri,
	 * input.description));
	 * 
	 * URI location = ServletUriComponentsBuilder
	 * .fromCurrentRequest().path("/{id}") .buildAndExpand(result.getId()).toUri();
	 * 
	 * return ResponseEntity.created(location).build(); })
	 * .orElse(ResponseEntity.noContent().build());
	 * 
	 * }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value = "/{bookmarkId}") Bookmark
	 * readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
	 * this.validateUser(userId); return
	 * this.bookmarkRepository.findOne(bookmarkId); }
	 * 
	 * private void validateUser(String userId) {
	 * this.accountRepository.findByUsername(userId).orElseThrow( () -> new
	 * UserNotFoundException(userId)); }
	 */

}