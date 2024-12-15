package com.klef.jfsd.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController  //controller + response body
public class ClientController 
{
	List<Employee> emps = new ArrayList<Employee>();
	
	
  @RequestMapping(path="/", method = RequestMethod.GET)
  public String demo()
  {
    return "Hi Spring Boot";
  }
  @GetMapping(path="/demo1")
  public String demo1()
  {
    return "Page Not Found";
  }
  @GetMapping("demo2")
  public String demo2()
  {
    return "Error Occured";
  }
  @GetMapping("demo3")
  public int demo3()
  {
    return 123;
  }
  @GetMapping("demo4")
  public String demo4(@RequestParam("id") int eid)
  {
    return "ID="+eid;
  }


@GetMapping("demo5")
public String demo5(@RequestParam("p") int x,@RequestParam("q") int y)
{
	int r = x+y;
	return Integer.toString(r);
}
@GetMapping("demo6/{id}")
public String demo6(@RequestParam("id") int eid) 
{
    return "ID="+eid;
}
@GetMapping("demo7/{a}/{b}")
public String demo7(@PathVariable int i,int j) 
{
	int r = i+j;
    return Integer.toString(r);
}

@PostMapping("")
public String postMethodName(@RequestBody String entity) {
    //TODO: process POST request
    
    return entity;
}
@PostMapping("addemp")
public String addemp(@RequestBody Employee e) 
{
    emps.add(e);
    return "Employee Added";
    
}
@GetMapping("viewallemps")
	public List<Employee> viewallemps() {
		return emps;
	}



}