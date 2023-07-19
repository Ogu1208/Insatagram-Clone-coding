package com.ogu.instagram.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users",
        indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "username", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "modifiedAt")
})
public class User extends AuditingFields{

    @Id  // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키가 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private long id;  // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "username", nullable = false)  // not null
    private String username;

    @Column(name = "nickname", nullable = false, length = 20)  // not null
    private String nickname;

    @Column(name = "email", nullable = false)  // not null
    private String email;

    @Column(name = "password", nullable = false)  // not null
    private String password;

    @Column(nullable = false)
    private String introduce;

    @Builder
    public User(String username, String nickname, String email, String password, String introduce) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.introduce = introduce;
    }

    public void updateUsername(String uswername) { this.username = uswername; }

    public void updateNickname(String uswername) { this.nickname = uswername; }

    public void updateEmail(String email) { this.email = email; }

    public void updateIntroduce(String introduce) { this.introduce = introduce; }

}
