package com.himalaya.aqua.aqua.web.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.himalaya.aqua.aqua.core.basic.ResultVO;
import com.himalaya.aqua.aqua.core.entity.User;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;
import com.himalaya.aqua.aqua.core.validator.UserValidator;
import com.himalaya.aqua.aqua.services.UserService;
import com.himalaya.aqua.aqua.services.security.SecurityService;

@Controller
public class UserWSBackup {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	public static final String RESPONSE_FAILURE = "FAILURE";
	
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

	@GetMapping("/login")
	public String login(Model model, String error, String logout) throws HimalayaAquaException {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@PostMapping("/registration")
	public String save(@RequestBody User user, BindingResult bindingResult) throws HimalayaAquaException {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userService.save(user);
		securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

		return "redirect:/welcome";
	}
	
    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

	@ExceptionHandler(IllegalArgumentException.class)
	public ResultVO<Object> handleNotFoundException(IllegalArgumentException ex) {
		ResultVO<Object> resultVO = new ResultVO<>();
		resultVO.setStatus(RESPONSE_FAILURE);
		resultVO.setStatusCode(500);
		resultVO.setStatusMsg(ex.getMessage());
		ex.printStackTrace();
		return resultVO;
	}
}
