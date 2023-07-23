package com.ogu.instagram.common.vo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Builder
@Embeddable
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
    @Lob
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    private String imageName;

    private String imageUUID;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 20)
    private String createdBy; // 생성자

    public void setUrl(String url) {
        this.imageUrl = url;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImageUUID());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Image image = (Image)obj;
        return Objects.equals(getImageUUID(), image.getImageUUID());
    }
}
