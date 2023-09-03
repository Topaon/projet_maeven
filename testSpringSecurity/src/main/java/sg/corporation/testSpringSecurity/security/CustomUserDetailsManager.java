/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sg.corporation.testSpringSecurity.security;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.util.Assert;

/**
 * Non-persistent implementation of {@code UserDetailsManager} which is backed by an
 * in-memory map.
 * <p>
 * Mainly intended for testing and demonstration purposes, where a full blown persistent
 * system isn't required.
 *
 * @author Luke Taylor
 * @since 3.1
 */
public class CustomUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

	protected final Log logger = LogFactory.getLog(getClass());

	private final Map<String, UserDetails> users = new HashMap<>();

	private AuthenticationManager authenticationManager;

	// 1er
	public CustomUserDetailsManager(UserDetails... users) {
		System.out.println("CustomUserDetailsManager");
		for (UserDetails user : users) {
			createUser(user);
		}
	}
	// 3ème
	public UserDetails getNewUserDetails() {
		System.out.println("getNewUserDetails");
		PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserDetails user = User.builder()
				.username("simon")
				.password(delegatingPasswordEncoder.encode("ekko"))
				.roles("USER")
				.build();
		return user;
	}

	
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	// à l'authentification
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return users.get(username);
	}


	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		System.out.println("updatePassword");
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void createUser(UserDetails user) {
		Assert.isTrue(!userExists(user.getUsername()), "user should not exist");
		this.users.put(user.getUsername().toLowerCase(), user);
	}


	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	// 2ème
	@Override
	public boolean userExists(String username) {
		System.out.println("userExists");
		// TODO Auto-generated method stub
		return false;
	}

}
