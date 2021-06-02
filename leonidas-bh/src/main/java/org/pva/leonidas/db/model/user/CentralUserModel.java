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
@Table(name = "telegram_user")
public class CentralUserModel {

    @Id
    @Column(name = "central_user_id")
    private String id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "telegram_user")
    private TelegramUserModel telegramUser;
}
