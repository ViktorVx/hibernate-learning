package org.pva.leonidas.db.repository;

import org.pva.leonidas.db.model.good.GoodModel;
import org.springframework.data.repository.CrudRepository;

public interface GoodRepository extends CrudRepository<GoodModel, String> {
}
