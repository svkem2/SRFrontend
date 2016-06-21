package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.FieldFunction;

/* Field Function CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface FieldFunctionAccess {

    public abstract void insert(FieldFunction newFieldFunction);

    public abstract void update(FieldFunction fieldFunction);

    public abstract FieldFunction findById(int fieldFunctionId);

    public abstract List<FieldFunction> getAll();
}
