package com.demwis.tests.gilan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Entity
@IdClass(UserAuthority.Pk.class)
public class UserAuthority implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String userId;

    @Id
    private String authorityId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        private static final long serialVersionUID = 1L;

        private String userId;

        private String authorityId;
    }
}
