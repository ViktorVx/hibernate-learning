package org.pva.leonidas.db.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lds_telegram_user")
public class TelegramUserModel {
    @Id
    @Column(name = "telegram_user_id")
    private String id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_info")
    private String info;
}
