package com.example.demo.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.lang.reflect.Field;

public class AutoTimeListener {

    @PrePersist
    public void prePersist(Object entity) {
        int now = (int) (System.currentTimeMillis() / 1000);

        setField(entity, "createTime", now, true);
        setField(entity, "updateTime", now, false);
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        int now = (int) (System.currentTimeMillis() / 1000);

        setField(entity, "updateTime", now, false);
    }

    private void setField(Object entity, String fieldName, int value, boolean onlyIfNullOrZero) {
        try {
            Field field = entity.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object current = field.get(entity);

            if (onlyIfNullOrZero) { // createTime 只在空时填充
                if (current == null || (current instanceof Integer && (Integer) current == 0)) {
                    field.set(entity, value);
                }
            } else {
                field.set(entity, value);
            }
        } catch (Exception ignored) {}
    }
}
