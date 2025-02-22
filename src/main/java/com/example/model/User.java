package com.example.model;

import com.example.model.enums.Role;
import com.example.model.enums.TokenClaims;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public Map<String, Object> getClaims() {
        final Map<String, Object> claims = new HashMap<>();
        claims.put(TokenClaims.ID.getValue(), this.id);
        claims.put(TokenClaims.USERNAME.getValue(), this.username);
        claims.put(TokenClaims.ROLES.getValue(), this.role);
        claims.put(TokenClaims.USER_FULL_NAME.getValue(), this.username);
        claims.put(TokenClaims.EMAIL.getValue(), this.email);
        return claims;
    }

}
