package com.emp.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.CollectionId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {
	
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	private static final Log logger = LogFactory.getLog(User.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USERNAME")
	private  String username;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "AUTHORITIES")
	private String auth;
	
	@Transient
	private  Set<GrantedAuthority> authorities;

	@Column(name = "ACCOUNT_NON_EXPIRED")
	private  boolean accountNonExpired;

	@Column(name = "ACCOUNT_NON_LOCKED")
	private boolean accountNonLocked;

	@Column(name = "CREDENTIALS_NON_EXPIRED")
	private  boolean credentialsNonExpired;

	@Column(name = "ENABLED")
	private  boolean enabled;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] auths = this.auth.split(",");	
		return AuthorityUtils.createAuthorityList(auths);
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName()).append(" [");
		sb.append("Username=").append(this.username).append(", ");
		sb.append("Password=[PROTECTED], ");
		sb.append("Enabled=").append(this.enabled).append(", ");
		sb.append("AccountNonExpired=").append(this.accountNonExpired).append(", ");
		sb.append("credentialsNonExpired=").append(this.credentialsNonExpired).append(", ");
		sb.append("AccountNonLocked=").append(this.accountNonLocked).append(", ");
		sb.append("Granted Authorities=").append(this.authorities).append("]");
		return sb.toString();
	}


}
