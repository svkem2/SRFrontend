package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.ConcatenateFileGroup;

/* Concatenate File Group CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
public interface ConcatenateFileGroupAccess {

    public abstract void insert(ConcatenateFileGroup newGroup);

    public abstract void update(ConcatenateFileGroup group);

    public abstract ConcatenateFileGroup findById(int groupId);

    public abstract List<ConcatenateFileGroup> getAll();
}
