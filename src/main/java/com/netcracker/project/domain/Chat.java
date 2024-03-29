package com.netcracker.project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "chat")
@NoArgsConstructor
public class Chat {
    @Id
    @Column(name = "chat_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID chatId;
    @Column(name = "name")
    @NonNull
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "chatList")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Attendee> attendeeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chatId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Message> messageList;
}