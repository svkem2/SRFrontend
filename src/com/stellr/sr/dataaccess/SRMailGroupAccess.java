package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.SRMailGroup;

/* Field Function CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface SRMailGroupAccess {

    public abstract void insert(SRMailGroup newSRmailGroup);

    public abstract void update(SRMailGroup srMailGroup);

    public abstract SRMailGroup findById(int srMailGroupId);

    public abstract List<SRMailGroup> getAll();
}
