package com.ogu.instagram.post;

import com.ogu.instagram.common.domain.AuditingFields;
import com.ogu.instagram.common.vo.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "post_images")
public class PostImage extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Embedded
    private Image image;

    @Builder
    public PostImage(Post post, Image image){
        this.post = post;
        this.image = image;
    }

}
