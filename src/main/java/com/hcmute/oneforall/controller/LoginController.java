package com.hcmute.oneforall.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.hcmute.oneforall.beans.Account;
import com.hcmute.oneforall.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
						  @PathVariable("id") int id,
						  HttpSession session){
		if(session.getAttribute("auth") != null){
			Account account = accountRepository.findById(id);
			model.addAttribute("account", account);

			return "layouts/account";
		}

		return "redirect:/404";
	}

	@GetMapping(value = "/{id}/edit")
	public String getEditAccount(Model model,
								 @PathVariable("id") int id,
								 HttpSession session){
		if(session.getAttribute("auth") != null){
			System.out.println(session.getAttribute("authAcc"));
			Account account = accountRepository.findById(id);
			model.addAttribute("account", account);

			return "layouts/editAccount";
		}

		return "redirect:/404";
	}

	@PostMapping(value = "/{id}/edit")
	public String postEditAccount(@ModelAttribute("account") Account account,
								  @PathVariable("id") int id,
								  Model model){
		Account authAcc = accountRepository.findById(id);
		String mat_khau = Objects.requireNonNull(account.getMat_khau());
		BCrypt.Result result = BCrypt.verifyer().verify(mat_khau.toCharArray(), authAcc.getMat_khau());
		if (result.verified) {
			accountRepository.update(account.getId(),
					account.getHo(),
					account.getTen(),
					account.getNgay_sinh(),
					account.isGioi_tinh(),
					account.getEmail(),
					account.getSdt()
			);
			model.addAttribute("success", true);
		}else {
			model.addAttribute("success", false);
		}

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

		return "redirect:/404";
	}

	@PostMapping(value = "/login")
	public String login(@ModelAttribute("account") Account account,
						@RequestParam(value = "confirmPassword", required = false) String confirmPassword,
						Model model,
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
				String id = Integer.toString(account.getId());

				return "redirect:/account/" + id + "/edit";
			}

			return "layouts/login";
		}

		//	login
		if (authAcc != null){
			BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), authAcc.getMat_khau());
			if (result.verified) {
				setSession(session, authAcc);

				return "redirect:/";
			} else {
				model.addAttribute("hasError", true);
				return "layouts/login";
			}
		}

		model.addAttribute("hasError", true);
		return "layouts/login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session){
		endSession(session);
		return "redirect:/";
	}

	private void setSession(HttpSession session, Account account){
		session.setAttribute("auth", true);
		session.setAttribute("authAcc", account);
		session.setAttribute("id", account.getId());
		session.setAttribute("ho", account.getHo());
		session.setAttribute("ten", account.getTen());
		session.setAttribute("role", account.isPhan_quyen());
	}

	private void endSession(HttpSession session){
		session.setAttribute("auth", null);
		session.setAttribute("authAcc", null);
		session.setAttribute("id", null);
		session.setAttribute("ho", null);
		session.setAttribute("ten", null);
		session.setAttribute("role", null);
	}
}