package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.FileCompareGroup;

/* File Compare Group CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface FileCompareGroupAccess {
	public abstract void insert(FileCompareGroup newGroup);
	public abstract void update(FileCompareGroup group);
	public abstract FileCompareGroup findById(int groupId);
	public abstract List<FileCompareGroup> getAll();
}
