package com.example.introtospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girl {
    @Autowired
    Outfit outfit;

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }

//    public Outfit getOutfit() {
//        return outfit;
//    }
//
//    public void setOutfit(Outfit outfit) {
//        this.outfit = outfit;
//    }
}
