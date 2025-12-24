package com.example.UserAuthentocation.controller;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.UserAuthentocation.entity.PasswordResetOtp;
import com.example.UserAuthentocation.entity.User;
import com.example.UserAuthentocation.repository.OtpRepository;
import com.example.UserAuthentocation.repository.UserRepository;
import com.example.UserAuthentocation.service.EmailService;

public class PasswordController {

	@Autowired
	OtpRepository otpRepository;
	@Autowired
	EmailService emailService;

	@Autowired
	UserRepository userRepository ;

	@PostMapping("/forgot-password")
	public String forgotPassword(String email) {
	    String otp = String.valueOf(new Random().nextInt(900000) + 100000);

	    PasswordResetOtp resetOtp = new PasswordResetOtp();
	    resetOtp.setEmail(email);
	    resetOtp.setOtp(otp);
	    resetOtp.setExpiryTime(LocalDateTime.now().plusMinutes(5));

	    otpRepository.save(resetOtp);
	    emailService.sendOtpEmail(email, otp);

	    return "verify-otp";
	}


	@PostMapping("/verify-otp")
	public String verifyOtp(String email, String otp) {

	    PasswordResetOtp resetOtp =
	            otpRepository.findByEmailAndOtp(email, otp);

	    if (resetOtp != null &&
	        resetOtp.getExpiryTime().isAfter(LocalDateTime.now())) {
	        return "reset-password";
	    }
	    return "verify-otp";
	}


	@PostMapping("/reset-password")
	public String resetPassword(String email, String password) {

	    User user = userRepository.findByEmail(email).orElse(null);
	    if (user != null) {
	        user.setPassword(new BCryptPasswordEncoder().encode(password));
	        userRepository.save(user);
	    }
	    return "login";
	}



}
