package com.himalaya.aqua.aqua.web.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himalaya.aqua.aqua.core.basic.ResultVO;
import com.himalaya.aqua.aqua.core.entity.User;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;
import com.himalaya.aqua.aqua.core.validator.UserValidator;
import com.himalaya.aqua.aqua.services.UserService;
import com.himalaya.aqua.aqua.services.security.SecurityService;

@RestController
@RequestMapping("/api/users")
public class UserWS {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	public static final String RESPONSE_FAILURE = "FAILURE";

	@PostMapping("/registration")
	public Long save(@RequestBody User user, BindingResult bindingResult) throws HimalayaAquaException {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return 0L;
		}
		Long userId = userService.save(user);
		securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

		return userId;
	}

	@GetMapping(value = "/{username}")
	public ResultVO<User> findById(@PathVariable("username") String username) throws HimalayaAquaException {
		return new ResultVO<User>(userService.findByUsername(username));
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
