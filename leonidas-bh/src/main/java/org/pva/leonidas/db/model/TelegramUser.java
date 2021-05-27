package org.pva.leonidas.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telegram_user")
public class TelegramUser {
    @Id
    @Column(name = "telegram_user_id")
    private String id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_info")
    private String info;
}
