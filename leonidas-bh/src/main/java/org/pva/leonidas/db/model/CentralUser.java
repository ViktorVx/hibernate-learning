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
public class CentralUser {

    @Id
    @Column(name = "central_user_id")
    String id;

    @Column(name = "phone_number")
    String phoneNumber;

}
