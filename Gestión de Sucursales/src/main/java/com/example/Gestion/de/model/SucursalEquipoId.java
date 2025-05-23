package com.example.Gestion.de.model;

import java.io.Serializable;
import java.util.Objects;

public class SucursalEquipoId implements Serializable {
    private Long sucursalId;
    private Long equipoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SucursalEquipoId that)) return false;
        return Objects.equals(sucursalId, that.sucursalId) && Objects.equals(equipoId, that.equipoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sucursalId, equipoId);
    }
}
