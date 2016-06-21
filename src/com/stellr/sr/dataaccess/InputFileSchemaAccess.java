package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.InputFileSchema;

/* Input File Schema CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface InputFileSchemaAccess {
	public abstract void insert(InputFileSchema newInputFileSchema);

	public abstract void update(InputFileSchema inputFileSchema);

	public abstract InputFileSchema findById(int inputFileSchemaId);

	public abstract List<InputFileSchema> getAll();
}
