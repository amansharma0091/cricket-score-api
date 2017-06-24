package com.test.iplapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.iplapi.models.Delivery;
import com.test.iplapi.models.DeliveryDao;
import com.test.iplapi.models.Match;
import com.test.iplapi.models.MatchDao;

@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "IPL API";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/delivery-by-over")
	@ResponseBody
	public Delivery deliveryByOver(Integer match, Integer inning, Integer over, Integer ball) {
		try {
			Delivery delivery = deliveryDao.getDelivery(match, inning, over, ball);
			return delivery;
		} catch (Exception ex) {
			return null;
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/matches-on-date")
	@ResponseBody
	public List<Match> matchesOnDate(String date) {
		List<Match> matches = new ArrayList<Match>();
		try {
			matches.addAll(matchDao.getMatchesOnDate(date));
		} catch (Exception ex) {
			return null;
		}
		return matches;
	}

	@Autowired
	private DeliveryDao deliveryDao;
	
	@Autowired
	private MatchDao matchDao;
	
	public static void main(String[] args) throws Exception {

	}
}
