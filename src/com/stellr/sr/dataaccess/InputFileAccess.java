package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.InputFile;

/* Input File CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

public interface InputFileAccess {
	public abstract void insert(InputFile newInputFile);
	public abstract void update(InputFile inputFile);
	public abstract InputFile findById(int inputFileId);
	public abstract List<InputFile> getAll();
}
