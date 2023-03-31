package com.crud;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	List<Employee> emp = new ArrayList<Employee>();

	@RequestMapping("/createUser")
	public ModelAndView create(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Employee em = new Employee();
		em.createEmployee(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
				request.getParameter("address"), request.getParameter("gender"));
		emp.add(em);
		mv.setViewName("result.jsp");
		mv.addObject("result", "Employee Added Sucessfully");
		return mv;
	}

	@RequestMapping("/displayUserById")
	public ModelAndView read(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int count = 0;
		ModelAndView mv = new ModelAndView();
		JSONObject res = new JSONObject();
		for (Employee e : emp) {
			if (e.id == id) {
				res.put("id", id).put("name", e.getName()).put("address", e.getAddress()).put("gender", e.getGender());
				mv.addObject("result", res);
			} else if (emp.size() == count) {
				mv.addObject("result", "Emplyoee not found");
				break;
			}
			count++;
		}
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping("/displayAllUser")
	public ModelAndView readAll(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		JSONArray res = new JSONArray();
		for (Employee e : emp) {
			JSONObject result = new JSONObject();
			result.put("id", e.getId()).put("name", e.getName()).put("address", e.getAddress()).put("gender",
					e.getGender());
			res.put(result);
		}
		System.out.println(res);
		mv.addObject("result", res);
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping("/deleteUserById")
	public ModelAndView delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int count = 0;
		ModelAndView mv = new ModelAndView();
		for (Employee e : emp) {
			if (e.id == id) {
				emp.remove(e);
				mv.addObject("result", "Employee Deleted from registry");
				break;
			} else if (emp.size() == count) {
				mv.addObject("result", "Emplyoee not found");
				break;
			}
			count++;
		}
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping("/updateUserById")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		String field = request.getParameter("field");
		String value = request.getParameter("value");
		final String name = "name";
		final String address = "address";
		final String gender = "gender";
		int count = 0;
		for (Employee e : emp) {
			if (e.id == id) {
				if (field.equals(name)) {
					e.setName(value);
				} else if (field.equals(address)) {
					e.setAddress(value);
				} else if (field.equals(gender)) {
					e.setGender(value);
				}
				mv.addObject("result", "Given field of Emplyoee updated");
			} else if (emp.size() == count) {
				mv.addObject("result", "Emplyoee not found");
				break;
			}
			count++;
		}
		mv.setViewName("result.jsp");
		return mv;
	}
}