package org.pva.leonidas.telegram.bot.provider;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsInfoProvider {

    public List<String> getGoodsList() {
        return List.of("good1", "good2");
    }

    public String getGood() {
        return "Good1";
    }
}
