package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.FilePath;

/* File Path CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface FilePathAccess {
	public abstract void insert(FilePath newFilePath);

	public abstract void update(FilePath filePath);

	public abstract FilePath findById(int filePathId);

	public abstract List<FilePath> getAll();
}
