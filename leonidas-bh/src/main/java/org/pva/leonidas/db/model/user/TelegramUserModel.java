package org.pva.leonidas.db.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "language_code")
    private String languageCode;
    @Column(name = "is_bot")
    @Type(type = "yes_no")
    private boolean bot;
}
