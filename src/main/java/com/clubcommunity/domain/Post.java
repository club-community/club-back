package com.clubcommunity.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    private String title;
    private String content;

    private String uploadFileName;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] photo;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] file;

    @Enumerated(EnumType.STRING)
    private NoticeVisibilityType noticeVisibilityType;

    @CreationTimestamp
    private LocalDateTime createAt = LocalDateTime.now();

    @CreationTimestamp
    private LocalDateTime updateAt = LocalDateTime.now();

    public void updateVideo(String title, String content) {
        this.title = (title != null)? title : this.title;
        this.content = (content != null)? content : this.content;
        this.updateAt = LocalDateTime.now();
    }
}
