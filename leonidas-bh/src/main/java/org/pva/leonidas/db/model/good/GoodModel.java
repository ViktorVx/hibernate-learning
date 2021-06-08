package org.pva.leonidas.db.model.good;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lds_good")
public class GoodModel {

    @Id
    @Column(name = "good_id")
    private String id;
    @Column(name = "good_title")
    private String title;
    @Column(name = "gtin")
    private String gtin;
    @Column(name = "good_description")
    private String description;
    @Column(name = "good_price")
    private BigDecimal price;
}
