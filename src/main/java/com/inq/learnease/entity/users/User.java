package com.inq.learnease.entity.users;

import com.inq.learnease.entity.BaseEntity;
import com.inq.learnease.entity.Goal;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    
    @Embedded
    private Email loginId;
    
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    
    @Column(name = "nickname", length = 255, nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "user")
    private List<Goal> goals;
    
    public User(Email loginId, String password, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
    }
    
    public void changeNickname(final String nickname) {
        this.nickname = nickname;
    }
}
