package com.hcmute.oneforall.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.hcmute.oneforall.beans.Account;
import com.hcmute.oneforall.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping(value = "/account")
public class LoginController {
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping(value = "/{id}")
	public String account(Model model,
								 @PathVariable("id") int id){
		Account account = accountRepository.findById(id);
		model.addAttribute("account", account);
		return "layouts/account";
	}

	@GetMapping(value = "/{id}/edit")
	public String getHistory(Model model,
						  @PathVariable("id") int id){
		Account account = accountRepository.findById(id);
		model.addAttribute("account", account);
		return "layouts/editAccount";
	}

	@PostMapping(value = "/{id}/edit")
	public String postHistory(Model model,
						  @PathVariable("id") int id){
		Account account = accountRepository.findById(id);
		model.addAttribute("account", account);
		return "layouts/editAccount";
	}

	@GetMapping(value = "/login")
	public String login(Model model, HttpSession session){
		model.addAttribute("account", new Account());
		if (session.getAttribute("auth") == null){
			session.getAttribute("auth");
			session.getAttribute("authAcc");

			return "layouts/login";
		}

		return "redirect:/";
	}

	@PostMapping(value = "/login")
	public String login(@ModelAttribute("account") Account account,
						@RequestParam(value = "confirmPassword", required = false) String confirmPassword,
						ModelMap modelMap,
						HttpServletRequest request){
		String password = Objects.requireNonNull(account.getMat_khau());
		HttpSession session = request.getSession();

		//	Sign up
		Account authAcc = accountRepository.findByEmail(account.getEmail());
		if (confirmPassword != null) {
			if (authAcc == null) {
				String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());

				account.setMat_khau(bcryptHashString);
				accountRepository.save(account);

				setSession(session, account);

				return "redirect:/account/edit";
			}

			return "redirect:/account/login";
		}

		//	login
		if (authAcc != null){
			BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), authAcc.getMat_khau());
			if (result.verified) {
				setSession(session, account);

				return "redirect:/";
			} else {
				request.setAttribute("hasError", true);
				return "redirect:/account/login";
			}
		}

		request.setAttribute("hasError", true);
		return "redirect:/account/login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request){
		endSession(request.getSession());
		return "redirect:/";
	}

	private void setSession(HttpSession session, Account account){
		session.setAttribute("auth", true);
		session.setAttribute("authAcc", account);
	}

	private void endSession(HttpSession session){
		session.setAttribute("auth", null);
		session.setAttribute("authAcc", null);
	}
}