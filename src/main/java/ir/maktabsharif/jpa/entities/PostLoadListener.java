package ir.maktabsharif.jpa.entities;

import jakarta.persistence.PostLoad;

public class PostLoadListener {

    @PostLoad
    public void postLoadOperation(Object entity) {
        System.out.println("post load operation for entity: " + entity.getClass().getSimpleName());
    }
}
